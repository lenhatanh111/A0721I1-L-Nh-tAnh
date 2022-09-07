import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoListComponent} from "./component/todo-list/todo-list.component";
import {TodoDeleteComponent} from "./component/todo-delete/todo-delete.component";


const routes: Routes = [
  {
    path: "", component: TodoListComponent
  },
   {
    path:"delete/:id",component:TodoDeleteComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
