import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OAuthModule } from 'angular-oauth2-oidc';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './app.interceptor';

// Third Party
import { DropdownModule } from 'primeng/dropdown';

// Components
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProjectsDashboardComponent } from './components/projects-dashboard/projects-dashboard.component';


// Services
import { UrlPermission } from './services/url.permission';
import { routing } from './app.routing';
import { AuthService } from './services/auth.service';
import { ProjectService } from './services/projects.service';
import { UserService } from './services/user.service';
import { AppService } from './services/app.service';
import { TokenStorage } from './token.storage';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProjectsDashboardComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    routing, // RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    DropdownModule
    // OAuthModule.forRoot()
  ],
  providers: [
    UrlPermission,
    AuthService,
    ProjectService,
    UserService,
    AppService,
    TokenStorage,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {

}
