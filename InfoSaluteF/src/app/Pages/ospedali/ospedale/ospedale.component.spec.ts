import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OspedaleComponent } from './ospedale.component';

describe('OspedaleComponent', () => {
  let component: OspedaleComponent;
  let fixture: ComponentFixture<OspedaleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OspedaleComponent]
    });
    fixture = TestBed.createComponent(OspedaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
