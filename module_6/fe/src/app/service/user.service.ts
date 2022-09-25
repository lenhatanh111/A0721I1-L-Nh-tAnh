import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Users} from "../model/users";
const URL='http://localhost:8080/api/user'
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  getUserById(id: number):Observable<Users>{
    return this.http.get<Users>(URL+ '/detail/' + id );
  }
}
