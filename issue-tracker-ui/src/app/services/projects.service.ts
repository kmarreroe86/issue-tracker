import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

import { Project } from '../models/project';
import { Constants } from '../core/constans';

@Injectable()
export class ProjectService {

    constructor(private http: HttpClient) { }

    getProjects(): Observable<Project[]> {
        // return this.http.get<Project[]>('http://localhost:8080/projects/');
        return this.http.get<Project[]>(Constants.API_URL_PROJECTS);
    }

    getUserProjects(userId: number): Observable<Project[]> {
        return this.http.get<Project[]>(Constants.API_URL_PROJECTS + userId);
    }
}
