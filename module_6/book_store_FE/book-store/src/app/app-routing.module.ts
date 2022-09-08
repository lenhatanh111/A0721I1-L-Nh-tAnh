import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {DetailComponent} from "./component/detail/detail.component";
import {HomepageComponent} from "./component/homepage/homepage.component";
import {CartComponent} from "./component/cart/cart.component";


const routes: Routes = [
  {path: "login",
  component: LoginComponent},
  {
    path: "detail",
    component: DetailComponent
  },
  {
    path: "homepage",
    component: HomepageComponent
  },
  {
    path: "cart",
    component: CartComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
