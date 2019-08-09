import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServerInputComponent } from './server-input.component';

describe('ServerInputComponent', () => {
  let component: ServerInputComponent;
  let fixture: ComponentFixture<ServerInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServerInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServerInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
