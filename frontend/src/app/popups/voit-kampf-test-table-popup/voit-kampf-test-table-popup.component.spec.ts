import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoitKampfTestTablePopupComponent } from './voit-kampf-test-table-popup.component';

describe('VoitKampfTestTablePopupComponent', () => {
  let component: VoitKampfTestTablePopupComponent;
  let fixture: ComponentFixture<VoitKampfTestTablePopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoitKampfTestTablePopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VoitKampfTestTablePopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
