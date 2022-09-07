import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Customer} from "../model/customer";
import {catchError, tap} from "rxjs/operators";
const URL="http://localhost:3000/customers"
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient:HttpClient) {}
    getAll() :Observable<Customer[]>{
      return this.httpClient.get<Customer[]>(URL);
    }
    save(customer):Observable<Customer>{
      return this.httpClient.post<Customer>(URL,customer);
    }
    findById(id : string):Observable<Customer>{
      return this.httpClient.get<Customer>(URL+"/"+id);
    }
    update(id: string, customer: Customer): Observable<Customer> {
      return this.httpClient.put<Customer>(URL+"/"+id, customer);
    }

    delete(id: string): Observable<Customer> {
      return this.httpClient.delete<Customer>(URL+"/"+id).pipe(tap(_=>console.log(`delete product by id = ${id}`)),
        catchError(error => of (null)));
    }

}
