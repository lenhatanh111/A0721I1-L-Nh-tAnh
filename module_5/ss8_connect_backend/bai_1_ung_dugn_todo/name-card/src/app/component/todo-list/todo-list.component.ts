import { Component, OnInit } from '@angular/core';
import {TodoService} from "../../service/todo.service";
import {Todo} from "../../model/todo";
import {FormControl} from "@angular/forms";
let _id = 1;
@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
todos :Todo[]=[];
  content = new FormControl();
  constructor(private todoService:TodoService) { }

  ngOnInit(): void {
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

}
