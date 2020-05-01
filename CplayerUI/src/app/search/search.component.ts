import { Component, OnInit } from '@angular/core';
import { CricapiService } from '../cricapi.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  status: boolean;
  config: any;
  val: string;
  list: Array<any> = [];

  constructor(private cricapi: CricapiService) {
    this.val = "";

    this.config = {
      itemsPerPage: 12,
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
        val = "";
      },
      err => {
        console.log(err)
      })
  }

  addToFav(pid) {
    this.status = false;
    console.log(pid);

  }

  removeFromFav(pid) {
    this.status = true;
    console.log(pid);
  }

}
