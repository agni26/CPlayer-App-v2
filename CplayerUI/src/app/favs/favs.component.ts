import { Component, OnInit } from '@angular/core';
import { FavouritesService } from '../favourites.service';
import { Favs } from '../fav';

@Component({
  selector: 'app-favs',
  templateUrl: './favs.component.html',
  styleUrls: ['./favs.component.css']
})
export class FavsComponent implements OnInit {

  list : Array<Favs>;

  constructor(private favser : FavouritesService) { }

  ngOnInit(): void {
    this.favser.getData(sessionStorage.getItem('username'),sessionStorage.getItem('token')).subscribe(
      res => {
        this.list = res;
      },
      err => console.log(err)
    )    
  }

  removeFromFav(data){
    console.log("removed");
  }

  addToFav(data){
    console.log("added");
    
  }

}
