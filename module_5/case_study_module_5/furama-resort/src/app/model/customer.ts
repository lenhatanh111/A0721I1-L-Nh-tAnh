import {CustomerType} from "./customer-type";

export interface Customer {
  id:string
  name: string,
  birthday:string,
  gender: boolean,
  idCard:string,
  phoneNumber:string,
  email:string,
  address:string,
  customerType:CustomerType
}
