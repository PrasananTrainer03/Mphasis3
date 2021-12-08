import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckDemoComponent } from './check-demo.component';

describe('CheckDemoComponent', () => {
  let component: CheckDemoComponent;
  let fixture: ComponentFixture<CheckDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
