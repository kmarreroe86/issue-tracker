import { Injectable } from '@angular/core';

export class Constants {

    // Authorization keys
    public static readonly TOKEN_KEY: string = 'auth_token';
    public static readonly CURRENT_USER: string = 'current_user';

    // Api calls
    public static readonly API_URL_PROJECTS: string = 'http://localhost:8080/projects/';
    public static readonly API_URL_PROJECT: string = 'http://localhost:8080/project/';
    
    
    public static readonly API_URL_USER: string = 'http://localhost:8080/userdata/';



}
