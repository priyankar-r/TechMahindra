import { Component, OnInit } from '@angular/core';
import { PetShopService } from '../../services/pet-shop.service';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-pet-toys',
  templateUrl: './pet-toys.component.html',
  styleUrls: ['./pet-toys.component.css']
})
export class PetToysComponent implements OnInit {
  toys: any[] = [];
  CartService: any;

  constructor(private petService: PetShopService, private cartService: CartService) {}

  ngOnInit(): void {
    this.petService.getToys().subscribe(data => {
      this.toys = data;
    });
  }

  buyToy(toy: any) {
    this.cartService.addToCart(toy); // Call the correct service
    alert(`${toy.name} added to cart!`);
  }    
}