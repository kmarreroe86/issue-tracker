import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

// Components
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ProjectsDashboardComponent } from './components/projects-dashboard/projects-dashboard.component';


// Services
import { ProjectService } from './services/projects.service';
import { UserService } from './services/user.service';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'projects/user/:userId', component: ProjectsDashboardComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProjectsDashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ProjectService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
