import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { UserService } from '../../services/user.service';
import { Project } from '../../models/project';


@Component({
  selector: 'app-projects-dashboard',
  templateUrl: './projects-dashboard.component.html',
  styleUrls: ['./projects-dashboard.component.css']
})
export class ProjectsDashboardComponent implements OnInit {

  private _userId: number;
  userProjects: Project[];

  constructor(private _userService: UserService, private _activateRoute: ActivatedRoute) { }

  ngOnInit() {
    this._activateRoute.paramMap.subscribe(param => {
      this._userId = parseInt(param.get('userId'), 10);
      this._userService.getUserProjects(this._userId).subscribe((projects) => {
        this.userProjects = projects;
      });
    });
  }

}