import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from '../model/doctor.model';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http:HttpClient) { }

  getspeciality(session: string, slot: string, appointmentDate: string):Observable<Doctor[]> {
    return this.http.get<Doctor[]>("http://localhost:9327/speciality/get/"+session+"/"+slot+"/"+appointmentDate);
  }
  getFilteredDoctor(session: string, slot: string, appointmentDate: string):Observable<Doctor[]> {
    return this.http.get<Doctor[]>("http://localhost:9327/doctor/get/"+session+"/"+slot+"/"+appointmentDate);
  }
}
