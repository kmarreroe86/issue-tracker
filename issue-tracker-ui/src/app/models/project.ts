import { User } from './user';
import { Issue } from './issue';

export class Project {
    id: number;
    projectName: string;
    projectKey: string;
    projectLead: User;
    url: string;
    issues: Array<Issue>;
    // users: Array<User>; // Comment as JsonIgnore from Java
}
