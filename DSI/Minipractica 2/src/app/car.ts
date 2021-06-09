export enum carCondition {
  GOOD,
  BAD,
}

export class Car {
  brand: string = '';
  model: string = '';
  pic: string = '';
  year = new Date();
  dateOnSale = new Date();
  price: number = 0;
  condition: carCondition = 0;

  constructor(
    pi: string,
    b: string,
    m: string,
    y: Date,
    d: Date,
    pr: number,
    c: carCondition
  ) {
    this.pic = pi;
    this.brand = b;
    this.model = m;
    this.year = y;
    this.dateOnSale = d;
    this.price = pr;
    this.condition = c;
  }

  lower() {
    this.price *= 0.9;
  }
}
