import { Injectable } from '@angular/core';
import { Constants } from './constans';

// const TOKEN_KEY = 'AuthToken';

@Injectable()
export class SessionStorage {

    constructor(/* private _constants: Constants */) { }

    signOut() {
        window.sessionStorage.removeItem(Constants.TOKEN_KEY);
        window.sessionStorage.removeItem(Constants.CURRENT_USER);
        window.sessionStorage.clear();
    }

    public saveToken(token: string) {
        window.sessionStorage.removeItem(Constants.TOKEN_KEY);
        window.sessionStorage.setItem(Constants.TOKEN_KEY, token);
    }

    public saveCurrentUser(username: string): void {
        window.sessionStorage.setItem(Constants.CURRENT_USER, username);
    }

    public getToken(): string {
        return sessionStorage.getItem(Constants.TOKEN_KEY);
    }

    public getLoggedUser(): string {
        return sessionStorage.getItem(Constants.CURRENT_USER);
    }
}
