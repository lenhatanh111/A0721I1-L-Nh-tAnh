import {ProductCategory} from "./product-category";

export interface Product {
    id: number;
   name: string;
  description: string;
  unitPrice: any;
  imageUrl: string;
  imageStore: string;
  active: boolean;
  unitInStock: number;
  dateCreated: any;
  lastUpdated: any;
  category: ProductCategory;


}
