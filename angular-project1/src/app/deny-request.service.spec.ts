import { TestBed } from '@angular/core/testing';

import { DenyRequestService } from './deny-request.service';

describe('DenyRequestService', () => {
  let service: DenyRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DenyRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
