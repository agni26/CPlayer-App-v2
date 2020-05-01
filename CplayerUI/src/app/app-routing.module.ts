import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ContactComponent } from './contact/contact.component';
import { RouteguardGuard } from './routeguard.guard';
import { SearchComponent } from './search/search.component';
import { StatsComponent } from './stats/stats.component';
import { FavouritesService } from './favourites.service';
import { RecommendedService } from './recommended.service';
import { CalendarComponent } from './calendar/calendar.component';
import { FavsComponent } from './favs/favs.component';
import { RecomComponent } from './recom/recom.component';
import { VenueComponent } from './venue/venue.component';
import { EdituserComponent } from './edituser/edituser.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    // canActivate: [RouteguardGuard],
    children: [
      {
        path : '',
        redirectTo : 'search',
        pathMatch : 'full'
      },
      {
        path : 'search',
        component : SearchComponent
      },
      {
        path : 'stats',
        component : StatsComponent
      },
      {
        path : 'favs',
        component : FavsComponent,
      },
      {
        path : 'recom',
        component : RecomComponent
      },
      {
        path : 'cal',
        component : CalendarComponent
      },
      {
        path : 'venue',
        component : VenueComponent
      },
      {
        path : 'edit',
        component : EdituserComponent
      },
      {
        path: 'contact',
        component: ContactComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
