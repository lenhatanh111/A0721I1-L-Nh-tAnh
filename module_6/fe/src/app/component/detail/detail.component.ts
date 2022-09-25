import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ProductDetail} from "../../dto/product-detail";
import {CartDetailService} from "../../service/cart-detail.service";
import {ToastrService} from "ngx-toastr";
import {TokenStorageService} from "../../service/token-storage-service";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number
  product: ProductDetail;
  message: string;
  user: any;
  constructor(private productServiceService: ProductServiceService, private cartDetailService: CartDetailService,
              private toast: ToastrService, private tokenStorageService: TokenStorageService,
              private router: Router, private activatedRoute: ActivatedRoute) {
    this.user=this.tokenStorageService.getUser();
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProductDetail()
    });
  }

  ngOnInit(): void {
  }
getProductDetail(){
  this.productServiceService.getProductDetail(this.id).subscribe(product => {
    if (product != null) {
      this.product = product;
    }
    else {
      this.message = 'NOT FOUND';
    }
  });
}
  addToCart(id: number){
    this.user =this.tokenStorageService.getUser();
    if (this.user==null){
      this.router.navigateByUrl('/login');
    }else {
      this.cartDetailService.addToCartDetail(this.user.id,id).subscribe(cart=>{
        this.toast.success("Thêm vào giỏ hàng thành công");
        alert("Thêm vào giỏ hàng thành công")
        // this.tokenStorageService.saveCartLocal(cart.amount);
        this.router.navigateByUrl("/homepage")
      },error => {
        this.toast.error("Thêm vào giỏ hàng thất bại");
        this.router.navigateByUrl("/homepage")
      })
    }
  }

}
