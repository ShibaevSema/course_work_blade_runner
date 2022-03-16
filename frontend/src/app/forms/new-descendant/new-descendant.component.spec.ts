import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewDescendantComponent } from './new-descendant.component';

describe('NewDescendantComponent', () => {
  let component: NewDescendantComponent;
  let fixture: ComponentFixture<NewDescendantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewDescendantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewDescendantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
