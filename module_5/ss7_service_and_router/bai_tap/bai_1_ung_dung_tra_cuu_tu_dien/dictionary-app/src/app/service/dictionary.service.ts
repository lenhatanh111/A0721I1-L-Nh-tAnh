import { Injectable } from '@angular/core';
import {IWord} from "../model/i-word";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
words : IWord[]=[
  {
word:'hello',
    mean:'xin chào'
  },
  {
    word:'phone',
    mean:'điện thoại'
  },
  {
    word:'mouse',
    mean:'chuột'
  },
  {
    word:'cat',
    mean:'mèo'
  },
  {
    word:'dog',
    mean:'chó'
  },
  {
    word:'pig',
    mean:'lợn'
  },
]
  constructor() { }
  findWord(word: string){
  return this.words.find(item =>item.word===word);}
  getAll(){
  return this.words;
  }

}
