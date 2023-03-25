<h1>Refatorando o  Projeto Spring Data JPA na Prática </h1>
<h2><p> Esse projeto é uma refatoração do projeto Spring Data JPA na Prática do bootcamp DIO Banco Pan </strong></a>.<br></h2>


<h2>
🛑 Alterações implementadas
</h2>

- [x] Criação de perfil de teste <i>application-test.properties</i> com configuração do banco em mémoria H2
- [x] Alterações das entidades de acordo com o diagrama de classe abaixo
- [x] Todas os atributos tipo data foram alterados para Instant
- [x] Os seguintes endpoints foram criados (Postman requestes exportados e salvos no repositorio)
  - /avaliacoes
    - POST/GET/DELETE/PUT
    - Possivel buscar avaliacoes por data da avaliaco (between) e por objetivo do aluno bem como por Id
  - /alunos
    - POST/GET/DELETE/PUT 
    - Possivel buscar alunos por bairro e data de nascimento (between), bem como por Id
  - /matriculas
    - POST/GET/PUT (matricula é deletada quando aluno é deletado one2one)
    - Possível buscar matriculas pelo seu status e pela forma de pagamento, pela data de matricula (between) e pelo Id
  - /enderecos
    - POST/GET/PUT (endereco é deletado quando aluno é deletado one2one)
  - /telefones 
    - deletado quando aluno é deletado many2one
- [x] Uso da lib ModelMapper para fazer o mapeamento dos DTOSs
- [x] Implementado tratamento de exceções de forma a lançar uma mensagem mais <i>user friendly</i> para o usuário.

![main window](https://github.com/rgiovann/image-repo/blob/main/diagrama_de_classes_academia.jpg)
