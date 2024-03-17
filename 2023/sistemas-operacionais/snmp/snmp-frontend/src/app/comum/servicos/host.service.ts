import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DetalhesHostDTO } from '../dto/DetalhesHostDTO';
import { HostDTO } from '../dto/HostDTO';

@Injectable({
  providedIn: 'root'
})
export class HostService {

  private tagHostController = "http://localhost:8080/hosts"

  constructor(private httpClient: HttpClient) { }

  public getDetalhesHost(ip: string) {
    return this.httpClient.get<DetalhesHostDTO>(`${this.tagHostController}/detalhe/${ip}`);
  }

  public getListaHosts() {
    return this.httpClient.get<HostDTO[]>(`${this.tagHostController}`);
  }

  public saveIpCliente(ip: string) {
    return this.httpClient.post<HostDTO>(`${this.tagHostController}/cadastro`, ip);
  }
}
