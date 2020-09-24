import { TestBed } from '@angular/core/testing';

import { SubmitMyRequestService } from './submit-my-request.service';

describe('SubmitMyRequestService', () => {
  let service: SubmitMyRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubmitMyRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
