
import {tap} from 'rxjs/operators';
import { Injectable } from '@angular/core';
import {
    HttpInterceptor, HttpRequest, HttpHandler, HttpSentEvent, HttpHeaderResponse, HttpProgressEvent,
    HttpResponse, HttpUserEvent, HttpErrorResponse, HttpEvent
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { SessionStorage } from './session.storage';


const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class Interceptor implements HttpInterceptor {

    constructor(private token: SessionStorage, private router: Router) { }

    intercept(req: HttpRequest<any>, next: HttpHandler):
        Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent | HttpResponse<any> | HttpUserEvent<any>> {
        let authReq = req;
        if (this.token.getToken() != null) {
            authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.token.getToken()) });
        }
        return next.handle(authReq).pipe(tap(
            (event: HttpEvent<any>) => {
                console.log('Interceptor do. Response Ok');
            },
            (err: any) => {
                if (err instanceof HttpErrorResponse) {
                    console.log('Interceptor error: ', err);
                    console.log('req url :: ' + req.url);
                    if (err.status === 401) {
                        this.router.navigate(['/login']);
                    }
                }
            }));
    }

}
