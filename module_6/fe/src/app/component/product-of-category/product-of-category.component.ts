import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../../service/product-service.service";
import {Product} from "../../model/product";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-product-of-category',
  templateUrl: './product-of-category.component.html',
  styleUrls: ['./product-of-category.component.css']
})
export class ProductOfCategoryComponent implements OnInit {
  id: number
  indexPagination = 0;
  number: number;
  products: Product[];
  totalPages: number;
  size: number;
  message: string;
  constructor(private productServiceService: ProductServiceService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
     this.getProductOfCategory();
    });
  }

  ngOnInit(): void {
    this.getProductOfCategory();
  }
  previousPage() {
    this.indexPagination -= 1;
    this.getProductOfCategory();
  }

  nextPage() {
    this.indexPagination += 1;
    this.getProductOfCategory();
  }
getProductOfCategory(){
  this.productServiceService.getProductByCategoryId(this.id,this.indexPagination).subscribe(product => {
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
}
