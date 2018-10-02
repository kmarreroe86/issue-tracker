import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './core/app.interceptor';

// Third Party
import { DropdownModule } from 'primeng/dropdown';
import { NgDragDropModule } from 'ng-drag-drop';

// Components
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ProjectsDashboardComponent } from './components/projects-dashboard/projects-dashboard.component';
import { ProjectViewComponent } from './components/project-view/project-view.component';
import { DashboardAllProjectsSectionComponent } from './components/dashboard-all-projects-section/dashboard-all-projects-section.component';
import { DashboardBlankSectionComponent } from './components/dashboard-blank-section/dashboard-blank-section.component';
import { IssueComponent } from './issues/issue.component';

// Services
import { UrlPermission } from './services/url.permission';
import { routing } from './core/app.routing';
import { AuthService } from './services/auth.service';
import { ProjectService } from './services/projects.service';
import { UserService } from './services/user.service';
import { AppService } from './services/app.service';
import { SessionStorage } from './core/session.storage';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProjectsDashboardComponent,    
    DashboardAllProjectsSectionComponent,
    DashboardBlankSectionComponent,
    ProjectViewComponent,
    IssueComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    routing, // RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    DropdownModule,
    NgDragDropModule.forRoot()
  ],
  providers: [
    UrlPermission,
    AuthService,
    ProjectService,
    UserService,
    AppService,
    SessionStorage,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {

}
