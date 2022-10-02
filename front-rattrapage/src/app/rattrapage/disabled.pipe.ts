import { Pipe, PipeTransform } from '@angular/core';
import { Convocation } from '../classes/Convocation';

@Pipe({
  name: 'disabled'
})
export class DisabledPipe implements PipeTransform {

  transform(convocations: Convocation[]): boolean {
    for (let index = 0; index < convocations.length; index++) {
      const convoc = convocations[index];
      if(convoc.present === true && convoc.note === 0){
        return true;
      }
    }
    return false;
  }

}
