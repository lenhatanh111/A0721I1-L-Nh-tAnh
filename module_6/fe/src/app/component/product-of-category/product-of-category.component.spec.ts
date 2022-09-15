import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductOfCategoryComponent } from './product-of-category.component';

describe('ProductOfCategoryComponent', () => {
  let component: ProductOfCategoryComponent;
  let fixture: ComponentFixture<ProductOfCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductOfCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductOfCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
