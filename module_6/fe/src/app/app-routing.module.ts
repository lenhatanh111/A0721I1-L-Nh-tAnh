import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {DetailComponent} from "./component/detail/detail.component";
import {HomepageComponent} from "./component/homepage/homepage.component";
import {CartComponent} from "./component/cart/cart.component";
import {SearchComponent} from "./component/search/search.component";
import {ProductOfCategoryComponent} from "./component/product-of-category/product-of-category.component";


const routes: Routes = [
  {path: "login",
  component: LoginComponent},
  {
    path: "detail/:id",
    component: DetailComponent
  },
  {
    path: "homepage",
    component: HomepageComponent
  },
  {
    path: "cart",
    component: CartComponent
  },
  {
    path: "searchProduct/:name",
    component: SearchComponent
  },
  {
    path: "productOfCategory/:id",
    component: ProductOfCategoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
