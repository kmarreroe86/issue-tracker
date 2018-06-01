import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Cookie } from 'ng2-cookies';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { OAuthService } from 'angular-oauth2-oidc';
import { LoginUser } from '../models/loginUser';

@Injectable()
export class AppService {
    constructor() {}
        // tslint:disable-next-line:no-trailing-whitespace
        // private _router: Router, private _http: Http/* , private _oauthService: OAuthService */) {
        // this._oauthService.loginUrl = 'http://localhost:8080/spring-security-oauth-server/oauth/authorize';
        // this._oauthService.redirectUri = 'http://localhost:8080/';
        // this._oauthService.clientId = 'clientPasswordId';
        // this._oauthService.scope = 'read write foo bar';
        // this._oauthService.setStorage(sessionStorage);
        // this._oauthService.oidc = false;
        // this._oauthService.tryLogin({});
    // }

    obtainAccessToken(loginData) {
        // this._oauthService.initImplicitFlow();
        // const params = new URLSearchParams();
        // params.append('username', loginData.username);
        // params.append('password', loginData.password);
        // params.append('grant_type', 'password');
        // params.append('client_id', 'clientPasswordId');
        // const headers = new Headers({
        //     'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Basic ' +
        //         btoa('clientPasswordId:secret')
        // });
        // const options = new RequestOptions({ headers: headers });

        // this._http.post('http://localhost:8081/spring-security-oauth-server/oauth/token', params.toString(), options)
        //     .map(res => res.json())
        //     .subscribe(
        //         data => this.saveToken(data),
        //         err => alert('Invalid Credentials'));
    }

    saveToken(token) {
        // const expireDate = new Date().getTime() + (1000 * token.expires_in);
        // Cookie.set('access_token', token.access_token, expireDate);
        // this._router.navigate(['/']);
        // this._router.navigate(['/projects/user/:userId']);
    }

    /* getResource(resourceUrl): Observable<LoginUser> {
        const headers = new Headers({
            'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer ' +
                Cookie.get('access_token')
        });
        const options = new RequestOptions({ headers: headers });
        return this._http.get(resourceUrl, options)
            .map((res: Response) => res.json())
            .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
    } */

    checkCredentials() {
        /* if (!Cookie.check('access_token')) {
            this._router.navigate(['/login']);
        } */
    }

    logout() {
        Cookie.delete('access_token');
        // this._router.navigate(['/login']);
    }

    isLoggedIn() {
        // console.log(this._oauthService.getAccessToken());
        // if (this._oauthService.getAccessToken() === null) {
        //     return false;
        // }
        return true;
    }
}
