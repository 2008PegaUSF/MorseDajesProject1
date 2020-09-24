import { TestBed } from '@angular/core/testing';

import { CancelMyRequestService } from './cancel-my-request.service';

describe('CancelMyRequestService', () => {
  let service: CancelMyRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CancelMyRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
