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

  ngOnInit(): void {
    this.recomser.getData(sessionStorage.getItem('token')).subscribe(
      res => this.list = res
    )
}

}
