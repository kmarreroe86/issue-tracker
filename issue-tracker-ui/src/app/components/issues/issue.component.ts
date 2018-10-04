import { Component, OnInit, Input, ViewEncapsulation } from '@angular/core';
import { Issue } from '../../models/issue';

@Component({
  selector: 'proj-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css'],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})
export class IssueComponent implements OnInit {

  @Input() issue: Issue;
  constructor() { }

  ngOnInit() {
  }

}
