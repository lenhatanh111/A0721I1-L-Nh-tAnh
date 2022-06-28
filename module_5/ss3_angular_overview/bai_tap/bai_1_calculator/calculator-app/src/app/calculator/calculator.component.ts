import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
num1 =0;
num2 =0;
calculation ="";
result =0;
  constructor() { }
changeCalculation(newCalculation : string){
    this.calculation= newCalculation;
}
calculate(){
    switch (this.calculation) {
      case "+": this.result=this.num1+this.num2;
         break;
      case "-": this.result=this.num1-this.num2; break;
      case "*": this.result=this.num1*this.num2; break;
      case "/": this.result=this.num1/this.num2; break;

    }
    console.log(this.result)
    console.log(this.num1)
    console.log(this.num2)
    console.log(this.calculation)
}
  ngOnInit(): void {
  }

}
