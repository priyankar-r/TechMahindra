import { Component, OnInit } from '@angular/core';
import { PetShopService } from '../../services/pet-shop.service';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {
  pets: any[] = [];
  selectedPet: any = null;
  isFormOpen: boolean = false;
  petType: string = 'All';
  constructor(private petService: PetShopService) {}

  ngOnInit(): void {
    this.petService.getPets().subscribe(data => {
      this.pets = data;
    });
  }

  openAdoptionForm(pet: any) {
    this.selectedPet = pet;
    this.isFormOpen = true;
  }

  closeAdoptionForm() {
    this.selectedPet = null;
    this.isFormOpen = false;
  }

  onPetTypeChange(type: string) {
    this.petType = type; // Update selected pet type
  }
}
