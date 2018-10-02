import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { ProjectService } from "../../services/projects.service";
import { Project } from "../../models/project";
import { DropEvent } from "ng-drag-drop";

@Component({
  selector: "app-project-view",
  templateUrl: "./project-view.component.html",
  styleUrls: ["./project-view.component.css"],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})
export class ProjectViewComponent implements OnInit {
  todoList = [
    {
      name: "Issue 1",
      description: "Issue description Lorem ipsum dolor sit amet.",
      status: "todo"
    }
  ];
  inProgressList = [
    {
      name: "Issue Progress",
      description: "Issue description Lorem ipsum dolor sit amet.",
      status: "in-progress"
    }
  ];
  qaReviewList = [
    {
      name: "Issue QA",
      description: "Issue description Lorem ipsum dolor sit amet.",
      status: "qa"
    }
  ];
  doneList = [
    {
      name: "Issue done",
      description: "Issue description Lorem ipsum dolor sit amet.",
      status: "done"
    }
  ];

  private projectId: number;
  project: Project;
  constructor(
    private _activateRoute: ActivatedRoute,
    private projectService: ProjectService
  ) {}

  ngOnInit() {
    this._activateRoute.paramMap.subscribe(param => {
      this.projectId = parseInt(param.get("id"), 10);
      this.projectService.getProjectById(this.projectId).subscribe(p => {
        this.project = p;
      });
    });
    // TODO: Get all issues related with this project.
  }

  onTodoDrop(e: DropEvent) {
    this.todoList.push(e.dragData);
    this.removeItem(e.dragData);
    console.log(e);
  }

  onInProgressDrop(e: DropEvent) {
    this.inProgressList.push(e.dragData);
    this.removeItem(e.dragData);
    console.log(e);
  }

  onQADrop(e: DropEvent) {
    this.qaReviewList.push(e.dragData);
    this.removeItem(e.dragData);
    console.log(e);
  }

  onDoneDrop(e: DropEvent) {
    this.doneList.push(e.dragData);
    this.removeItem(e.dragData);
    console.log(e);
  }

  removeItem(item: any) {
    let targetList: any;
    switch (item.status) {
      case "todo":
        targetList = this.todoList;
        console.log("remove from todo");
        break;
      case "in-progress":
        targetList = this.inProgressList;
        console.log("remove from in-progress");
        break;
      case "qa":
        targetList = this.qaReviewList;
        console.log("remove from qa");
        break;
      case "done":
        targetList = this.doneList;
        console.log("remove from done");
        break;
    }
    let index = targetList
      .map(function(e) {
        return e.name;
      })
      .indexOf(item.name);
      targetList.splice(index, 1);
  }

  /* removeItem(item: any, list: Array<any>) {
    let index = list.map(function (e) {
      return e.name
    }).indexOf(item.name);
    list.splice(index, 1);
  } */
}
