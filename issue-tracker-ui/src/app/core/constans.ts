
export class Constants {

    // Authorization keys
    public static readonly TOKEN_KEY: string = 'auth_token';
    public static readonly CURRENT_USER: string = 'current_user';

    // Api calls
    public static readonly API_URL_PROJECTS: string = 'http://localhost:8080/project/list/';
    public static readonly API_URL_PROJECT: string = 'http://localhost:8080/project/';
    public static readonly API_URL_PROJECT_ISSUES: string = 'http://localhost:8080/issue/list/'; //TODO: Remove this field.
    public static readonly API_URL_ISSUE_MODIFY: string = 'http://localhost:8080/issue/';

    
    
    public static readonly API_URL_USER: string = 'http://localhost:8080/userdata/';


    // Issues Statuses
    public static readonly ISSUE_STATUS_TODO: string = 'TODO';
    public static readonly ISSUE_STATUS_INPROGRESS: string = 'INPROGRESS';
    public static readonly ISSUE_STATUS_QA: string = 'QA';
    public static readonly ISSUE_STATUS_DONE: string = 'DONE';

}
