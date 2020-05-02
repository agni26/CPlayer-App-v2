import { Component, OnInit } from '@angular/core';
import { RecommendedService } from '../recommended.service';

@Component({
  selector: 'app-recom',
  templateUrl: './recom.component.html',
  styleUrls: ['./recom.component.css']
})
export class RecomComponent implements OnInit {

  list: Array<any>;

  constructor(private recomser: RecommendedService) { }

  // get all the recommended data from our DB
  ngOnInit(): void {
    this.recomser.getData(sessionStorage.getItem('token')).subscribe(
      res => this.list = res
    )
  }

}
