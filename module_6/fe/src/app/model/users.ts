import {Roles} from "./roles";

export interface Users {
   id: number;
   name: string;
   username: string;
   password: string;
  address: string;
  email: string;
  phone: string;
  gender: boolean;
  verificationCode: string;
  active: boolean;
  provider: string;
  dateCreated: any;
  lastUpdated: any;
  roles: Roles[];
}
