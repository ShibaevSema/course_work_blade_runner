import { TestBed } from '@angular/core/testing';

import { VoitKampfQuestionService } from './voit-kampf-question.service';

describe('VoitKampfQuestionService', () => {
  let service: VoitKampfQuestionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VoitKampfQuestionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
