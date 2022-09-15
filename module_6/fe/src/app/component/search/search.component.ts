import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

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
  constructor(private productServiceService: ProductServiceService, private activatedRoute: ActivatedRoute) {
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


}
