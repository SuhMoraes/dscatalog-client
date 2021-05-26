<h1 align="center"> Trabalho final do capítulo 1 - DSCatalog </h1>

<h2>Enunciado do trabalho</h2>
<p>
  Entregar um projeto Spring Boot 2.4.x contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:
<p>
  
  <ul>
    <li>Busca paginada de recursos</li>
    <li>Busca de recurso por id</li>
    <li>Inserir novo recurso</li>
    <li>Atualizar recurso</li>
    <li>Deletar recurso</li>    
</ul>

<p>
  O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar Maven como gerenciador de dependência, e Java 11 como linguagem.
</p>

<p>
    Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da entidade Client é mostrada a seguir (você deve seguir à risca os nomes de classe e atributos mostrados no diagrama):
</p>

<p> 
  O projeto deverá fazer um seed de pelo menos 10 clientes com dados SIGNIFICATIVOS (não é para usar dados sem significado como “Nome 1”, “Nome 2”, etc.).
</p>

<h2> Importação do projeto</h2>


### 📝 _Clone do projeto_:

```

https://github.com/SuhMoraes/dscatalog-client

```

<h2> <img src="https://ik.imagekit.io/fp3xx2hhnq/image-removebg-preview_gLKSu7w-f.png" width="50px">Testes manuais no Postman</h2>

<p>Busca paginada de clientes</p>

```

GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name


```


Busca de cliente por id

```

GET /clients/1

```

Inserção de novo cliente

```
POST /clients
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}

```
Atualização de cliente

```
PUT /clients/1
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}

```

Deleção de cliente

```

DELETE /clients/1

```

