# jpa_hana_performance

Esta PoC busca resolver dois problemas encontrados no projeto.
1. Resolver múltiplas conexões com diferentes databases (SQL Server/SAP Hana).
2. Verificar se há diferença de performance na execução de queries nativas via JPA versus a abertura e encerramento de conexão manualmente. Ambos métodos utilizam o driver da SAP para o Hana.
3. Validar a utilização do Liquibase.

Passo a passo

* Possuir o docker instalado para execução do SQL Server Express Edition 2017: https://hub.docker.com/_/microsoft-mssql-server
* Possuir o SAP Hana Express Edition (Vitual Machine): https://developers.sap.com/group.hxe-install-vm.html
* É preciso possuir ao menos 16GB na máquina para o Hana (8GB na VM).
* Existe um script chamado docker_run_sqlserver.sh no projeto que sobe o container para o Sql Server. Então, criar o banco de dados 'company1'
* Com o SQL Server de pé executar: jpa_hana_performance/liquibase-3.8.0-bim$ sudo ./liquibase --defaultsFile="mssql.liquibase.properties" update
* Com o Hana de pé executar: jpa_hana_performance/liquibase-3.8.0-bim$ sudo ./liquibase --defaultsFile="hana.liquibase.properties" update

Melhorias
* A máquina virtual do SAP Hana ao bootar precisa pegar um novo IP.  Para atualizar o IP ir no menu Virtual Machine -> Removeable Devices -> Network Adapter -> Host-only. Nesse mesmo menu, clicar em "Connect". É possível ver esse IP através do comando /sbin/ifconfig (É preciso estar logado com o usuário hxeadm).
* Existem um plugin do maven para adicionar o Liquibase: https://www.liquibase.org/documentation/maven/index.html
* Melhorar forma de instanciar os Beans sem a necessidade da tag @Primary. 


