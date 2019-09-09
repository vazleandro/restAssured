# language: pt
@PATCH
Funcionalidade: Usuario deseja alterar o campo e-mail do contato existente

  Cenário: Realizar a atualização do campo e-mail do contato
    Dado que eu tenha o id 881 do contato para alterar o e-mail
    Quando eu realizar a atualização do e-mail do contato via api
    Entao terei o e-mail do contato atualizado
