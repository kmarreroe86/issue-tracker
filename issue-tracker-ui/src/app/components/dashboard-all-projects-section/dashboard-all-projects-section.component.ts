import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-dashboard-all-projects-section',
  templateUrl: './dashboard-all-projects-section.component.html',
  styleUrls: ['./dashboard-all-projects-section.component.css']
})
export class DashboardAllProjectsSectionComponent implements OnInit {

  @Input() projects;
  constructor() { }

  ngOnInit() {
  }

}
