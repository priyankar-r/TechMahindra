import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'petFilter'
})
export class PetFilterPipe implements PipeTransform {
  transform(pets: any[], petType: string): any[] {
    if (!pets || !petType || petType === 'All') {
      return pets; // Return all pets if no filter is applied
    }
    return pets.filter(pet => pet.type === petType);
  }
}
