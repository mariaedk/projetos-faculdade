import { UsuarioServiceService } from './../usuarioService/usuario-service.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioNaoAutenticadoGuard implements CanActivate {
  constructor(
    private usuarioService: UsuarioServiceService,
    private router: Router) { }

  canActivate()
  {
    if (this.usuarioService.verifyIfLoggedInSessionStorage())
    {
      return true;
    }
    this.router.navigate(['login'])
    return false;
  }



}
