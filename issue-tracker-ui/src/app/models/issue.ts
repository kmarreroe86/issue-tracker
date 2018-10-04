
export class Issue {
    id: number;
    title: string;
    description: string;
    issueType: string;
    issuePriority: string;
    issueStatus: string;
    storyPoints: number;
    createdDate: string;

    projectId: number;
    assignedUserId: number;
}
