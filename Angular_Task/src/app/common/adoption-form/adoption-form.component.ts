import { Component, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-adoption-form',
  templateUrl: './adoption-form.component.html',
  styleUrls: ['./adoption-form.component.css']
})
export class AdoptionFormComponent {
  @Input() pet: any;

  constructor(private http: HttpClient) {}

  submitForm(formData: any) {
    const adoptionRequest = {
      petName: this.pet?.name,
      adopterName: formData.name,
      adopterEmail: formData.email,
      adopterPhone: formData.phone,
      message: formData.message
    };

    // Save data to db.json using JSON server
    this.http.post('http://localhost:3000/adoptions', adoptionRequest).subscribe(response => {
      alert(`Adoption request for ${this.pet.name} submitted successfully!`);
    });
  }
}
