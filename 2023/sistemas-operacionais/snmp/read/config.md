# Configuração da maquina
> [!IMPORTANT]
> ### A máquina que será o servidor deverá ter instalado o java 21 na maquina!
>  onde poderá ser baixado clicando aqui -> [Baixar java JDK V.21](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows)

> Para configurar 


### Habilitar SNMP no Windows
OBS: Esta etapa é necessária tanto nas máquinas clientes quanto na máquina servidor
* Acessar as configurações do windows em "Gerenciar recursos opcionais"
  
![print1](https://github.com/mariaedk/snmp-sistemas-operacionais/assets/62608046/56614ba2-9b16-4238-9e33-f04063c2b661)

* Selecionar "Adicionar Recurso"
  
![print2](https://github.com/mariaedk/snmp-sistemas-operacionais/assets/62608046/98afc5cf-68a9-443b-92fd-1996a4804370)
  
* Digitar "Protocolo SNMP" e selecionar a opção. Clicar em Instalar
  
* É necessário reiniciar o computador após a instalação do recurso
* Após reiniciar, acessar "Serviços" do Windows e verificar se o "Protocolo SNMP" está adicionado
* Clicar com o botão direito do mouse sob "Protocolo SNMP" e acessar propriedades

![imagem](https://github.com/mariaedk/snmp-sistemas-operacionais/assets/62608046/cfc2b5ac-f99f-4757-be00-5be164bf3b25)

* Na aba "Segurança", marcar a opção "Aceitar pacotes de qualquer host"

![imagem (2)](https://github.com/mariaedk/snmp-sistemas-operacionais/assets/62608046/a3ea471e-d908-4b5d-aad6-07ef5b5afc5e)


* Nesta mesma tela, clicar em "Adicionar" e configurar conforme imagem abaixo

![imagem (4)](https://github.com/mariaedk/snmp-sistemas-operacionais/assets/62608046/49b97306-c6ca-47e0-b89c-708142e23305)

* Em seguida, ir na aba "Agente" e configurar conforme imagem abaixo:

![imagem (5)](https://github.com/mariaedk/snmp-sistemas-operacionais/assets/62608046/07cb39e5-34c7-4da4-a686-2cafa5e39188)

> [!NOTE]
>Clicar em "Aplicar" e "Ok" em todas as alterações!
