import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'proj-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {

  @Input() issue: any;
  constructor() { }

  ngOnInit() {
  }

}
