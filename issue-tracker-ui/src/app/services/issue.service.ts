import { Injectable } from "@angular/core";

import { Observable } from "rxjs";
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse
} from "@angular/common/http";

import { Issue } from "../models/issue";
import { Constants } from "../core/constans";
import { catchError } from "rxjs/internal/operators/catchError";
import { ErrorObservable } from "rxjs/observable/ErrorObservable";

@Injectable()
export class IssueService {
  constructor(private http: HttpClient) {}

  changeIssueStatus(issue: Issue): Observable<Issue> {
    return this.http
      .put<Issue>(Constants.API_URL_ISSUE_MODIFY, issue/* , {
        headers: new HttpHeaders({
          "Content-Type": "application/json"
        })
      } */)
      /* .pipe(catchError(this.handleError)); */
  }

  private handleError(errorResponse: HttpErrorResponse) {
    if (errorResponse.error instanceof ErrorEvent) {
      console.error("Client Side Error: ", errorResponse.error.message);
    } else {
      console.error("Server Side Error: ", errorResponse);
    }

    return 'There is a problem with the service. We are notified & working on it. Please try again later.';
    // new ErrorObservable({'There is a problem with the service. We are notified & working on it. Please try again later.'});
  }
}
