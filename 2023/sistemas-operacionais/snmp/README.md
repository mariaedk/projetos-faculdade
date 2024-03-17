# Monitoramento SNMP

> [!NOTE]
> ## Objetivo
> Por meio de uma máquina servidor, o objetivo é monitorar uma ou mais máquinas clientes por meio do protocolo SNMP. Com ele, é possível obter dados da máquina, como a quantidade de memória RAM disponível,
> a quantidade de usuários do sistema, o tempo de atividade, dados dos processos em execução, entre outros.

> [!IMPORTANT]
> ## Requisitos
> - [x] Ter JDK 21 instalada e configurada
> - [x] Ter node.js e npm instalados
> - [x] Ter [Angular CLI 16.2](https://angular.io/cli) instalado
>    
> ## Configurações
> **Antes de tudo, deve-se configurar e ativar o protocolo SMNP nas máquinas clientes e servidor -> [Configurações](https://github.com/mariaedk/snmp-sistemas-operacionais/blob/main/read/config.md)**

> [!warning]
> Logo depois de configurar as máquinas, é necessário clonar o repositório em uma pasta do seu computador!

--

## Iniciando o servidor backend:

> [!TIP]
> ### Back-end
> * Tecnologias utilizadas: Java, framework Springboot, banco de dados em memória H2
> * Para rodar o projeto é bem simples, após clonar o repositório, abra pasta `snmpProject > target` ***via cmd***
> * Logo depois usar o comando `java -jar snmpProject-0.0.1-SNAPSHOT.jar` para rodar o servidor
> * Servidor estará pronto para uso! :+1:

> [!TIP]
> ### Front-end
> * Tecnologia utilizada: Angular versão 16.2
> * Abrir pasta `snmp-frontend` ***via cmd*** e rodar o comando `npm install` para baixar as dependências do projeto
> * Rodar o comando `ng s` para subir o servidor
> * Servidor web está disponivel na no em __localhost:4200__ 

--

## Utilizando o software

> - [X] Backend startado!
> - [X] Frontend startado!

1. Utilizar um navegador e acessar o endereço "localhost:4200" :tada:
2. Acesse no menu "Cadastrar máquina cliente"
3. Insira o IP de uma máquina cliente
   - Respeitando a formatação de IPs (Exemplo de entrada: 192.168.2.21)
   - Ao clicar em "Salvar", será enviado uma requisição "ping" a este IP para verificar se está ativo na rede
   - Se esta máquina receber pacotes, será possível cadastrar no sistema.
4. Clicar no menu Home e verificar a máquina cadastrada.
  - Se estiver ativa
    - Será possível clicar no registro da tabela e assim acessar seus detalhes.
  - Se estiver inativa
    - Não é possível visualizar detalhes e ficará em vermelho avisando que está inativa.


