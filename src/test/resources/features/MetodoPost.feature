# language: pt
@POST
Funcionalidade: Usuario deseja incluir um novo contato

  Cenário: Realizar a inclusão de um novo contato
    Dado que eu tenha os dados do contato
    Quando eu realizar a inclusao do contato via api
    Entao terei os dados cadastrados com sucesso
