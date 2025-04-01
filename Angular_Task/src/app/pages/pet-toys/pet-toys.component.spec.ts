import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetToysComponent } from './pet-toys.component';

describe('PetToysComponent', () => {
  let component: PetToysComponent;
  let fixture: ComponentFixture<PetToysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PetToysComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PetToysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
