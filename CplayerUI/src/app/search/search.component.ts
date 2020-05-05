import { Component, OnInit } from '@angular/core';
import { CricapiService } from '../cricapi.service';
import { Find } from '../find';
import { FavouritesService } from '../favourites.service';
import { Favs } from '../fav';
import { Recommended } from '../recommended';
import { RecommendedService } from '../recommended.service';
import { RouterService } from '../router.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

// search player by name functionality
export class SearchComponent implements OnInit {

  stat: boolean;
  config: any;
  val: string;
  fav: Favs;
  recom: Recommended
  list: Array<Find> = [];

  // Dependency Injection of cric api, fav service and recommended service
  constructor(private cricapi: CricapiService, private favser: FavouritesService,
    private recomser: RecommendedService, private route: RouterService) {
    this.val = "";
    // paginantion
    this.config = {
      itemsPerPage: 10,
      currentPage: 1,
      totalItems: this.list.length
    };

  }

  // Page events are stored in config
  pageChanged(event) {
    this.config.currentPage = event;
  }
  ngOnInit() {
    if (sessionStorage.getItem('token') == null || sessionStorage.getItem('username') == null) {
      this.route.tologin();
    }

  }

  // It will call cric api service and get list of players
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

  // it will add a player into recommended as well as the favourites by calling there respective services
  addToFav(data) {
    data.status = false;
    this.cricapi.statsPlayer(data.pid).subscribe(
      res => {
        this.fav = res;
        this.recom = res;
        this.fav.status = false;
        this.fav.username = sessionStorage.getItem('username');
        this.recomser.addData(this.recom, sessionStorage.getItem('token')).subscribe(
          res => console.log("added to fav"),
          err => console.log(err)
        )
        this.favser.addData(this.fav, sessionStorage.getItem('token')).subscribe(
          res => console.log("added to recom"),
          err => console.log(err)
          )
      },
      err => console.log(err)
    )
  }

  // it will remove a player from recommended as well as the favourites by calling there respective services
  removeFromFav(data) {
    data.status = true;
    this.recomser.deleteData(data.pid, sessionStorage.getItem('token')).subscribe(
      res => console.log("removed from fav"),
      err => console.log(err)
    )
    this.favser.deleteDataUser(sessionStorage.getItem('username'), data.pid, sessionStorage.getItem('token')).subscribe(
      res => console.log("removed from recom"),
      err => console.log(err)
    )
  }

}
