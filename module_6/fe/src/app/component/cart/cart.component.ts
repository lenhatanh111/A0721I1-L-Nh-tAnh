import { Component, OnInit } from '@angular/core';
import {CartService} from "../../service/cart.service";
import {TokenStorageService} from "../../service/token-storage-service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ProductServiceService} from "../../service/product-service.service";
import {Product} from "../../model/product";
import {CartDetailService} from "../../service/cart-detail.service";
import {UserService} from "../../service/user.service";
import {CartDetailDto} from "../../dto/cart-detail-dto";
import {TotalDto} from "../../dto/total-dto";
import {ToastrService} from "ngx-toastr";
import {FormControl, FormGroup} from "@angular/forms";
import {PaypalService} from "../../service/paypal.service";
import {OrderDetailService} from "../../service/order-detail.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
cart: CartDetailDto[];
user: any;
total: TotalDto;
userDetail: any;
quantity: number;
cartDetail: any;
productName: string;
cd_id: number;
link: string;
isPayed: boolean=false;
cart_id: number;

  constructor(private cartDetailService: CartDetailService,private tokenStorageService: TokenStorageService,private activatedRoute: ActivatedRoute
  , private productServiceService: ProductServiceService, private router: Router, private userService: UserService,private cartService: CartService,
              private toast: ToastrService, private paypalService: PaypalService,private orderDetailService: OrderDetailService,) {
    this.user = this.tokenStorageService.getUser();
    if (this.user != null){
      this.getCartByUserId();

  this.getUserDetail();
  this.getTotal()

  }else {
      this.router.navigateByUrl('/login')
    }
  }

  ngOnInit(): void {
  }
  getCartByUserId(){
    this.cartDetailService.getCartDetailByUserId(this.user.id).subscribe(cart=>{
      this.cart=cart;
    })
  }
  getUserDetail(){
    this.userService.getUserById(this.user.id).subscribe(user=>{
      this.userDetail=user;
    })
  }
getTotal(){
   this.cartDetailService.getTotal(this.user.id).subscribe(total=>{
     this.total=total;
   })
}
setQuantity(productId: number,quantity: number){
    this.cartDetailService.setQuantityOfProduct(this.user.id,productId,quantity).subscribe(cart=>{
      this.toast.success("thành công")
    },error => {
      this.toast.error("thất bại")
    })
}
decrease(productId: number,quantity: number){
    quantity=quantity+1;
    this.setQuantity(productId,quantity);
    window.location.reload()
}
  reduced(productId: number,quantity: number){
    if (quantity>=1){
    quantity=quantity-1;
    this.setQuantity(productId,quantity);
      window.location.reload()
  }else {
      this.toast.error("thất bại")
    }
  }
  deleteProduct(id: number){
    this.cartDetailService.deleteProductByCartDetailId(id).subscribe(cartDetail=>{
      this.cartDetail=cartDetail;
      window.location.reload();

    })
  }

  infoDelete(id: number,cd_id: number) {
    this.productServiceService.getProductById(id).subscribe(product=>{
      this.productName=product.name;
      this.cd_id=cd_id;
      this.toast.success("xóa thành công");

    },error => {
      this.toast.error("xóa thất bại");
    })

  }
payment(price: number){
    this.paypalService.pay(price).subscribe(payment=>{
      this.link=payment.link;
      this.isPayed=true;
      this.addToOrderDt();
    })

}
  addToOrderDt(){
    this.cart_id=this.tokenStorageService.getCart();
    console.log(this.cart_id)
    this.orderDetailService.addToCartDetail(this.cart_id).subscribe(cartDt=>{
      this.toast.success("thanh toan thanh cong")
      console.log(cartDt)
    },error => {
      this.toast.error("thanh toan that bai")
    })
  }


}
