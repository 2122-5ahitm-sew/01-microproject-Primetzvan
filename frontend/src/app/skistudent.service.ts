import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Skistudent} from './models/skistudent';

@Injectable({
  providedIn: 'root'
})
export class SkistudentService {

  constructor(private http: HttpClient) { }

  getStudents(): Observable<Skistudent>{
    return this.http.get<Skistudent>('http://localhost:8080/api/skistudent/getAll');  }

}
