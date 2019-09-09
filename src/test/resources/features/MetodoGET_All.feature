# language: pt
@GET
Funcionalidade: Usuario deseja realizar consultas aos seus contatos

  Cenario: Realizar consulta de todos os contatos
    Dado que eu possua minha lista de contados
    Quando eu realizar uma consulta
    Entao terei todos os dados de meus contatos
