import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductCategory} from "../model/product-category";
const URL='http://localhost:8080/api/category/all'
@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {

  constructor(private http: HttpClient) { }
  getAllCategory(): Observable<ProductCategory>{
    return this.http.get<ProductCategory>(URL)
  }
}
