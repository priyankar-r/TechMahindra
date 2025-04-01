import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-adoption-request',
  templateUrl: './adoption-request.component.html',
  styleUrls: ['./adoption-request.component.css']
})
export class AdoptionRequestComponent implements OnInit {
  adoptionRequests: any[] = [];

  constructor(private http: HttpClient) {}
  
  ngOnInit() {
    this.fetchAdoptionRequests();
  }

  fetchAdoptionRequests() {
    this.http.get<any[]>('http://localhost:3000/adoptions')
      .subscribe(response => {
        this.adoptionRequests = response;
      });
  }
}
