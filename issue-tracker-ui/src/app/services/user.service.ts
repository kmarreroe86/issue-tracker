import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

import { Project } from '../models/project';

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }

    getUserProjects(userId: number): Observable<Project[]> {
        return this.http.get<Project[]>('http://localhost:8080/projects/' + userId);
    }
}
