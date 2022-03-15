import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoitKampfTestComponent } from './voit-kampf-test.component';

describe('VoitCampfTestComponent', () => {
  let component: VoitKampfTestComponent;
  let fixture: ComponentFixture<VoitKampfTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoitKampfTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VoitKampfTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
