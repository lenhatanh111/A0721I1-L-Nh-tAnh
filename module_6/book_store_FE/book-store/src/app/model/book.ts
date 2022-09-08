import {Publisher} from "./publisher";
import {Author} from "./author";

export interface Book {
    id: number;
    bookCode: string;
    title: string;
    description: string;
    releaseDate: any;
    pageNumber: number;
    size: number;
    price: number;
    imgUrl: string;
    publisher: Publisher;
    author: Author;
}
