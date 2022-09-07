import {RentType} from "./rent-type";
import {ServiceType} from "./service-type";

export interface Service {
  id: string,
  name: string,
  area: number,
  cost: number,
  maxPeople: number,
  rentType: RentType,
  serviceType: ServiceType
}
