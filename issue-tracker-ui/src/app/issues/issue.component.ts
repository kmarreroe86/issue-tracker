import { Component, OnInit, Input } from '@angular/core';
import { Issue } from '../models/issue';

@Component({
  selector: 'proj-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {

  @Input() issue: Issue;
  constructor() { }

  ngOnInit() {
  }

}
