import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'stars'
})
export class StarsPipe implements PipeTransform {

  transform(n: number): any{
    switch(n){
      case 1: return '★☆☆☆☆';
      case 2: return '★★☆☆☆';
      case 3: return '★★★☆☆';
      case 4: return '★★★★☆';
      case 5: return '★★★★★';
      default : '';
    }
  }

}
