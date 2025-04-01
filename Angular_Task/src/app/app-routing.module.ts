import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PetsComponent } from './pages/pets/pets.component';
import { PetToysComponent } from './pages/pet-toys/pet-toys.component';
import { CartComponent } from './pages/cart/cart.component';
import { LoginComponent } from './pages/login/login.component';
import { AdoptionRequestComponent } from './pages/adoption-request/adoption-request.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'pets', component: PetsComponent },
  { path: 'pet-toys', component: PetToysComponent },
  { path: 'cart', component: CartComponent },
  { path: 'login', component: LoginComponent },
  { path: 'adoption-requests', component: AdoptionRequestComponent },
  { path: '**', redirectTo: 'login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
