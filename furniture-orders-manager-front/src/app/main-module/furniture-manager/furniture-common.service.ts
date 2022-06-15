import {Injectable} from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FurnitureCommonService {

  constructor() {
  }


  handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('An error occurred:', error.error);
    } else {
      if (error.status >= 200 && error.status <= 299) {
        alert("Done")
        return;
      }
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
      alert('Error! Code: ' + error.status + ' -> ' + error.error)
    }
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
