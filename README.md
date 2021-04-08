----------------------------------------------------------------------------------------------------------------------------------------
## TRABALHO DE BANCO DE DADOS 2021/1

Vitor Bernstorff Clemes

Nicolas Keiji Cattani Sakashita

Universidade Estadual de Santa Catarina

## Ambiente e especificações

Implementado e testado nos sistemas Windows e Linux Ubuntu;

Projeto gerado através do Java Extension Pack - Microsoft disponível como extensão no Visual Studio Code

Conectado ao banco de dados de url localhost.

Banco escolhido : evento_backup implementado em Postgres

Rodado direto no terminal ( sem GUI )

Link para repositório no GitHub : https://github.com/vitorbclemes/ProjetoFinal-BAN

## Informações para Professora

API utilizada : Java.sql

Foram implementadas as classes de dados Artigo,Edicao e Tipo ( apenas as necessárias para suprir as condiçoes impostas). Na camada de persistência foi implementado o modelo DAO, entre eles ArtigoDAO,EdicaoDAO e TipoDAO, além do arquivo Conexão. Uma simples camada de exeções foi adicionada para tratar possiveis excecoes lançadas pelo banco. Na camada de sistema foi implementado o design pattern Front Controller. Por fim, a camada de apresentação é responsável pela interação da camada de sistema com o usuário.

----------------------------------------------------------------------------------------------------------------------------------------
