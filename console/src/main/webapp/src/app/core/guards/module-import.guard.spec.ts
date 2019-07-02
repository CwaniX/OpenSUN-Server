import { TestBed, async, inject } from '@angular/core/testing';

import { ModuleImportGuard } from './module-import.guard';

describe('ModuleImportGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ModuleImportGuard]
    });
  });

  it('should ...', inject([ModuleImportGuard], (guard: ModuleImportGuard) => {
    expect(guard).toBeTruthy();
  }));
});
