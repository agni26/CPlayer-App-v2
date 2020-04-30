import { Component, OnInit } from '@angular/core';
import {signupUser } from './signuser'
import {NgForm, FormGroupDirective} from '@angular/forms';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
   
  user:signupUser;
  signup : NgForm;
  constructor() { 
    this.user=new signupUser();
  }

  ngOnInit(): void {
  }
    signupData(signup: NgForm){
      console.log(signup.value);
      this.user = signup.value;
      signup.reset();
    }

}
