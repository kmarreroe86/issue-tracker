import { Component, OnInit, ViewChild, ElementRef, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Project } from '../../models/project'; // Remove this only for connectivity test
import { ProjectService } from '../../services/projects.service'; // Remove this only for connectivity test

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

  constructor(private _projectService: ProjectService, private _router: Router) {
  }

  ngOnInit() {
  }

  login() {
    console.log('login called');
    const id = 1;
    const user = 'karel';
    const pass = 'admin';
    if (user === this._usernameInput.nativeElement.value && pass === this._passwordInput.nativeElement.value) {
      this._router.navigate(['/projects/user', id]);
    }
    // this.projectService.getProjects().subscribe((projects) => {
    //   this.projects = projects;
    // });
  }

  private showPassword(): void {
    console.log('showPassword');
    this._passwordInput.nativeElement.type = 'text';
  }

  private hidePassword(): void {
    this._passwordInput.nativeElement.type = 'password';
  }

}
