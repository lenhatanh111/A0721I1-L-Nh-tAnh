import {Book} from "./book";

export interface Rate {
  id: number;
  comment: string;
  dateRate: any;
  book: Book;
  account: Account;
}
