import { Component, OnInit } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { CricapiService } from '../cricapi.service';

@Component({
  selector: 'app-venue',
  templateUrl: './venue.component.html',
  styleUrls: ['./venue.component.css']
})
export class VenueComponent implements OnInit {

   //taking an array
   public status: boolean;
   public array: any[] = [];
 
   config: any;
 
   //dependency injection of Services
   constructor(private breakpointObserver: BreakpointObserver,
     private cric: CricapiService) {
 
     this.config = {
       itemsPerPage: 12,
       currentPage: 1,
       totalItems: this.array.length
     };
 
   }
 
   pageChanged(event) {
     this.config.currentPage = event;
   }
 
   ngOnInit(): void {
     var i: number = 0;
 
     this.cric.venues().subscribe(
       res => {
         this.array = res.data;
         console.log(res);
         
       },
       err => console.log(err)
     )
   }

}
