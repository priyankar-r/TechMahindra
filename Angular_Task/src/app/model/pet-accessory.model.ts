export interface PetAccessory {
    id: number;
    name: string;
    category: string; // e.g., Toy, Food, Bed, Leash
    price: number;
    image: string; // URL to the accessory image
    description?: string; // Optional: Short description
  }