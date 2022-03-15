import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewBladeRunnerTaskComponent } from './new-blade-runner-task.component';

describe('NewBladeRunnerTaskComponent', () => {
  let component: NewBladeRunnerTaskComponent;
  let fixture: ComponentFixture<NewBladeRunnerTaskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewBladeRunnerTaskComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewBladeRunnerTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
