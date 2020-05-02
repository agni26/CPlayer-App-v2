import { Component, OnInit } from '@angular/core';
import { CricapiService } from '../cricapi.service';
import { Find } from '../find';
import { FavouritesService } from '../favourites.service';
import { Favs } from '../fav';
import { Recommended } from '../recommended';
import { RecommendedService } from '../recommended.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  stat: boolean;
  config: any;
  val: string;
  fav: Favs;
  recom: Recommended
  list: Array<Find> = [];

  constructor(private cricapi: CricapiService, private favser: FavouritesService, private recomser: RecommendedService) {
    this.val = "";

    this.config = {
      itemsPerPage: 10,
      currentPage: 1,
      totalItems: this.list.length
    };

  }

  pageChanged(event) {
    this.config.currentPage = event;
  }
  ngOnInit() {
  }

  getData(val) {
    console.log(val);
    this.cricapi.searchPlayer(val).subscribe(
      res => {
        this.list = res.data;
        for (let obj of this.list) {
          obj.status = true;
        }
      },
      err => {
        console.log(err)
      })
  }

  addToFav(data) {
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

  removeFromFav(data) {
    data.status = true;
    this.recomser.deleteData(data.pid, sessionStorage.getItem('token')).subscribe(
      res => this.favser.deleteDataUser(sessionStorage.getItem('username'), data.pid, sessionStorage.getItem('token')).subscribe(
        res => console.log(res),
        err => console.log(err)
      ),
      err => {
        if (err.statusText === "OK") {
          this.favser.deleteDataUser(sessionStorage.getItem('username'), data.pid, sessionStorage.getItem('token')).subscribe(
            res => console.log("deleted"),
            err => console.log(err)
          )
        }
      }
    )
  }

}
