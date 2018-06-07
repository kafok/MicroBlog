import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisternewsComponent } from './registernews.component';

describe('RegisternewsComponent', () => {
  let component: RegisternewsComponent;
  let fixture: ComponentFixture<RegisternewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisternewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisternewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
