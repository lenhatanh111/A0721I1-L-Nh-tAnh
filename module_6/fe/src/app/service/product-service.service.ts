import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductCategory} from "../model/product-category";
import {ProductDto} from "../dto/product-dto";
import {ProductDetail} from "../dto/product-detail";
const URL='http://localhost:8080/api/product'
@Injectable({
  providedIn: 'root'
})

export class ProductServiceService {

  constructor(private http: HttpClient) { }
searchProduct(name: string, page: number):Observable<ProductDto>{
    return this.http.get<ProductDto>(URL+ '/search?name=' + name +'&page=' +page);
}
getAllProduct(page: number):Observable<ProductDto>{
    return this.http.get<ProductDto>(URL+ '/all?page=' + page);
  }
  getProductByCategoryId(id: number, page: number):Observable<ProductDto>{
    return this.http.get<ProductDto>(URL+ '/category/' + id + '?page=' + page);
  }
  getProductDetail(id: number):Observable<ProductDetail>{
    return this.http.get<ProductDetail>(URL+ '/detail/' + id );
  }
}
