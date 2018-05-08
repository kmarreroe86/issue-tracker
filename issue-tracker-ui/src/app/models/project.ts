import { User } from './user';

export class Project {
    id: number;
    projectName: string;
    users: Array<User>;
}
