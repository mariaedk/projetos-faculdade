import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss'],
})
export class CadastroComponent implements OnInit {
  constructor(private cookie: CookieService) { }

  formNome!: any;
  formEmail!: any;
  formUsuario!: any;
  formSenha!: any;
  sucessoCadastro: boolean = false;

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.formNome = new FormGroup({
      nome: new FormControl('', Validators.compose([Validators.required, Validators.pattern(/^[\D]{2,50}$/)]))
    });
    this.formEmail = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
    });
    this.formUsuario = new FormGroup({
      usuario: new FormControl('', [
        Validators.required,
        Validators.minLength(5),
      ]),
    });
    this.formSenha = new FormGroup({
      senha: new FormControl('', [
        Validators.required,
        Validators.minLength(8),
      ]),
    });
  }

  saveInLocalStorage()
  {
    if (this.validate())
    {
      localStorage.setItem('nome', JSON.stringify(this.formNome.value));
      localStorage.setItem('email', JSON.stringify(this.formEmail.value));
      localStorage.setItem('usuario', JSON.stringify(this.formUsuario.value));
      localStorage.setItem('senha', JSON.stringify(this.formSenha.value));

      return true;
    }
    return false;
  }

  validateName(): boolean {
    return (this.formNome.get('nome')?.errors?.['required'] || this.formNome.get('nome')?.errors?.['pattern']) ? false : true;
  }

  validateEmail(): boolean {
    return (this.formEmail.get('email')?.errors?.['required'] ||
      this.formEmail.get('email')?.errors?.['email']) ? false : true;
  }

  validateUser(): boolean {
    return (this.formUsuario.get('usuario')?.errors?.['required'] ||
      this.formUsuario.get('usuario')?.errors?.['minlength']) ? false : true;
  }

  validatePassword(): boolean {
    return (this.formSenha.get('senha')?.errors?.['required'] ||
      this.formSenha.get('senha')?.errors?.['minlength']) ? false : true;
  }
  validate(): boolean {
    return (this.validateName() && this.validateEmail() && this.validateUser() && this.validatePassword());
  }

  cadastrar()
  {
    if (this.saveInLocalStorage())
    {
      this.sucessoCadastro = true;
      setTimeout(()=>
      {
        this.sucessoCadastro = false;
        this.createForm();
      },3000);
    }
    sessionStorage.removeItem('usuario');
    sessionStorage.removeItem('senha');
  }
}
