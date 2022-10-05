import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  private baseUrl = 'http://localhost:8080/HackathonProject/api/members';

  constructor(private http: HttpClient) { }

  public getMemberDetails(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}
