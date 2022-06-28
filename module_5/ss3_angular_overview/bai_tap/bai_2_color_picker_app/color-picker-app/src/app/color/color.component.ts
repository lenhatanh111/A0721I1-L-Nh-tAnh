import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
color ="";
bgColor="background-color:";
changeColor(newColor: string){
  this.bgColor=this.bgColor+newColor;
}
clear(){
  this.bgColor="background-color:";
}

  constructor() { }

  ngOnInit(): void {
  }

}
