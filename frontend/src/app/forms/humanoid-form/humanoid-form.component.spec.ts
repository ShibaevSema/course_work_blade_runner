import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HumanoidFormComponent } from './humanoid-form.component';

describe('HumanoidFormComponent', () => {
  let component: HumanoidFormComponent;
  let fixture: ComponentFixture<HumanoidFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HumanoidFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HumanoidFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
