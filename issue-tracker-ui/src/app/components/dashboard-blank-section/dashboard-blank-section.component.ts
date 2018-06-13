import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-dashboard-blank-section',
  templateUrl: './dashboard-blank-section.component.html',
  styleUrls: ['./dashboard-blank-section.component.css']
})
export class DashboardBlankSectionComponent implements OnInit {

  @Input() section;
  sectionSelected: string;
  constructor() { }

  ngOnInit() {
    this.sectionSelected = this.section;
  }

}
