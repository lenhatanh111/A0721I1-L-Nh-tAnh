import {Users} from "./users";
import {CartDetail} from "./cart-detail";

export interface Cart {
  id: number;
  amount: any;
  user: Users[];
  cartDetails: CartDetail[]
}
