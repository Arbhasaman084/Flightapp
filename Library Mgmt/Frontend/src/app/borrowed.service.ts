import { Observable } from 'rxjs';
import { Borrowed } from './borrowed';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BorrowedService {

  private baseUrl = 'http://localhost:8080/HackathonProject/api/borrow';
  constructor(private http: HttpClient) { }

  public saveBorrowedBook(borrow: Borrowed): Observable<any> {
    return this.http.post(`${this.baseUrl}/save`, borrow, {responseType: 'text'});
  }

  public listBookForMember(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/member/${id}`);
  }

  public deleteBorrowedEntry(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, {responseType: 'text'});
  }

  public retrieveDetails(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}
