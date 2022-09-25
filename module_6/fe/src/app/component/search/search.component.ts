import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CartDetailService} from "../../service/cart-detail.service";
import {ToastrService} from "ngx-toastr";
import {TokenStorageService} from "../../service/token-storage-service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  name: string;
  indexPagination = 0;
  number: number;
  products: Product[];
  totalPages: number;
  size: number;
  message: string;
  user: any;
  constructor(private productServiceService: ProductServiceService, private cartDetailService: CartDetailService,
              private toast: ToastrService, private tokenStorageService: TokenStorageService,
              private router: Router, private activatedRoute: ActivatedRoute) {
    this.user=this.tokenStorageService.getUser();
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.name = paramMap.get('name');
      this.getProductByName();
      console.log(this.products);
      console.log(this.name)
    });
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
    this.productServiceService.searchProduct(this.name, this.indexPagination).subscribe(product => {
      if (product.content != null) {
        this.products = product.content;
        this.indexPagination = product.number;
        this.size = product.size;
        this.totalPages = product.totalPages;
        this.number = product.totalElements;
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
        // this.tokenStorageService.saveCartLocal(cart.amount);
        this.router.navigateByUrl("/homepage")
      },error => {
        this.toast.error("Thêm vào giỏ hàng thất bại");
        this.router.navigateByUrl("/homepage")
      })
    }
  }

}
