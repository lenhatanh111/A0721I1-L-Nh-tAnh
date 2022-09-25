import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PaypalDto} from "../dto/paypal-dto";
import {Observable} from "rxjs";
import {CartDto} from "../dto/cart-dto";
const URL='http://localhost:8080/api/pay'
@Injectable({
  providedIn: 'root'
})
export class PaypalService {

  constructor(private http: HttpClient) { }
  pay(price: number): Observable<PaypalDto>{
    return this.http.get<PaypalDto>(URL +'/pay?price='+price )
  }
}
