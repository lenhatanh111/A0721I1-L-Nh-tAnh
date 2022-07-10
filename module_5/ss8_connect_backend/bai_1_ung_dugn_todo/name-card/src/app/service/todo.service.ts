import {Injectable} from '@angular/core';
import {Todo} from "../model/todo";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const URL='http://localhost:3000/todos';
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
    return this.http.get<Todo>(`${URL}/${id}`)
  }
  update(id: number, todo: Todo): Observable<Todo> {
    return this.http.put<Todo>(`${URL}/${id}`, todo);
  }

  delete(id: number): Observable<Todo> {
    return this.http.delete<Todo>(`${URL}/${id}`);
  }
}
