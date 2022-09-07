import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerType} from "../model/customer-type";
const URL=" http://localhost:3000/customerTypes"
@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  constructor(private httpClient:HttpClient) { }
  getAll() :Observable<CustomerType[]>{
    return this.httpClient.get<CustomerType[]>(URL);
  }
  findById(id : number):Observable<CustomerType>{
    return this.httpClient.get<CustomerType>(URL+"/"+id);
  }
}
