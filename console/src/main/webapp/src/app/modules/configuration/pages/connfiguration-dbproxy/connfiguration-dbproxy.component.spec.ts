import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnfigurationDbproxyComponent } from './connfiguration-dbproxy.component';

describe('ConnfigurationDbproxyComponent', () => {
  let component: ConnfigurationDbproxyComponent;
  let fixture: ComponentFixture<ConnfigurationDbproxyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnfigurationDbproxyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnfigurationDbproxyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
