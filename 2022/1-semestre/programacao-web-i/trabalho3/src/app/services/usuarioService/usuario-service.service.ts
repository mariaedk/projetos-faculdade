import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

// classe de serviço
// esta classe separadamente trata questões especificas do usuario, como validação do login e verificar se o login existe no sessionstorage.
// é possível injetar e usar este serviço em qualquer classe
export class UsuarioServiceService {

  constructor() { }

  validateLoginInLocalStorage(nomeUsuario: any, senhaUsuario: any)
  {
    var usuarioLocal = localStorage.getItem("usuario");
    var usuarioString = JSON.parse(usuarioLocal!);

    var senhaLocal = localStorage.getItem("senha");
    var senhaString = JSON.parse(senhaLocal!);

    if (usuarioString.usuario == nomeUsuario && senhaUsuario == senhaString.senha)
    {
      return true;
    }

    return false;
  }


  verifyIfLoggedInSessionStorage()
  {
    var usuarioSession = sessionStorage.getItem("usuario");
    var usuarioString = JSON.parse(usuarioSession!);

    var senhaSession = sessionStorage.getItem("senha");
    var senhaString = JSON.parse(senhaSession!);

    if (usuarioString != null && senhaString != null)
    {
      return true;
    }
    return false;
  }

}
