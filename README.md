# Sistema de Biblioteca

### Descrição

Este projeto é um Sistema de Biblioteca desenvolvido em Java, que permite gerenciar livros, autores, membros, e empréstimos de livros. O sistema possibilita o cadastro de livros e autores, a realização de empréstimos, devoluções, além de listar os livros e empréstimos cadastrados.

### Funcionalidades

#### Cadastro de Livros: Adicionar novos livros ao sistema.
#### Cadastro de Autores: Adicionar informações de autores para os livros cadastrados.
#### Cadastro de Membros: Registrar membros da biblioteca que poderão realizar empréstimos.
#### Empréstimo de Livros: Realizar o empréstimo de livros para membros cadastrados.
#### Devolução de Livros: Registrar a devolução de livros emprestados e calcular multas, se houver atraso.
#### Listagem de Livros: Exibir todos os livros cadastrados no sistema.
#### Listagem de Empréstimos: Exibir todos os empréstimos registrados.

### Estrutura do Projeto
O projeto está organizado nos seguintes pacotes:
#### Aplicação: Contém a classe principal Biblioteca, que serve como ponto de entrada para o sistema.
#### DAO: Camada de acesso a dados, onde são gerenciadas as interações com o banco de dados para livros, autores, membros e empréstimos.
#### Entidades: Representa as classes de domínio do sistema, como Livro, Emprestimo, Membro, Autor, entre outros.
#### Menu: Contém as classes de menu que lidam com a interface interativa do usuário. Cada menu controla o fluxo de entrada de dados e chama os serviços necessários.
#### Serviços: Contém a lógica de negócios para manipular livros, autores, membros e empréstimos.
#### resource: Contém a classe Create_Tables, que cria as tabelas do banco de dados na inicialização do sistema.
