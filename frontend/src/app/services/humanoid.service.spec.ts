import { TestBed } from '@angular/core/testing';

import { HumanoidService } from './humanoid.service';

describe('HumanoidService', () => {
  let service: HumanoidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HumanoidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
