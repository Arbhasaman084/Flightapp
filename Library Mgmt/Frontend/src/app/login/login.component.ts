import { Router } from '@angular/router';
import { MemberService } from './../member.service';
import { Members } from './members';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id: number;
  member: Members = new Members();

  constructor(private memberService: MemberService, private router: Router) { }

  ngOnInit(): void {
    console.log("Login component");
  }

  login(id: number) {
    this.memberService.getMemberDetails(id)
      .subscribe(data => {
        if (data == null) {
          alert("Register to Continue. Please contact Admin");
          this.id = 0;
        } else {
          console.log(data);

          this.member = data;
          this.router.navigate(['/dash', this.member.memberId]);
        }
      }, error => console.log(error));
  }
}
