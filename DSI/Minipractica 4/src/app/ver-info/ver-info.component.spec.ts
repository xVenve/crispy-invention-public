import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VerInfoComponent } from './ver-info.component';

describe('VerInfoComponent', () => {
  let component: VerInfoComponent;
  let fixture: ComponentFixture<VerInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VerInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VerInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
