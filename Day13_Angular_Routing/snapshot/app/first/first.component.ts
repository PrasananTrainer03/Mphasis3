import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {
  company:string;
  show() {
    this._router.navigate(["/third",this.company]);
  }
  constructor(private _router : Router) {
    this.company="Mphasis";
   }

  ngOnInit(): void {
  }

}
