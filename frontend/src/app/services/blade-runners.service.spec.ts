import { TestBed } from '@angular/core/testing';

import { BladeRunnersService } from './blade-runners.service';

describe('BladeRunnersService', () => {
  let service: BladeRunnersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BladeRunnersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
