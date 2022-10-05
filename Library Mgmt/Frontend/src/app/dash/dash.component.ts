import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrls: ['./dash.component.css']
})
export class DashComponent implements OnInit {

  id: number;
  constructor(private router: Router, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activeRoute.snapshot.params.id;
  }

  goToHome() {
    this.router.navigate(['/home', this.id]);
  }

  goToReturns() {
    this.router.navigate(['/return', this.id]);
  }

}
