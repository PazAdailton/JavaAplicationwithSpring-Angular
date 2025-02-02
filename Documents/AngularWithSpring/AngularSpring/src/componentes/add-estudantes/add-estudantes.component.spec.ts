import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEstudantesComponent } from './add-estudantes.component';

describe('AddEstudantesComponent', () => {
  let component: AddEstudantesComponent;
  let fixture: ComponentFixture<AddEstudantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddEstudantesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddEstudantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
