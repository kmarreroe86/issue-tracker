import { User } from './user';

export class Project {
    id: number;
    projectName: string;
    projectKey: string;
    projectLead: User;
    url: string;
    // users: Array<User>; // Comment as JsonIgnore from Java
}
