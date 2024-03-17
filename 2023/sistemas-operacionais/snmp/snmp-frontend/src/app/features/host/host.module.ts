import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CadastrarClienteComponent } from './cadastrar-cliente/cadastrar-cliente.component';
import { HostRoutingModule } from './host-routing.module';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';
import { DetalhesHostComponent } from './detalhes-host/detalhes-host.component';


@NgModule({
  declarations: [
    CadastrarClienteComponent,
    ListarClientesComponent,
    DetalhesHostComponent
  ],
  imports: [
    CommonModule,
    HostRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class HostModule { }
