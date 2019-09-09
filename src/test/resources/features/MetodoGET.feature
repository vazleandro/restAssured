# language: pt
@GET
Funcionalidade: Usuário deseja consultar 1 contato específico de sua lista.

  Cenario: Realizar consulta 1 contato da lista
    Dado que eu possua minha lista de contados
    Quando eu realizar uma consulta pelo id 973
    Entao terei os dados pessoais do meu contato
