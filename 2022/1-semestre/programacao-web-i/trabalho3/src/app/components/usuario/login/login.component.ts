import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { UsuarioServiceService } from './../../../services/usuarioService/usuario-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private cookie: CookieService, private userService: UsuarioServiceService, router: Router) { this.router = router; }
  router: Router;
  nomeUsuario!: any;
  senhaUsuario!: any;

  formUsuario!: any;
  formSenha!: any;

  sucessoLogin: boolean = false;
  falhaLogin: boolean = false;

  ngOnInit(): void {
    this.createForm();
    this.validateRememberMe();
  }

  createForm() {
    this.formUsuario = new FormGroup({
      usuario: new FormControl(''),
    })
    this.formSenha = new FormGroup({
      senha: new FormControl(''),
    });
  }

  // se tiver dados no cookie, deve trazer nos inputs de texto o usuario e a senha
  validateRememberMe() {
    if (this.cookie.get('usuario') != '' && this.cookie.get('senha') != '') {
      this.setInputsWithData(this.cookie.get('usuario'), this.cookie.get('senha'));
    }
  }

  // seta os inputs de texto com usuario e senha passados como parametro
  setInputsWithData(usuario: any, senha: any) {
    this.nomeUsuario = usuario;
    this.senhaUsuario = senha;
  }

  // se a checkbox estiver checked, deve setar usuario e senha nos cookies
  // se não, deleta tudo que estiver no cookie
  saveUserOnRememberMe() {
    var checkbox = document.getElementById("checkbox") as HTMLInputElement | null;

    if (checkbox?.checked) {
      this.setCookie();
      return true;
    }
    this.cookie.deleteAll();
    return false;
  }

  // seta usuario e senha nos cookies
  setCookie() {
    this.cookie.set('usuario', this.nomeUsuario);
    this.cookie.set('senha', this.senhaUsuario);
  }

  // faz o login
  login() {
    // se o login for valido
    if (this.userService.validateLoginInLocalStorage(this.nomeUsuario, this.senhaUsuario)) {
      // exibe mensagem de sucesso de login
      this.sucessoLogin = true;
      // verifica se deve ou não lembrar o usuario
      this.saveUserOnRememberMe();
      // salva usuario na sessionStorage
      sessionStorage.setItem('usuario', JSON.stringify(this.formUsuario.value));
      sessionStorage.setItem('senha', JSON.stringify(this.formSenha.value));
      // função de tempo para remover mensagem de sucesso de login
      setTimeout(() => {
        this.sucessoLogin = false;
        location.reload();
      }, 2000);
    }

    else {
      // mensagem de falha de login
      this.falhaLogin = true;

      setTimeout(() => {
        this.sucessoLogin = false;
        location.reload();
      }, 3000);
    }
  }
}
