import {Product} from "./product";
import {Users} from "./users";

export interface Rates {
  id: number;
  start: number;
  comment: string;
  dateRate: any;
  user: Users;
  product: Product;

}
