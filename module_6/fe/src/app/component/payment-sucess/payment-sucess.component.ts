import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {TokenStorageService} from "../../service/token-storage-service";
import {CartDetailService} from "../../service/cart-detail.service";
import {Router} from "@angular/router";
import {OrderDetailService} from "../../service/order-detail.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-payment-sucess',
  templateUrl: './payment-sucess.component.html',
  styleUrls: ['./payment-sucess.component.css']
})
export class PaymentSucessComponent implements OnInit {

  constructor() {}


  ngOnInit(): void {

  }

}

