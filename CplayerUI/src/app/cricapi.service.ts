import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CricapiService {

  constructor(private router: Router, private http: HttpClient) { }

  apikey: string = "dLGeON2q1aTVihU2hxeInpYKUNM2";

  searchPlayer(name: string): Observable<any> {
    return this.http.get(`https://cricapi.com/api/playerFinder?apikey=${this.apikey}`, {
      params: new HttpParams().set("name", name)
    });
  }

  statsPlayer(pid: number): Observable<any> {
    return this.http.get(`https://cricapi.com/api/playerStats?apikey=${this.apikey}`, {
      params: new HttpParams().set("pid", pid.toString())
    })
  }

  matchcalendar(): Observable<any> {
    return this.http.get<any>(`https://cricapi.com/api/matches?apikey=${this.apikey}`)
  }


}
