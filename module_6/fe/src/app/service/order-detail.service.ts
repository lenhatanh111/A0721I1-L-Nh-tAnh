import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrderDetail} from "../model/order-detail";
const URL ='http://localhost:8080/api/order-detail'
@Injectable({
  providedIn: 'root'
})

export class OrderDetailService {

  constructor(private http: HttpClient) { }
  addToCartDetail(id: number): Observable<OrderDetail>{
    return this.http.get<OrderDetail>( URL+'/addToOrderDt/'+ id);
  }
}
