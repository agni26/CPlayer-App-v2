import { Component, OnInit } from '@angular/core';
import { FavouritesService } from '../favourites.service';
import { Favs } from '../fav';
import { RecommendedService } from '../recommended.service';
import { Recommended } from '../recommended';
import { CricapiService } from '../cricapi.service';

@Component({
  selector: 'app-favs',
  templateUrl: './favs.component.html',
  styleUrls: ['./favs.component.css']
})
export class FavsComponent implements OnInit {

  list : Array<Favs>;
  fav: Favs;
  recom: Recommended

  constructor(private favser : FavouritesService, private recomser : RecommendedService, private cricapi : CricapiService) { }

  ngOnInit(): void {
    this.favser.getData(sessionStorage.getItem('username'),sessionStorage.getItem('token')).subscribe(
      res => {
        this.list = res;
      },
      err => console.log(err)
    )    
  }

  removeFromFav(data){
    data.status = true;
    this.recomser.deleteData(data.pid, sessionStorage.getItem('token')).subscribe(
      res => this.favser.deleteDataUser(sessionStorage.getItem('username'), data.pid, sessionStorage.getItem('token')).subscribe(
        res => console.log(res),
        err => console.log(err)
      ),
      err => {
        if (err.statusText === "OK") {
          this.favser.deleteDataUser(sessionStorage.getItem('username'), data.pid, sessionStorage.getItem('token')).subscribe(
            res => location.reload(),
            err => console.log(err)
          )
        }
      }
    )
  }

  addToFav(data){
    data.status = false;
    this.cricapi.statsPlayer(data.pid).subscribe(
      res => {
        this.fav = res;
        this.recom = res;
        this.fav.status = false;
        this.fav.username = sessionStorage.getItem('username');
        this.recomser.addData(this.recom, sessionStorage.getItem('token')).subscribe(
          res => {
            this.favser.addData(this.fav, sessionStorage.getItem('token'))
          },
          err => {
            if (err.statusText === "OK") {
              this.favser.addData(this.fav, sessionStorage.getItem('token')).subscribe(
                res => console.log(res),
                err => {
                  if (err.statusText === "OK") {
                    console.log("Success")
                  }
                })
            }
          })
      },
      err => console.log(err)

    )    
  }

}
