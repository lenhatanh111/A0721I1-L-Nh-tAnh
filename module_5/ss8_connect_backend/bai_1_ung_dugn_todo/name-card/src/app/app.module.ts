import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoComponent } from './component/todo-list/todo.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { TodoListComponent } from './component/todo-list/todo-list.component';
import { TodoAddComponent } from './component/todo-add/todo-add.component';
import { TodoEditComponent } from './component/todo-edit/todo-edit.component';
import { TodoDeleteComponent } from './component/todo-delete/todo-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    TodoListComponent,
    TodoAddComponent,
    TodoEditComponent,
    TodoDeleteComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
      HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
