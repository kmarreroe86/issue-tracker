import { Component, OnInit, Input, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-all-projects-section',
  templateUrl: './dashboard-all-projects-section.component.html',
  styleUrls: ['./dashboard-all-projects-section.component.css'],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})
export class DashboardAllProjectsSectionComponent implements OnInit {

  @Input() projects;
  constructor(private _router: Router) { }

  ngOnInit() {
  }

  getProject(id) {     
    this._router.navigate(['project/', id]);
    return false;
  }

}
