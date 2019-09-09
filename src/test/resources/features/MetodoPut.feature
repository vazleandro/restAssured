# language: pt
@PUT
Funcionalidade: Usuário deseja alterar todos os  campos do contato

  Cenário: Usuário deseja alterar todos os dados do contato
    Dado que eu tenha o id 881 e os dados do contato a ser alterado
      """
       {
             "name": "Clara",
             "last-name": "carlos",
             "email": "testeVAZ@gmail.com",
             "age": 40,
             "phone": "199985852",
             "address": "Kub Street",
             "state": "Florida",
             "city": "Missourishire"
         }
         
      """
    Quando eu realizar a alteracao do contato via api
    Entao terei todos os dados do contato atualizado