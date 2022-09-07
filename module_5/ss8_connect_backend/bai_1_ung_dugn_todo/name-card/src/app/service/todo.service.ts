import {Injectable} from '@angular/core';
import {Todo} from "../model/todo";
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {environment} from "../../environments/environment";
import {catchError, tap} from "rxjs/operators";

const URL=`${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})

export class TodoService {
  constructor(private http: HttpClient) { }
  getAll() :Observable<Todo[]>{
    return this.http.get<Todo[]>(URL);
  }
  save(todo):Observable<Todo>{
    return this.http.post<Todo>(URL,todo);
  }
  findById(id : number):Observable<Todo>{
    return this.http.get<Todo>(URL+"/"+id);
  }
  update(id: number, todo: Todo): Observable<Todo> {
    return this.http.put<Todo>(URL+"/"+id, todo);
  }

  delete(id: number): Observable<Todo> {
    return this.http.delete<Todo>(URL+"/"+id).pipe(tap(_=>console.log(`delete product by id = ${id}`)),
      catchError(error => of (null)));
  }
}
