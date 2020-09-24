import { TestBed } from '@angular/core/testing';

import { ApprovedGradeService } from './approved-grade.service';

describe('ApprovedGradeService', () => {
  let service: ApprovedGradeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApprovedGradeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
