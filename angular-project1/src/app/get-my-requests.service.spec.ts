import { TestBed } from '@angular/core/testing';

import { GetMyRequestsService } from './get-my-requests.service';

describe('GetMyRequestsService', () => {
  let service: GetMyRequestsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetMyRequestsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
