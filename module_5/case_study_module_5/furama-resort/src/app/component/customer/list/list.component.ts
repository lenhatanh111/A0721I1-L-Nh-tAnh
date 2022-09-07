import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../../service/customer.service";
import {ActivatedRoute} from "@angular/router";
import {Customer} from "../../../model/customer";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor(private customerService: CustomerService, activatedRoute: ActivatedRoute) {
  }

  customers: Customer[] = [];

  ngOnInit(): void {
    this.getAll();
    console.log(this.customers)
  }

  getAll() {
    this.customerService.getAll().subscribe(customers => {
      this.customers =customers;
      console.log(customers)
    })
  }

}
