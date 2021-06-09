import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: string = 'ORDER';
  total: number = 0;
  public foodSelected = 0;

  private meals: Array<[string, number]> = [
    ['Beef with Sa Cho', 6.05],
    ['Beijing roast duck', 9.5],
    ['Chinese noodles with three delicacies', 4.95],
    ['Chicken with almonds', 4.9],
    ['Sweet and sour pork', 4.7],
    ['Fried noodles with prawns', 4.35],
  ];

  public getMeals() {
    return this.meals;
  }

  public bill: Array<[string, number]> = [];

  public addMeal() {
    this.bill.push(this.meals[this.foodSelected]);
    this.total += this.meals[this.foodSelected][1];
  }

  public delMeal(i: number) {
    this.total -= this.bill[i][1];
    this.bill.splice(i, 1);
  }
}
