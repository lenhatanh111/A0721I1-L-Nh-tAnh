import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors
} from "@angular/forms";


class Country {
  id : string
  name : string

  constructor(id: string, name: string) {
    this.id = id;
    this.name = name;
  }
}

function password(control :AbstractControl): ValidationErrors |null {
  if (control.value.password===control.value.confirmPassword &&control.value.password!=null&&control.value.confirmPassword!=null){
    return {"password": true}
  }else return {"password": false}

}

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {

registerForm=new FormGroup({
  email : new FormControl("",[Validators.required,Validators.email]),
  password : new FormControl("",[Validators.required,Validators.minLength(6),password]),
  confirmPassword : new FormControl("",[Validators.required,Validators.minLength(6),password]),
  country : new FormControl("",Validators.required),
  age : new FormControl("",[Validators.required,Validators.min(19)]),
  gender : new FormControl("male",Validators.required),
  phone : new FormControl("",[Validators.required,Validators.pattern("\\+84\\d{9,10}$")]),
})

  countryList : Country[]=[
    new Country("1","Quảng Ngãi"),
    new Country("2","Quảng Nam"),
    new Country("3","Đà Nẵng"),
    new Country("4","Huế")
  ]
  constructor() {

  }
  ngOnInit(): void {

  }
  onSubmit(){
  console.log(this.registerForm.value);
  let message : string="đăng ký thành công";
  }


}
