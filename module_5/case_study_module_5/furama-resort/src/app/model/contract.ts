import {Customer} from "./customer";
import {Service} from "./service";

export interface Contract {
  id: string,
  customer: Customer,
  service: Service,
  startDate: string,
  endDate: string,
  deposit: number
}
