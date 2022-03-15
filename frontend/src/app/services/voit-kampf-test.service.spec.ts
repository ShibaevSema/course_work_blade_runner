import { TestBed } from '@angular/core/testing';

import { VoitKampfTestService } from './voit-kampf-test.service';

describe('VoitKampfTestService', () => {
  let service: VoitKampfTestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VoitKampfTestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
