import {Category} from "./category";
import {Book} from "./book";

export interface CategoryBook {
  id: number;
  category: Category;
  book: Book;
}
