import { ReturnsComponent } from './returns/returns.component';
import { DashComponent } from './dash/dash.component';
import { LoginComponent } from './login/login.component';
import { AddnewbookComponent } from './addnewbook/addnewbook.component';
import { BookdetailsComponent } from './bookdetails/bookdetails.component';
import { BooklistComponent } from './booklist/booklist.component';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "dash/:id", component: DashComponent},
  {path: "return/:id", component: ReturnsComponent},
  {path: "home/:id", component: BooklistComponent},
  {path: "details/:id/:val", component: BookdetailsComponent},
  {path: "add", component: AddnewbookComponent},
  {path: "", redirectTo: "login", pathMatch: 'full'}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
