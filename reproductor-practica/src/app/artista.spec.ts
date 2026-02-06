import { TestBed } from '@angular/core/testing';

import { Artista } from './artista';

describe('Artista', () => {
  let service: Artista;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Artista);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
