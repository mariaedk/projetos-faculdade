import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';
import { CadastrarClienteComponent } from './cadastrar-cliente/cadastrar-cliente.component';
import { DetalhesHostComponent } from './detalhes-host/detalhes-host.component';

const routes: Routes = [
  { path: '', component: ListarClientesComponent },
  { path: 'cadastrar', component: CadastrarClienteComponent },
  { path: 'host/:id', component: DetalhesHostComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HostRoutingModule { }
