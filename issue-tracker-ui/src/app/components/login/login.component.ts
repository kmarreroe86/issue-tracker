import { Component, OnInit, ViewChild, ElementRef, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Project } from '../../models/project'; // Remove this only for connectivity test
import { ProjectService } from '../../services/projects.service'; // Remove this only for connectivity test
import { AuthService } from '../../services/auth.service';
 import { AppService } from '../../services/app.service';
import { User } from '../../models/user';
import { LoginUser } from '../../models/loginUser';
import { SessionStorage } from '../../core/session.storage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})
export class LoginComponent implements OnInit {
  projects: Project[];
  @ViewChild('usernameInput') private _usernameInput: ElementRef;
  @ViewChild('passwordInput') private _passwordInput: ElementRef;
  public loginUser = {username: '', password: ''};
  errorMessage: string;

  constructor(
    private _authService: AuthService,
    private _appService: AppService,
    private _projectService: ProjectService,
    private _ssessionStorage: SessionStorage,
    private _router: Router) {
      console.log('LoginComponent constructor');
  }

  ngOnInit() {    
    console.log('LoginComponent ngOnInit');
  }

  login() {
    // this._authService.logIn(this.loginUser)
    //   .subscribe(data => {
    //     const loggedUser = JSON.parse(localStorage.getItem('currentUser'));
    //     this._router.navigate(['/projects/user', loggedUser.id]);
    //   }, err => {
    //     this.errorMessage = 'error :  Username or password is incorrect';
    //   });
    // this._appService.obtainAccessToken(this.loginUser);

    this._authService.attemptAuth(this.loginUser.username, this.loginUser.password).subscribe(
      data => {        
        console.log('login token:', data.token);
        this._ssessionStorage.saveToken(data.token);
        this._ssessionStorage.saveCurrentUser(this.loginUser.username);
        
        this._router.navigate(['projects/user/', 1]);
        // this._router.navigate(['/projects/']);
      }, error => {
        console.log('onSubscribe error: ', error);
      },
    );

  }

  // login2() {
  //   console.log('login called');
  //   const id = 1;
  //   const user = 'karel';
  //   const pass = 'admin';
  //   if (user === this._usernameInput.nativeElement.value && pass === this._passwordInput.nativeElement.value) {
  //     this._router.navigate(['/projects/user', id]);
  //   }
  //   // this.projectService.getProjects().subscribe((projects) => {
  //   //   this.projects = projects;
  //   // });
  // }

  private showPassword(): void {
    console.log('showPassword');
    this._passwordInput.nativeElement.type = 'text';
  }

  private hidePassword(): void {
    this._passwordInput.nativeElement.type = 'password';
  }

}
