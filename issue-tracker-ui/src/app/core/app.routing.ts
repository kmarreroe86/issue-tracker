import { UrlPermission } from '../services/url.permission';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../components/login/login.component';
import { ProjectsDashboardComponent } from '../components/projects-dashboard/projects-dashboard.component';
import { HomeComponent } from '../components/home/home.component';

const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    // {path: 'home', component: HomeComponent, canActivate: [UrlPermission]},
    { path: 'projects/user/:userId', component: ProjectsDashboardComponent, canActivate: [UrlPermission] },
    { path: 'projects/user/:userId', component: ProjectsDashboardComponent },
    { path: '**', redirectTo: 'login' }
];

export const routing = RouterModule.forRoot(appRoutes);
