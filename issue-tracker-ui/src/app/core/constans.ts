import { Injectable } from '@angular/core';

export class Constants {

    // Authorization keys
    public static readonly TOKEN_KEY: string = 'auth_token';
    public static readonly CURRENT_USER: string = 'current_user';

    // Api calls
    public static readonly API_URL_PROJECTS: string = 'http://localhost:8080/projects/';
}
