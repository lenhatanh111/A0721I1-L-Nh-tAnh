import { Injectable } from '@angular/core';
const TOKEN_KEY = '';
const USER_KEY = 'auth-account';
const CART_KEY='cart';
const AMOUNT_KEY='amount';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut() {
    window.localStorage.clear();
    window.sessionStorage.clear();
  }

  public saveTokenLocal(token: string) {
    window.localStorage.removeItem(TOKEN_KEY);
    window.localStorage.setItem(TOKEN_KEY, token);
  }

  public saveTokenSession(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    if (localStorage.getItem(TOKEN_KEY) !== null) {
      return localStorage.getItem(TOKEN_KEY);
    } else {
      return localStorage .getItem(TOKEN_KEY);
    }
  }

  public saveUserLocal(user) {
    window.localStorage.removeItem(USER_KEY);
    window.localStorage.setItem(USER_KEY, JSON.stringify(user));
  }
  public saveAmountLocal(amount) {
    window.localStorage.removeItem(AMOUNT_KEY);
    window.localStorage.setItem(AMOUNT_KEY, JSON.stringify(amount));
  }
  public saveCartLocal(cart){
    window.localStorage.removeItem(CART_KEY);
    window.localStorage.setItem(CART_KEY, JSON.stringify(cart));
  }
  public saveUserSession(user) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser() {
    if (localStorage.getItem(USER_KEY) !== null) {
      return JSON.parse(localStorage.getItem(USER_KEY));
    } else {
      return JSON.parse(sessionStorage.getItem(USER_KEY));
    }
  }
  public getCart() {
    if (localStorage.getItem(CART_KEY) !== null) {
      return JSON.parse(localStorage.getItem(CART_KEY));
    } else {
      return JSON.parse(sessionStorage.getItem(CART_KEY));
    }
  }
  public getAmount() {
    if (localStorage.getItem(AMOUNT_KEY) !== null) {
      return JSON.parse(localStorage.getItem(AMOUNT_KEY));
    } else {
      return JSON.parse(sessionStorage.getItem(AMOUNT_KEY));
    }
  }
}
