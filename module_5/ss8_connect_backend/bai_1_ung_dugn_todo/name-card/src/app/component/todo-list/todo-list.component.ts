import { Component, OnInit } from '@angular/core';
import {TodoService} from "../../service/todo.service";
import {Todo} from "../../model/todo";
import {FormControl} from "@angular/forms";
import {ActivatedRoute, ParamMap} from "@angular/router";
let _id = 1;
@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
todos :Todo[]=[];
todo:Todo;
id:number;
  content = new FormControl();
  constructor(private todoService:TodoService, private  activatedRoute :ActivatedRoute) {
    todoService.getAll().subscribe(next=>{
      this.todos=next;
    })
  }

  ngOnInit(): void {
    this.getAll();
  }
getAll() {
  this.todoService.getAll().subscribe(todos => {
    this.todos = todos;
  })
}
  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }
// send_id:number;

  // deleteModal(id: number) {
  //   console.log(id);
  //   this.send_id=id;
  //   this.todoService.delete(this.send_id).subscribe(next=>this.todos=this.todos.filter(each=>each.id!=id));
  // }


delete(id: number){
  this.todoService.delete(id).subscribe(next=>this.todos=this.todos.filter(each=>each.id!=id));
}
}
