import { Component } from '@angular/core';
import { HostDTO } from 'src/app/comum/dto/HostDTO';
import { HostService } from 'src/app/comum/servicos/host.service';

@Component({
  selector: 'app-cadastrar-cliente',
  templateUrl: './cadastrar-cliente.component.html',
  styleUrls: ['./cadastrar-cliente.component.scss']
})
export class CadastrarClienteComponent {

  ip: string = '';
  host!: HostDTO;
  showOkToast = false;
  showErrorToast = false;

  constructor(private hostService: HostService) {}

  save() {
    this.hostService.saveIpCliente(this.ip).subscribe(host => {
      this.host = host;
      if (host.cdHost != null) {
        this.showOkToast = true;
        setTimeout(() => {
          this.showOkToast = false;
        }, 5000);
      } else {
        this.showErrorToast = true;
        setTimeout(() => {
          this.showErrorToast = false;
        }, 5000);
      }
    });
  }
}
