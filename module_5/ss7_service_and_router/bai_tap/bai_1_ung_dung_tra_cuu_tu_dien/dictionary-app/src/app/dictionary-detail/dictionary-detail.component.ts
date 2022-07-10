import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../service/dictionary.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
word:any;
  constructor(
    private dictionaryService: DictionaryService,
    private activatedRoute: ActivatedRoute,
    private domSanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param:ParamMap)=>{
        const word=param.get('word');
this.word=this.dictionaryService.findWord(word);
    })
  }

}
