from ambiente import Ambiente
from agenteSimples import AgenteSimples

def main():
    ambiente = Ambiente()
    agente_aspirador = AgenteSimples(ambiente)

    ambiente.exibir(agente_aspirador.x, agente_aspirador.y)

    while ambiente.verificar_sujeira():
        acao = agente_aspirador.acao()
        agente_aspirador.executar_acao(acao)

if __name__ == "__main__":
    main()