import {Users} from "./users";

export interface Order {
  id: number;
  address: string;
  phone: string;
  amount: any;
  description: string;
  orderTrackingNumber: string;
  status: number;
  dateOrdered: any;
  dateDeliveryDate: any;
  dateReceipt: any;
  user: Users;

}
