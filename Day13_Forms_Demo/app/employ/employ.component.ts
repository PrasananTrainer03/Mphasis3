import { ThrowStmt } from '@angular/compiler';
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
  isFormSubmitted : boolean;
  msg : string;

  insert(employForm : NgForm) {
    if (employForm.invalid) {
      return;
    }
    this.isFormSubmitted=true;
    this.msg="Form Submiited Successfully...";
  }
  constructor() {
    this.employ = new Employ();
    this.isFormSubmitted=false;
   }

  ngOnInit(): void {
  }

}
