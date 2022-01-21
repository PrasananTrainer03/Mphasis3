import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap, map,retry } from 'rxjs/operators';
import { Orders } from './orders';
import { Restaurant } from './restaurant';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private _http: HttpClient) { }

  showRestaurant(): Observable<Restaurant []> {
    return this._http.get<Restaurant []>("http://localhost:8181/showRestaurant")
      .pipe(
        tap(data =>
        console.log('All: ' + JSON.stringify(data)))
      );
  }
  // placeOrder(orders : Orders) : Observable<string> {
  //   return this._http.post<string>("http://localhost:8181/orders/placeOrder/",orders)
  // }

  placeOrder1(orders : Orders) : any {
    return this._http.post<string>("http://localhost:8080/CmsNew/webapi/orders/placeorder/",orders).
    pipe(retry(0))
  }

}
