import {Product} from "./product";

export interface ProductCategory {
  id: number;
  categoryName: string;
  description: string;
  active: boolean;
  products: Product[];
}
