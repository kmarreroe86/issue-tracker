import { Role } from './role';

export class User {
    id: string;
    username: string;
    // password: string;
    role: string;
    _links: Array<string>;
}
