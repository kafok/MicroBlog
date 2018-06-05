import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FondoPerfilComponent } from './fondo-perfil.component';

describe('FondoPerfilComponent', () => {
  let component: FondoPerfilComponent;
  let fixture: ComponentFixture<FondoPerfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FondoPerfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FondoPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
