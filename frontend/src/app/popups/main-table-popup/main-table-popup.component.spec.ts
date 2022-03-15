import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainTablePopupComponent } from './main-table-popup.component';

describe('MainTablePopupComponent', () => {
  let component: MainTablePopupComponent;
  let fixture: ComponentFixture<MainTablePopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainTablePopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MainTablePopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
