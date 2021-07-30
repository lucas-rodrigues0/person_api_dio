# Projeto: Person_Api - Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot
### para o bootcamp da Digital Innovation One

<br />

__Objetivo:__<br />
Criar uma API REST em Java, com o SpringBoot Framework.<br />
   <br /><br />
Através do end-point '/api/v1/person' e pelos verbos REST, foi implementado o CRUD (Create, Read, Update e Delete) 
para o gerenciamento dos dados de pessoas.
<br /><br />
&nbsp;&nbsp;Para a entidade Person temos os seguintes atributos:
 - Id - IDENTITY (GeneratedValue);
 - firstName - STRING;
 - lastName - STRING;
 - cpf - STRING;
 - birthDate - STRING (Format: dd-MM-yyyy);
 - phones - List [ type - STRING, number - STRING ];
 - emails- List [ emailAddress - STRING ];

&nbsp;&nbsp;As funcionalidades são:
 - GET /api/v1/person - lista todas as 'Person';
 - GET /api/v1/person/:id - lista a 'Person' pelo id;
 - POST /api/v1/person - Cria uma 'Person';
 - PUT /api/v1/person/:id - Atualiza a 'Person' pelo id;
 - DELETE /api/v1/person/:id - Deleta a 'Person' pelo id;
   <br /><br />

&nbsp;&nbsp;Para as entidades Phone e Email temos os atributos descritos em Person. Phone(type, number), Email(emailAddress), além de seus respectivos ids.<br />
   <br />

&nbsp;&nbsp;As funcionalidades para 'Phone' e 'Email' seguem o mesmo padrão, alternando a entidade que irá atuar. Essas são:
- GET /api/v1/\<phone or email\> - lista todas as ocorrências de 'Phone' ou 'Email';
- GET /api/v1/\<phone or email\>/:id - lista a ocorrência pelo id;
- POST /api/v1/\<phone or email\>/person/:personId - Cria uma ocorrência para a 'Person' identificada no :personId;
- PUT /api/v1/\<phone or email\>/:id/person/:personId - Atualiza a ocorrência pelo seu id para a 'Person' identificada no :personId;
- DELETE /api/v1/\<phone or email\>/:id/person/:personId  - Deleta a ocorrência pelo seu id para a 'Person' identificada no :personId;
  <br /><br />
  <br /><br />
__Processo:__<br />
Toda configuração inicial do projeto foi gerada com o SpringBoot Initializer.<br />
Utiliza o gerenciador de build e dependências Maven.<br />
IDE utilizada, IntelliJ.<br />
<br />
<br />
  
__Deploy:__<br />
Realizado o deploy desta API no Heroku.
O Entry-point para utilizar pelo Heroku: https://personapi-gftstart-project.herokuapp.com/api/v1/person
<br />
além dos end-points descritos acima.<br /><br />
__Contatos:__<br />
<br />
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/lucas-rodrigues-de-castro/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/lucas-rodrigues0)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:lucas.movimento@gmail.com)
