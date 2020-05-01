import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RouterService } from './router.service';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient, private route: RouterService) { }

  signup(user:User){
    return this.httpClient.post<User>("http://localhost:8001/api/user", user)
  }

}
