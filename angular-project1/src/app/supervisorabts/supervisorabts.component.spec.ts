import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupervisorabtsComponent } from './supervisorabts.component';

describe('SupervisorabtsComponent', () => {
  let component: SupervisorabtsComponent;
  let fixture: ComponentFixture<SupervisorabtsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupervisorabtsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SupervisorabtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
