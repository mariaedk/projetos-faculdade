import { SuporteComponent } from './components/suporte/suporte.component';
import { CadastroAlunoComponent } from './components/aluno/cadastro-aluno/cadastro-aluno.component';
import { LoginComponent } from './components/usuario/login/login.component';
import { CadastroComponent } from './components/usuario/cadastro/cadastro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

    { path: '', redirectTo: '/cadastro', pathMatch: 'full' },

    { path: 'cadastro', component: CadastroComponent },

    { path: 'login', component: LoginComponent },

    { path: 'cadastro-aluno', component: CadastroAlunoComponent },

    { path: 'suporte', component: SuporteComponent },

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
