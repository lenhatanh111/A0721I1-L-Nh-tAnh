import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {TodoService} from "../../service/todo.service";
import {Todo} from "../../model/todo";

@Component({
  selector: 'app-todo-delete',
  templateUrl: './todo-delete.component.html',
  styleUrls: ['./todo-delete.component.css']
})
export class TodoDeleteComponent implements OnInit {
id: number;
todo:Todo
  constructor(private activatedRoute: ActivatedRoute,private todoService: TodoService) {
    activatedRoute.paramMap.subscribe((param:ParamMap)=>{
      this.id= +param.get('id');
       todoService.findById(this.id).subscribe(next=>this.todo=next);

    })
  }
delete(id: number){
this.todoService.delete(id);
}
  ngOnInit(): void {
  }

}
