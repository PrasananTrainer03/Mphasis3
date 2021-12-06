import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms'
import { AppComponent } from './app.component';
import { TwoWayComponent } from './two-way/two-way.component';
import { CalcComponent } from './calc/calc.component';
import { CheckDemoComponent } from './check-demo/check-demo.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { EmployComponent } from './employ/employ.component';
import { EmployDropDownComponent } from './employ-drop-down/employ-drop-down.component';

@NgModule({
  declarations: [
    AppComponent,
    TwoWayComponent,
    CalcComponent,
    CheckDemoComponent,
    AttendanceComponent,
    EmployComponent,
    EmployDropDownComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
