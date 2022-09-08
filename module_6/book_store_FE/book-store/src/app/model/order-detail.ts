import {Book} from "./book";
import {OrderBook} from "./order-book";

export interface OrderDetail {
  id: number;
  quantity: number;
  book: Book;
  orderBook: OrderBook;
}
