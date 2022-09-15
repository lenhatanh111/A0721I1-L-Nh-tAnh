import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {ProductDto} from "../../dto/product-dto";
import {Product} from "../../model/product";

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
  constructor(private productServiceService: ProductServiceService) {
    this.getProductByName();
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

}
