import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Headers, RequestOptions, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user';
import { AppComponent } from '../app.component';
import { LoginUser } from '../models/loginUser';
import { SessionStorage } from '../core/session.storage';

@Injectable()
export class AuthService {
    private saltRounds = 10;
    private salt = '$2a$10$VahSNsWalmFKtfHBgN8odu';
    constructor(private _http: HttpClient, private _tokenStorage: SessionStorage) { }

    attemptAuth(ussername: string, password: string): Observable<any> {
        const hardcodepassword = '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm';
        const credentials = { username: ussername, password: password };
        console.log('attempAuth ::');
        return this._http.post<any>('http://localhost:8080/token/generate-token', credentials);
    }

    getLoggedUser(): string {
        return this._tokenStorage.getLoggedUser();
    }

    logOut() {
        this._tokenStorage.signOut();
    }
}
