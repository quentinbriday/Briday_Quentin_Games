import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {HttpEvent, HttpHandler, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class HttpInterceptor implements HttpInterceptor {


  constructor(private router: Router) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let header;
    header = {
        setHeaders: {
          //'X-Requested-With': 'XMLHttpRequest',
          //'Access-Control-Allow-Origin': true,
        }
      };
    const xhr = req.clone(header);
    console.log(xhr.headers);
    return next.handle(xhr);
  }
}
