import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {ProductDetail} from "../../dto/product-detail";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number
  product: ProductDetail;
  message: string;
  constructor(private productServiceService: ProductServiceService, private activatedRoute: ActivatedRoute) {
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
}
