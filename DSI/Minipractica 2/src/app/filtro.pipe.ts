import { Pipe, PipeTransform } from '@angular/core';
import { Car } from './car';

@Pipe({
  name: 'filter',
})
export class FiltroPipe implements PipeTransform {
  transform(value: Car[], input: string): Car[] {
    if (input) {
      return value.filter((car) =>
        car.brand.toLocaleLowerCase().includes(input.toLocaleLowerCase())
      );
    } else {
      return value;
    }
  }
}
