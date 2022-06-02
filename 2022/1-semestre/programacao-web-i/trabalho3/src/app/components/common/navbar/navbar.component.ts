import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private cookie: CookieService) {}

  user: string = '';

  getCookie()
  {
    this.user = this.cookie.get('name');
  }

  ngOnInit(): void
  {
    this.getCookie();
  }

}
