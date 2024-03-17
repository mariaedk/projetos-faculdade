import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhesHostComponent } from './detalhes-host.component';

describe('DetalhesHostComponent', () => {
  let component: DetalhesHostComponent;
  let fixture: ComponentFixture<DetalhesHostComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetalhesHostComponent]
    });
    fixture = TestBed.createComponent(DetalhesHostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
