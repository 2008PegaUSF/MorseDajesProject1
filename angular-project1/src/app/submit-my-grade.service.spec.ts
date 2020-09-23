import { TestBed } from '@angular/core/testing';

import { SubmitMyGradeService } from './submit-my-grade.service';

describe('SubmitMyGradeService', () => {
  let service: SubmitMyGradeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubmitMyGradeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
