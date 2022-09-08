import {Book} from "./book";
import {Cart} from "./cart";

export interface CartDetail {
  id: number;
  quantity: number;
  book: Book;
  cart: Cart;
}
