import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employ } from '../employ';

@Component({
  selector: 'app-employ',
  templateUrl: './employ.component.html',
  styleUrls: ['./employ.component.css']
})
export class EmployComponent implements OnInit {

  employ : Employ;
  isSubmitted : boolean;
  msg:string;

  insert(employForm : NgForm) {
    if (employForm.invalid) {
      return;
    }
    this.isSubmitted=true;
    this.msg="Form Submitted"
  }
  constructor() { 
    this.employ = new Employ();
    this.isSubmitted=false;
  }

  ngOnInit(): void {
  }

}
