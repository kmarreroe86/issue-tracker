import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Headers, RequestOptions, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user';
import { AppComponent } from '../app.component';
import { LoginUser } from '../models/loginUser';

// const bcrypt = require('bcryptjs');

@Injectable()
export class AuthService {
    private saltRounds = 10;
    private salt = '$2a$10$VahSNsWalmFKtfHBgN8odu';
    constructor(private _http: HttpClient) { }

    attemptAuth(ussername: string, password: string): Observable<any> {
        // const passwordHashed = this.hashUserPassword(password);
        const hardcodepassword = '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm';
        const credentials = { username: ussername, password: password };
        console.log('attempAuth ::');
        return this._http.post<any>('http://localhost:8080/token/generate-token', credentials);
    }

    /* public logIn(user: LoginUser) {
        const headers = new HttpHeaders();
        headers.append('Accept', 'application/json');
        user.password = this.hashUserPassword(user);

        const base64Credential = btoa(user.username + ':' + user.password);
        headers.append('Authorization', 'Basic ' + base64Credential);

        return this._http.get(AppComponent.API_URL + '/account/login', { headers: headers })
            .map((response: Response) => {                
                const loggedUser = response.json().principal;
                if (loggedUser) {                    
                    localStorage.setItem('currentUser', JSON.stringify(loggedUser));
                }
            });
    } */

    /* logOut() {        
        return this._http.post(AppComponent.API_URL + '/logout', {})
            .map((response: Response) => {
                localStorage.removeItem('currentUser');
            });
    } */

    // private hashUserPassword(password): string {
    //     const hash = bcrypt.hashSync(password, this.salt);
    //     console.log('password: hashed', hash);
    //     return hash;
    // }

}
