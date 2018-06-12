import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { SessionStorage } from '../core/session.storage';
import { Constants } from '../core/constans';

@Injectable()
export class UrlPermission implements CanActivate {

    constructor(private _router: Router, private _tokenStorage: SessionStorage) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (this._tokenStorage.getToken()) {
            return true;
        }
        this._router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
}
