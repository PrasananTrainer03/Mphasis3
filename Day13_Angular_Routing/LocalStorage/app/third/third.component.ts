import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-third',
  templateUrl: './third.component.html',
  styleUrls: ['./third.component.css']
})
export class ThirdComponent implements OnInit {

  trainer : string;
  company : string;

  constructor() {
    this.company=localStorage.getItem("company")
    this.trainer="Prasanna";
   }

  ngOnInit(): void {
  }

}
