import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectBladeRunnerPopupComponent } from './select-blade-runner-popup.component';

describe('SelectBladeRunnerPopupComponent', () => {
  let component: SelectBladeRunnerPopupComponent;
  let fixture: ComponentFixture<SelectBladeRunnerPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectBladeRunnerPopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectBladeRunnerPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
