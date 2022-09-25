import {Product} from "./product";
import {Cart} from "./cart";

export interface CartDetail {
  id: number;
  quantity: number;
  cart: Cart;
  product: Product;
  hibernateLazyInitializer: any;
}
