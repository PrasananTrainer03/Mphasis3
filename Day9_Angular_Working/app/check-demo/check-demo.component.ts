import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-check-demo',
  templateUrl: './check-demo.component.html',
  styleUrls: ['./check-demo.component.css']
})
export class CheckDemoComponent implements OnInit {

  status :boolean;
  constructor() { 
    this.status=false;
  }

  ngOnInit(): void {
  }

}
