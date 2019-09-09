# language: pt
@DELETE
Funcionalidade: Usuario deseja excluir um contato existente
  
  Cenário: Realizar a exclusao de contato existente
    Dado que eu tenha o id 909 do contato a ser excluido
    Quando eu realizar a exclusao do contato via api
    Entao terei minha lista de contatos atualizadas

  Cenário: Realizar a exclusao de contato inexistente
    Dado que eu tenha o id 123456 do contato a ser excluido
    Quando eu realizar a exclusao do contato via api
    Entao terei uma mensagem informando que nao encontrou o contato
