import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class PropertyService {

  private readonly API_URL = 'http://localhost:8080/api/properties';

  constructor(private http: HttpClient) { }

  getAllProperties(): Observable<any[]> {
    return this.http.get<any[]>(this.API_URL);
  }

  // You can add more methods later
  getPropertyById(id: number): Observable<any> {
    return this.http.get<any>(`${this.API_URL}/${id}`);
  }
}
