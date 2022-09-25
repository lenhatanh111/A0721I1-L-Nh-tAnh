import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cart} from "../model/cart";
const URL='http://localhost:8080/api/cart'
@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }
  getCartById(id: number): Observable<Cart>{
    return this.http.get<Cart>(URL +'/user/'+ id)
  }
}
