import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from '../../services/projects.service';
import { Project } from '../../models/project';

@Component({
  selector: 'app-project-view',
  templateUrl: './project-view.component.html',
  styleUrls: ['./project-view.component.css'],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})
export class ProjectViewComponent implements OnInit {

  private projectId: number;
  project: Project;
  constructor(private _activateRoute: ActivatedRoute, private projectService: ProjectService) { }

  ngOnInit() {
    this._activateRoute.paramMap.subscribe(param => {
      this.projectId = parseInt(param.get('id'), 10);
      this.projectService.getProjectById(this.projectId).subscribe(p => {
        this.project = p;
      });
    });
  }

}
