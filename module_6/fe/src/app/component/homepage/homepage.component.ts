import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ProductDto} from "../../dto/product-dto";
import {Product} from "../../model/product";
import {CartDetailService} from "../../service/cart-detail.service";
import {ToastrService} from "ngx-toastr";
import {TokenStorageService} from "../../service/token-storage-service";
import {CartService} from "../../service/cart.service";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  indexPagination = 0;
  number: number;
  products: Product[];
  totalPages: number;
  size: number;
  message: string;
  user: any;
  cart: any;
  constructor(private productServiceService: ProductServiceService, private cartDetailService: CartDetailService,
              private toast: ToastrService, private tokenStorageService: TokenStorageService,private cartService: CartService,
              private router: Router) {
    this.getProductByName();
this.getCart();
  }

  ngOnInit(): void {
    this.getProductByName();
  }
  previousPage() {
    this.indexPagination -= 1;
    this.getProductByName();
  }

  nextPage() {
    this.indexPagination += 1;
    this.getProductByName();
  }
  getProductByName() {
    this.productServiceService.getAllProduct(this.indexPagination).subscribe(product => {
      if (product.content != null) {
        this.products = product.content;
        this.indexPagination = product.number;
        this.size = product.size;
        this.totalPages = product.totalPages;
        this.number = product.totalElements;
        console.log(this.products)
      }
      if (product.content.length !== 0) {
        this.message = '';
      } else {
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

        this.router.navigateByUrl("/homepage")
      },error => {
        this.toast.error("Thêm vào giỏ hàng thất bại");
        this.router.navigateByUrl("/homepage")
      })
    }
  }
  getCart() {
    if (this.user != null) {
      this.cartDetailService.getCartDetailByUserId(this.user.id).subscribe(cart => {
        this.cart = cart;
        console.log(this.cart)

      })
    }
  }


}
