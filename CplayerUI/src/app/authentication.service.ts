import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuth } from './userAuth';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient, private users: UserService) { }

  signup(userauth: UserAuth): Observable<any>{
    return this.httpClient.post<UserAuth>('http://localhost:8000/api/auth/register', userauth)
  }

  setBearerToken(token: string) {
    sessionStorage.setItem('token', token);
  }
  getBearerToken() {
    return sessionStorage.getItem('token');
  }

  login(userinfo: UserAuth): Observable<any> {
    return this.httpClient.post<any>('http://localhost:8000/api/auth/login', userinfo).pipe(
      map(
        userData => {
          return userData;
        }));
  }

  isUserAuthenticated(token){
    return this.httpClient.post('http://localhost:8000/api/auth/check', {}, {
      headers: new HttpHeaders().set('Authorization', `Bearer ${token}`)
    })
  }

}
