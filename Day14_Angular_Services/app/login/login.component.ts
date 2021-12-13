import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isSubmiited : boolean;
  login(loginForm : NgForm) {
    if (loginForm.invalid) {
      return;
    }
    this.isSubmiited=true;
    if (this.userName=="Mphasis" && this.passWord=="Mphasis") {
      alert("correct Credentails...");
    } else {
      alert("Invalid Credentials...")
    }
  }
  
  userName : string;
  passWord : string;
  constructor() { 
    this.isSubmiited=false;
  }

  ngOnInit(): void {
  }

}
