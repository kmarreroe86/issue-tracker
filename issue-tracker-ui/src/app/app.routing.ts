import { UrlPermission } from './services/url.permission';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ProjectsDashboardComponent } from './components/projects-dashboard/projects-dashboard.component';
// import { AppComponent } from './app.component';
 import { HomeComponent } from './components/home/home.component';

const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    {path: '', component: HomeComponent, canActivate: [UrlPermission]},
    { path: 'projects/user/:userId', component: ProjectsDashboardComponent, canActivate: [UrlPermission] },
    {path: '**', redirectTo: 'login'}    
];

export const routing = RouterModule.forRoot(appRoutes);
