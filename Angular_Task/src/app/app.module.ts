import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonComponent } from './common/common.component';
import { HomeComponent } from './pages/home/home.component';
import { PetsComponent } from './pages/pets/pets.component';
import { PetToysComponent } from './pages/pet-toys/pet-toys.component';
import { AdoptionFormComponent } from './common/adoption-form/adoption-form.component';
import { CartComponent } from './pages/cart/cart.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './common/navbar/navbar.component';
import { PetFilterPipe } from './pipes/pet-filter.pipe';
import { CartService } from './services/cart.service';
import { LoginComponent } from './pages/login/login.component';
import { AdoptionRequestComponent } from './pages/adoption-request/adoption-request.component';

@NgModule({
  declarations: [
    AppComponent,
    CommonComponent,
    HomeComponent,
    PetsComponent,
    PetToysComponent,
    AdoptionFormComponent,
    CartComponent,
    NavbarComponent,
    PetFilterPipe,
    LoginComponent,
    AdoptionRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [NavbarComponent], 
  providers: [CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
