import { TestBed } from '@angular/core/testing';

import { DenyGradeService } from './deny-grade.service';

describe('DenyGradeService', () => {
  let service: DenyGradeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DenyGradeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
