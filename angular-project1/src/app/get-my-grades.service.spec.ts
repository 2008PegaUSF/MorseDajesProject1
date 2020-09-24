import { TestBed } from '@angular/core/testing';

import { GetMyGradesService } from './get-my-grades.service';

describe('GetMyGradesService', () => {
  let service: GetMyGradesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetMyGradesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
