import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { HomepageComponent } from './component/homepage/homepage.component';
import { DetailComponent } from './component/detail/detail.component';
import { CartComponent } from './component/cart/cart.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { HeaderComponent } from './component/header-footer/header/header.component';
import { FooterComponent } from './component/header-footer/footer/footer.component';
import {ToastrModule} from "ngx-toastr";
import { SearchComponent } from './component/search/search.component';
import { ProductOfCategoryComponent } from './component/product-of-category/product-of-category.component';
import { PaymentSucessComponent } from './component/payment-sucess/payment-sucess.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    DetailComponent,
    CartComponent,
    HeaderComponent,
    FooterComponent,
    SearchComponent,
    ProductOfCategoryComponent,
    PaymentSucessComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
