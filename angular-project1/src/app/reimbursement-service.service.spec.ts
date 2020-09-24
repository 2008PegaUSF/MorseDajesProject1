import { TestBed } from '@angular/core/testing';

import { ReimbursementServiceService } from './reimbursement-service.service';

describe('ReimbursementServiceService', () => {
  let service: ReimbursementServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReimbursementServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
