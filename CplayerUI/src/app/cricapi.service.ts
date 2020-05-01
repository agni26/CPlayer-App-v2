import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CricapiService {

  constructor(private router: Router, private http : HttpClient) { }

  apikey :string = "dLGeON2q1aTVihU2hxeInpYKUNM2";

  searchPlayer(name:string):Observable<any>{
    return this.http.get(`https://cricapi.com/api/playerFinder?apikey=${this.apikey}`, {
        params: new HttpParams().set("name", name)
    });
  }

  statsPlayer(pid:number):Observable<any>{
    return this.http.get(`https://cricapi.com/api/playerStats?apikey=${this.apikey}`,{
      params: new HttpParams().set("pid", pid.toString())
    })
  }

  matchcalendar():Observable<any>{
    return this.http.get<JSON>(`https://cricapi.com/api/matches?apikey=${this.apikey}`)
  }

  venues():Observable<any>{
    return this.http.get('https://cricket.sportmonks.com/api/v2.0/venues?api_token=Ksuqqo3CgVPunQzvPYLy0FvV3TqVpi4m18O5U7u8Asz5LyalTJjLAFUwIPxr')
  }

}
