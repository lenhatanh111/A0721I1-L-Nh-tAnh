import { Component, OnInit } from '@angular/core';
import {CategoryServiceService} from "../../../service/category-service.service";
import {Router} from "@angular/router";
import {TokenStorageService} from "../../../service/token-storage-service";
import {FormControl, FormGroup} from "@angular/forms";
import {CartDetailService} from "../../../service/cart-detail.service";
import {CartDetailDto} from "../../../dto/cart-detail-dto";
import {CartService} from "../../../service/cart.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
categories: any;
user: any;
name: any;
cart: any;
amount: number=0;

  searchForm: FormGroup = new FormGroup({
    name: new FormControl('')
  });

  constructor(private categoryService: CategoryServiceService, private router: Router,
              private tokenStorageService: TokenStorageService, private cartDetailService: CartDetailService,
              private cartService: CartService) {
    this.getAllCategory();
    this.user=this.tokenStorageService.getUser();
   this.getCart();
this.getAmount();
  }

  ngOnInit(): void {
  }
getAllCategory(){
    this.categoryService.getAllCategory().subscribe(category=>{
      this.categories=category;
    })
}
logout(){
    this.tokenStorageService.signOut();
   this.router.navigateByUrl('/homepage');
  // window.location.reload()
}
onSearch(){
  this.name=this.searchForm.value.name;
  this.router.navigate(['/searchProduct',this.name])
}
getCart(){
    if (this.user!=null) {
      this.cartDetailService.getCartDetailByUserId(this.user.id).subscribe(cart => {
        this.cart=cart;
this.tokenStorageService.saveCartLocal(cart[0].cart_id);
      })
    }
}
getAmount() {
    if (this.user != null) {
      this.cartService.getCartById(this.user.id).subscribe(cart => {
       this.amount=cart[0].amount;
      })
    }
}
}
