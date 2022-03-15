import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectReplicantPopupComponent } from './select-replicant-popup.component';

describe('SelectReplicantPopupComponent', () => {
  let component: SelectReplicantPopupComponent;
  let fixture: ComponentFixture<SelectReplicantPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectReplicantPopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectReplicantPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
