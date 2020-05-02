import { Component, OnInit } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { CricapiService } from '../cricapi.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  //taking an array
  public status: boolean;
  public array: any[] = [];

  config: any;

  //dependency injection of Services
  constructor(private breakpointObserver: BreakpointObserver,
    private cric: CricapiService) {
    // paginantion
    this.config = {
      itemsPerPage: 12,
      currentPage: 1,
      totalItems: this.array.length
    };

  }

//recording the change of page
pageChanged(event) {
  this.config.currentPage = event;
}

ngOnInit(): void {
  var i: number = 0;

  // load the upcoming match list on initiation from cric api
  this.cric.matchcalendar().subscribe(
    data => {
      this.array = data.matches;
    },
    err => console.log(err)
  )
}
}
