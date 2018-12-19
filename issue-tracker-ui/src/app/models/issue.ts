import { Project } from "./project";

export class Issue {
    id: number;
    title: string;
    description: string;
    issueType: string;
    issuePriority: string;
    issueStatus: string;
    storyPoints: number;
    createdDate: string;
    _links: Array<string>;

    /* projectId: number; */
    project: Project;
    assignedUserId: number;
}
