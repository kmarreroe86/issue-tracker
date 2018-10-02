import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { Project } from '../models/project';
import { Issue } from '../models/issue';
import { Constants } from '../core/constans';

@Injectable()
export class ProjectService {

    constructor(private http: HttpClient) { }

    getProjects(): Observable<Project[]> {        
        return this.http.get<Project[]>(Constants.API_URL_PROJECTS);
    }

    getUserProjects(userId: number): Observable<Project[]> {
        return this.http.get<Project[]>(Constants.API_URL_PROJECTS + userId);
    }

    getProjectById(projectId: number): Observable<Project> {
        return this.http.get<Project>(Constants.API_URL_PROJECT + projectId);
    }
    
    getIssuesByProjectId(projectId: number): Observable<Issue[]> {
        return this.http.get<Issue[]>(Constants.API_URL_PROJECT_ISSUES + projectId);
    }


    // TODO: Implement call to API and get all issues by project Id.
}
