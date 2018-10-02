import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { Project } from '../models/project';
import { User } from '../models/user';
import { Constants } from '../core/constans';

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }

    getUserData(): Observable<User> {        
        return this.http.get<User>(Constants.API_URL_USER);
    }
}
