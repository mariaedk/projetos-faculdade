import { Component, OnInit } from '@angular/core';


@Component({

  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']

})

export class NavbarComponent implements OnInit {
  constructor() { }

  user: string = '';
  isLogged: boolean = false;

  ngOnInit(): void {
    this.getSessionStorage();
    if (this.user != '') {
      this.isLogged = true;
    }
  }

  getSessionStorage() {
    if (sessionStorage.getItem('usuario')! != null) {
      this.user = JSON.parse(sessionStorage.getItem('usuario')!).usuario
    }
  }

  logout() {
    this.isLogged = false;
    sessionStorage.removeItem('usuario');
    sessionStorage.removeItem('senha');
  }

}


