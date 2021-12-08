import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms'
import { RouterModule,Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { TwoWayComponent } from './two-way/two-way.component';
import { CalcComponent } from './calc/calc.component';
import { CheckDemoComponent } from './check-demo/check-demo.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { EmployComponent } from './employ/employ.component';
import { EmployDropDownComponent } from './employ-drop-down/employ-drop-down.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';

// const appRoutes : Routes = 
// [
//   {path:'twoway',component:TwoWayComponent},
//   {path:'calc',component:CalcComponent},
//   {path:'checkdemo',component:CheckDemoComponent},
//   {path:'attendance',component:AttendanceComponent},
//   {path:'employ',component:EmployComponent},
//   {path:'employdropdown',component:EmployDropDownComponent},
//   {path:'',component:MenuComponent}
// ]

const appRoutes : Routes = 
[
  {path:'',component:LoginComponent},
  {path:'menu',component:MenuComponent,children:
  [
    {path:'twoway',component:TwoWayComponent,outlet:'mphasis'},
    {path:'calc',component:CalcComponent,outlet:'mphasis'},
    {path:'checkdemo',component:CheckDemoComponent,outlet:'mphasis'},
    {path:'attendance',component:AttendanceComponent,outlet:'mphasis'},
    {path:'employ',component:EmployComponent,outlet:'mphasis'},
    {path:'employdropdown',component:EmployDropDownComponent,outlet:'mphasis'},
  ]
  }
]
@NgModule({
  declarations: [
    AppComponent,
    TwoWayComponent,
    CalcComponent,
    CheckDemoComponent,
    AttendanceComponent,
    EmployComponent,
    EmployDropDownComponent,
    MenuComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule, 
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
