import {Product} from "./product";
import {Order} from "./order";

export interface OrderDetail {
  id: number;
  quantity: number;
 order: Order;
 product: Product;
}
