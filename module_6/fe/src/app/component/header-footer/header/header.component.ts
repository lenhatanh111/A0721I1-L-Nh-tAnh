import { Component, OnInit } from '@angular/core';
import {CategoryServiceService} from "../../../service/category-service.service";
import {Router} from "@angular/router";
import {TokenStorageService} from "../../../service/token-storage-service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
categories: any;
user: any;
name: any;
  searchForm: FormGroup = new FormGroup({
    name: new FormControl('')
  });

  constructor(private categoryService: CategoryServiceService, private router: Router, private tokenStorageService: TokenStorageService) {
    this.getAllCategory();
    this.user=this.tokenStorageService.getUser();

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
    window.location.reload();
}
onSearch(){
  this.name=this.searchForm.value.name;
  this.router.navigate(['/searchProduct',this.name]),
    console.log(this.name)
}
}
