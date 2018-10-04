import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { ProjectService } from "../../services/projects.service";
import { IssueService } from "../../services/issue.service";
import { Project } from "../../models/project";
import { DropEvent } from "ng-drag-drop";
import { Issue } from "../../models/issue";
import { Constants } from "../../core/constans";

@Component({
  selector: "app-project-view",
  templateUrl: "./project-view.component.html",
  styleUrls: ["./project-view.component.css"],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})
export class ProjectViewComponent implements OnInit {
  
  todoList: Array<Issue> = new Array<Issue>();
  inProgressList: Array<Issue> = new Array<Issue>();
  qaReviewList: Array<Issue> = new Array<Issue>();
  doneList: Array<Issue> = new Array<Issue>();
  private projectId: number;
  project: Project;

  constructor(
    private _activateRoute: ActivatedRoute,
    private projectService: ProjectService,
    private issueService: IssueService
  ) {}

  ngOnInit() {
    this._activateRoute.paramMap.subscribe(param => {
      this.projectId = parseInt(param.get("id"), 10);
      this.projectService.getProjectById(this.projectId).subscribe(p => {
        this.project = p;
        this.initIssuesColumns();
      });
    });
  }

  initIssuesColumns() {
    this.project.issues.forEach(i => {
      switch (i.issueStatus) {
        case Constants.ISSUE_STATUS_TODO:
        this.todoList.push(i);
          break;
        case Constants.ISSUE_STATUS_INPROGRESS:
        this.inProgressList.push(i);
          break;
        case Constants.ISSUE_STATUS_QA:
        this.qaReviewList.push(i);
          break;
        case Constants.ISSUE_STATUS_DONE:
        this.doneList.push(i);
          break;
      }
    });    
  }

  onTodoDrop(e: DropEvent) {    
    const targetIssue: Issue = Object.assign({}, e.dragData);    
    targetIssue.issueStatus = Constants.ISSUE_STATUS_TODO;    
    this.issueService.changeIssueStatus(targetIssue).subscribe((issue) => {
      this.removeItem(e.dragData);
      this.todoList.push(issue);
    });
  }

  onInProgressDrop(e: DropEvent) {
    const targetIssue: Issue = Object.assign({}, e.dragData);    
    targetIssue.issueStatus = Constants.ISSUE_STATUS_INPROGRESS;    
    this.issueService.changeIssueStatus(targetIssue).subscribe((issue) => {
      this.removeItem(e.dragData);
      this.inProgressList.push(issue);
    });
  }

  onQADrop(e: DropEvent) {
    const targetIssue: Issue = Object.assign({}, e.dragData);    
    targetIssue.issueStatus = Constants.ISSUE_STATUS_QA;    
    this.issueService.changeIssueStatus(targetIssue).subscribe((issue) => {
      this.removeItem(e.dragData);
      this.qaReviewList.push(issue);
    });
  }

  onDoneDrop(e: DropEvent) {
    const targetIssue: Issue = Object.assign({}, e.dragData);    
    targetIssue.issueStatus = Constants.ISSUE_STATUS_DONE;    
    this.issueService.changeIssueStatus(targetIssue).subscribe((issue) => {
      this.removeItem(e.dragData);
      this.doneList.push(issue);
    });
  }

  removeItem(item: any) {

    let targetList: Array<Issue> = new Array<Issue>();
    switch (item.issueStatus) {
      case Constants.ISSUE_STATUS_TODO:
        targetList = this.todoList;
        console.log("remove from todo");
        break;
      case Constants.ISSUE_STATUS_INPROGRESS:
        targetList = this.inProgressList;
        console.log("remove from in-progress");
        break;
      case Constants.ISSUE_STATUS_QA:
        targetList = this.qaReviewList;
        console.log("remove from qa");
        break;
      case Constants.ISSUE_STATUS_DONE:
        targetList = this.doneList;
        console.log("remove from done");
        break;
    }
    let index = targetList
      .map(function(e) {
        return e.title;
      })
      .indexOf(item.title);
    targetList.splice(index, 1);
  }

  /* removeItem(item: any, list: Array<any>) {
    let index = list.map(function (e) {
      return e.name
    }).indexOf(item.name);
    list.splice(index, 1);
  } */
}
