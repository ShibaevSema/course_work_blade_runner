import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoitKampfTestTableComponent } from './voit-kampf-test-table.component';

describe('VoitKampfTestTableComponent', () => {
  let component: VoitKampfTestTableComponent;
  let fixture: ComponentFixture<VoitKampfTestTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoitKampfTestTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VoitKampfTestTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
