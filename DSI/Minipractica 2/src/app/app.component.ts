import { Component } from '@angular/core';
import { Car } from './car';

export enum carCondition {
  GOOD,
  BAD,
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'Authorized Dealer';
  brandToFilter = '';
  Car1 = new Car(
    'https://i.pinimg.com/564x/28/55/ec/2855ecb2332a00a084ea305d85841a36.jpg',
    'Seat',
    'Ibiza',
    new Date(2003, 11, 12),
    new Date(2018, 3, 22),
    1200,
    carCondition.BAD
  );
  Car2 = new Car(
    '', //'https://avtotachki.com/wp-content/uploads/2020/05/citroen-c3-1-2-puretech-68-l-s-5-mkp-1.jpg',
    'Citroen',
    'C3',
    new Date(2016, 2, 1),
    new Date(2017, 5, 31),
    10499,
    carCondition.BAD
  );
  Car3 = new Car(
    'https://cars.usnews.com/static/images/Auto/izmo/i159614145/2021_hyundai_kona_angularfront.jpg',
    'Hyundai',
    'Kona',
    new Date(2017, 6, 2),
    new Date(2019, 5, 15),
    14399,
    carCondition.GOOD
  );
  Car4 = new Car(
    'https://www.lloydmotorgroup.com/ImageLibrary/Vehicle/526629-LwY3ZPABjEGguuRwf8sBNw.jpg',
    'Ford',
    'Fiesta',
    new Date(2017, 12, 6),
    new Date(2019, 1, 8),
    14199,
    carCondition.GOOD
  );
  Car5 = new Car(
    'https://d3lp4xedbqa8a5.cloudfront.net/s3/digital-cougar-assets/whichcar/2020/06/16/-1/2021-Ford-Mustang-Mach-1.jpg',
    'Ford',
    'Mustang',
    new Date(2021, 2, 15),
    new Date(2021, 2, 26),
    27155,
    carCondition.BAD
  );

  cars: Car[] = [
    this.Car1,
    this.Car2,
    this.Car3,
    this.Car4,
    this.Car5,
  ];

  public sold(i: number) {
    this.cars.splice(i, 1);
  }

  public isGoodCondition(cond: carCondition): boolean {
    return cond == carCondition.GOOD;
  }
}
