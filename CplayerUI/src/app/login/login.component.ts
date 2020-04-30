import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { RouterService } from '../router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route : RouterService) { }

  ngOnInit(): void {
  }

  loginForm = new FormGroup({
    email : new FormControl('',[Validators.required]),
    password : new FormControl('',[Validators.required,Validators.minLength(8)])

  })

  get email(){
   return this.loginForm.get('email');
  }

  get password(){
    return this.loginForm.get('password');
  }

  logIn(){
    console.log(this.loginForm.value);
  }

  tosignup(){
    this.route.tosignup();
  }

}