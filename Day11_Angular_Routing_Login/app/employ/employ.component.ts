import { Component, OnInit } from '@angular/core';
import { Employ } from '../employ';

@Component({
  selector: 'app-employ',
  templateUrl: './employ.component.html',
  styleUrls: ['./employ.component.css']
})
export class EmployComponent implements OnInit {
 employs = [
   new Employ(1,"Bala","Java","Programmer",88244),
   new Employ(2,"Aswin","Dotnet","Developer",91822),
   new Employ(3,"Neha","Java","TeamLead",98774),
   new Employ(4,"Nilesh","Angular","Manager",98774),
   new Employ(5,"Jyoshna","Angular","Programmer",90884),
   new Employ(6,"Kushal","Java","TeamLead",95533),
 ]
  constructor() { }

  ngOnInit(): void {
  }

}
