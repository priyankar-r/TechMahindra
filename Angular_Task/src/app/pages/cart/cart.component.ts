import { Component, OnInit } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { PetAccessory } from '../../model/pet-accessory.model';

interface CartItem {
  item: PetAccessory;
  quantity: number;
}

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cartItems: CartItem[] = [];
  selectedTotal: number = 0;
  selectedItems: Set<CartItem> = new Set();

  constructor(private cartService: CartService) {}

  ngOnInit() {
    this.cartService.getCart().subscribe((items) => {
      this.cartItems = [...items]; 
    });
  }  
  
  getGrandTotal(): number {
    return this.cartItems.reduce((total, cartItem) => total + (cartItem.item.price || 0) * cartItem.quantity, 0);
  }
  updateSelectedTotal(cartItem: CartItem, event: Event) {
    const checkbox = event.target as HTMLInputElement;
    const isChecked = checkbox.checked;
  
    if (isChecked) {
      this.selectedItems.add(cartItem);
    } else {
      this.selectedItems.delete(cartItem);
    }
    this.selectedTotal = Array.from(this.selectedItems).reduce(
      (total, item) => total + (item.item.price || 0) * item.quantity,
      0
    );
  }  
}
