import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productForm: FormGroup
  id : number
  product:Product
  constructor(private activatedRoute: ActivatedRoute,private productService:ProductService) {
    activatedRoute.paramMap.subscribe((param:ParamMap)=>{
this.id= +param.get('id');
      this.product=productService.findById(this.id);
    })
    this.productForm = new FormGroup({
      id: new FormControl(this.product.id),
      name: new FormControl(this.product.name),
      price: new FormControl(this.product.price),
      description: new FormControl(this.product.description),
    });
  }


  ngOnInit(): void {
  }
  updateProduct(id:number){
const product=this.productForm.value;
this.productService.update(id,product);

  }

}
