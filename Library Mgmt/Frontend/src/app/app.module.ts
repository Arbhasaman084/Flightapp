import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BooklistComponent } from './booklist/booklist.component';
import { BookdetailsComponent } from './bookdetails/bookdetails.component';
import { AddnewbookComponent } from './addnewbook/addnewbook.component';
import { LoginComponent } from './login/login.component';
import { DashComponent } from './dash/dash.component';
import { ReturnsComponent } from './returns/returns.component';


@NgModule({
  declarations: [
    AppComponent,
    BooklistComponent,
    BookdetailsComponent,
    AddnewbookComponent,
    LoginComponent,
    DashComponent,
    ReturnsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
