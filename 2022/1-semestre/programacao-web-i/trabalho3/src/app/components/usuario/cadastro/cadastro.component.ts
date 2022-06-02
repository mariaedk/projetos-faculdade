import { CookieService } from 'ngx-cookie-service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  constructor(private cookie: CookieService) { }

  user: string = '';
  formNome!: any;
  formEmail!: any;
  formUsuario!: any;
  formSenha!: any;

  ngOnInit(): void
  {
    this.formNome = new FormGroup({
      nome: new FormControl(''),
    })
    this.formEmail = new FormGroup({
      email: new FormControl(''),
    })
    this.formUsuario = new FormGroup({
      usuario: new FormControl(''),
    })
    this.formSenha = new FormGroup({
      senha: new FormControl(''),
    })
  }

  saveInLocalStorageAndSessionStorage()
  {
    localStorage.setItem("nome", JSON.stringify(this.formNome.value));
    localStorage.setItem("email", JSON.stringify(this.formEmail.value));
    localStorage.setItem("usuario", JSON.stringify(this.formUsuario.value));
    localStorage.setItem("senha", JSON.stringify(this.formSenha.value));
    sessionStorage.setItem("usuario", JSON.stringify(this.formUsuario.value));
    sessionStorage.setItem("senha", JSON.stringify(this.formSenha.value));
  }

  setCookie()
  {
    console.log('setando cookie')
    this.cookie.set('name', this.user);
    console.log(this.user)
  }

  setarCookie()
  {
    this.setCookie();
  }
}
