import { TestBed } from '@angular/core/testing';

import { BorrowedService } from './borrowed.service';

describe('BorrowedService', () => {
  let service: BorrowedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BorrowedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
