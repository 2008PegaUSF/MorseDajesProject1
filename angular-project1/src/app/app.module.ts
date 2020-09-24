import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EmployeeTabsComponent } from './employee-tabs/employee-tabs.component';
import { SubmitMyRequestComponent } from './submit-my-request/submit-my-request.component';
import { ViewMyRequestsComponent } from './view-my-requests/view-my-requests.component';
import { UploadMyGradeComponent } from './upload-my-grade/upload-my-grade.component';
import { PendingRequestsComponent } from './pending-requests/pending-requests.component';
import { PendingGradesComponent } from './pending-grades/pending-grades.component';
import { Employee101Component } from './employee101/employee101.component';
import { Supervisor101Component } from './supervisor101/supervisor101.component';
import { SupervisorTabsComponent } from './supervisor-tabs/supervisor-tabs.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeTabsComponent,
    SubmitMyRequestComponent,
    ViewMyRequestsComponent,
    UploadMyGradeComponent,
    PendingRequestsComponent,
    PendingGradesComponent,
    Employee101Component,
    Supervisor101Component,
    SupervisorTabsComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
