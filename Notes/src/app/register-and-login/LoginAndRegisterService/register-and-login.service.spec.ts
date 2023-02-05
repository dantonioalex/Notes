import { TestBed } from '@angular/core/testing';

import { RegisterAndLoginService } from './register-and-login.service';

describe('RegisterAndLoginService', () => {
  let service: RegisterAndLoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterAndLoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
