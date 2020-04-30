import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router: Router) { }

  tologin(){
    this.router.navigate(["/login"])
  }
  tosignup(){
    this.router.navigate(["/signup"])
  }
  todashboard(){
    this.router.navigate(["/dashboard"])
  }
  tocontact(){
    this.router.navigate(["/contact"])
  }
}
