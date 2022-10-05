import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Books } from './booklist/books';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private url: string = 'http://localhost:8282/HackathonProject/api';
  constructor(private http: HttpClient) { }

  public listAllBooks(): Observable<any> {
    return this.http.get(`${this.url}/books`);
  }

  public getBookDetails(id: number): Observable<any> {
    return this.http.get(`${this.url}/books/${id}`);
  }

  public createBook(book: Books): Observable<any> {
    return this.http.post(`${this.url}/books`, book);
  }

  public updateAvailability(book: Books): Observable<any> {

    return this.http.put(`${this.url}/books/update/${book.bookId}/${book.availability}`,
      book, {responseType: 'text'});
  }

  public listAvailableBooks(): Observable<any> {
    return this.http.get(`${this.url}/books/avail/true`);
  }
}
