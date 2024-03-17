import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DetalhesHostDTO } from 'src/app/comum/dto/DetalhesHostDTO';
import { MOCK_DETALHES_HOST_DTO } from 'src/app/comum/mock/DetalhesHostDTOMock';
import { HostService } from 'src/app/comum/servicos/host.service';

@Component({
  selector: 'app-detalhes-host',
  templateUrl: './detalhes-host.component.html',
  styleUrls: ['./detalhes-host.component.scss']
})
export class DetalhesHostComponent implements OnInit {

  ip: string = '';
  host!: DetalhesHostDTO;

  constructor(public route: ActivatedRoute, private hostService: HostService) {}

  ngOnInit(): void {
    this.ip = this.route.snapshot.params["id"];
    this.hostService.getDetalhesHost(this.ip).subscribe(host => {
      this.host = host;
    });
    setInterval(() => {
      this.hostService.getDetalhesHost(this.ip).subscribe(host => {
        this.host = host;
      });
    }, 30000)
  }

}
