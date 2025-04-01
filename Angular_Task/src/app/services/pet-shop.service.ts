import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PetShopService {
  private apiUrl = 'http://localhost:3000';

  constructor(private http: HttpClient) {}

  getPets(): Observable<any> {
    return this.http.get(`${this.apiUrl}/pets`);
  }

  getToys(): Observable<any> {
    return this.http.get(`${this.apiUrl}/toys`);
  }

  addToCart(toy: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/cart`, toy);
  }
}
