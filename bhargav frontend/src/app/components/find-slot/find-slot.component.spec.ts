import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindSlotComponent } from './find-slot.component';

describe('FindSlotComponent', () => {
  let component: FindSlotComponent;
  let fixture: ComponentFixture<FindSlotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindSlotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindSlotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
