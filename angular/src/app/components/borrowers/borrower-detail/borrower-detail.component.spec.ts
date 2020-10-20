import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrowerDetailComponent } from './borrower-detail.component';

describe('BorrowerDetailComponent', () => {
  let component: BorrowerDetailComponent;
  let fixture: ComponentFixture<BorrowerDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BorrowerDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrowerDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
