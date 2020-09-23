import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BackgroundComponent } from './background/background.component';
import { LoginComponent } from './login/login.component';
import { EmployeeTabsComponent } from './employee-tabs/employee-tabs.component';
import { SupervisorabtsComponent } from './supervisorabts/supervisorabts.component';
import { InfoComponent } from './info/info.component';
import { SubmitMyRequestComponent } from './submit-my-request/submit-my-request.component';
import { ViewMyRequestsComponent } from './view-my-requests/view-my-requests.component';
import { UploadMyGradeComponent } from './upload-my-grade/upload-my-grade.component';
import { PendingRequestsComponent } from './pending-requests/pending-requests.component';
import { PendingGradesComponent } from './pending-grades/pending-grades.component';
import { Employee101Component } from './employee101/employee101.component';

@NgModule({
  declarations: [
    AppComponent,
    BackgroundComponent,
    LoginComponent,
    EmployeeTabsComponent,
    SupervisorabtsComponent,
    InfoComponent,
    SubmitMyRequestComponent,
    ViewMyRequestsComponent,
    UploadMyGradeComponent,
    PendingRequestsComponent,
    PendingGradesComponent,
    Employee101Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
