import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExistingBladeRunnersTasksComponent } from './existing-blade-runners-tasks.component';

describe('ExistingBladeRunnersTasksComponent', () => {
  let component: ExistingBladeRunnersTasksComponent;
  let fixture: ComponentFixture<ExistingBladeRunnersTasksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExistingBladeRunnersTasksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExistingBladeRunnersTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
