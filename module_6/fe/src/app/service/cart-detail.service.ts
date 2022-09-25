import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CartDetail} from "../model/cart-detail";
import {Observable} from "rxjs";
import {CartDto} from "../dto/cart-dto";
import {CartDetailDto} from "../dto/cart-detail-dto";
import {TotalDto} from "../dto/total-dto";

const URL='http://localhost:8080/api/cart-detail'
@Injectable({
  providedIn: 'root'
})
export class CartDetailService {

  constructor(private http: HttpClient) { }
  addToCartDetail(userId: number, productId: number): Observable<CartDto>{
    return this.http.get<CartDto>(URL +'/addToCart/'+ userId + '/' + productId)
  }
  getCartDetailByUserId(id: number):Observable<CartDetailDto[]>{
    return this.http.get<CartDetailDto[]>(URL +'/getCartDetail/'+ id )
  }
  getTotal(id: number):Observable<TotalDto>{
    return this.http.get<TotalDto>(URL +'/getTotal/'+ id )
  }
setQuantityOfProduct(userId: number, productId: number, quantity: number):Observable<CartDto[]>{
    return this.http.get<CartDto[]>(URL +'/setQuantity/'+ userId + '/' + productId+'/'+quantity)
  }
  deleteProductByCartDetailId(id: number):Observable<CartDetail>{
    return this.http.get<CartDetail>(URL +'/deleteProduct/'+ id )
  }

}
