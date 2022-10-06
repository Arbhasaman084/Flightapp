import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentBookingComponent } from './components/appointment-booking/appointment-booking.component';
import { FindSlotComponent } from './components/find-slot/find-slot.component';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'find-slot',component:FindSlotComponent},
  {path:'book-appointment',component:AppointmentBookingComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
