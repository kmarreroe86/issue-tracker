import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgSwitch } from '@angular/common';

import { UserService } from '../../services/user.service';
import { Project } from '../../models/project';
import { ProjectService } from '../../services/projects.service';


@Component({
  selector: 'app-projects-dashboard',
  templateUrl: './projects-dashboard.component.html',
  styleUrls: ['./projects-dashboard.component.css'],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})
export class ProjectsDashboardComponent implements OnInit {

  private _userId: number;
  selectedCategory = '';
  userProjects: Project[];

  constructor(/* private _userService: UserService */ private _projectService: ProjectService, private _activateRoute: ActivatedRoute) { }

  ngOnInit() {
    this._activateRoute.paramMap.subscribe(param => {
      this._userId = parseInt(param.get('userId'), 10);
      this._projectService.getUserProjects(this._userId).subscribe((projects) => {
        this.userProjects = projects;
        this.selectedCategory = 'all_projects';
      });
    });
  }

  selectCategory(category: string) {
    this.selectedCategory = category;
    console.log(category);
    return false;
  }

}
