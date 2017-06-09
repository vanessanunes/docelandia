
/*
* @autor Bruno da Costa Silva
* Projeto: Banco de Dados --> Docelândia
* Base de dados/schema: docelandia
*
-------- Alterações dia 02/06
* 
* Alteração dos campos: Cep e Cpf para o tipo "varchar"
* Remoção das chaves estrangeiras em: Endereço e Telefone
* Adição do campo sexo em: Funcionario
* Adição do campo descrição em: Pedidos
*/

CREATE TABLE Categoria (
    id_cat INT NOT NULL,
    nome VARCHAR(30),
    descricao VARCHAR(50)
);

ALTER TABLE Categoria ADD CONSTRAINT PK_Categoria PRIMARY KEY (id_cat);


CREATE TABLE Cliente (
    id_clie INT,
    nome VARCHAR(50),
    email VARCHAR(50),
    cpf varchar(15),
    dt_nasc DATE,
    sexo CHAR(1)
);

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente PRIMARY KEY (id_clie);


CREATE TABLE Funcionario (
    id_func INT NOT NULL,
    nome VARCHAR(50),
    funcao VARCHAR(30),
    cpf varchar(15),
    dt_nasc DATE,
    email VARCHAR(30),
    sexo char(1)
);

ALTER TABLE Funcionario ADD CONSTRAINT PK_Funcionario PRIMARY KEY (id_func);

CREATE TABLE Pedido (
    id_ped INT NOT NULL, /*Chave primaria composta: Tabela Pedido e Cliente*/
    dt_pedido date,
    descricao varchar(100),
    id_clie INT
);

ALTER TABLE Pedido ADD CONSTRAINT PK_Pedido PRIMARY KEY (id_ped, id_clie);
alter table Pedido add constraint fk_Cliente foreign key (id_clie) references Cliente (id_clie);


CREATE TABLE Produto (
    id_prod INT NOT NULL,
    id_cat INT NOT NULL,
    nome VARCHAR(30),
    descricao VARCHAR(100),
    preco DOUBLE PRECISION,
    quantidade NUMERIC(5)
);

ALTER TABLE Produto ADD CONSTRAINT PK_Produto PRIMARY KEY (id_prod, id_cat);
ALTER TABLE Produto add constraint fk_categoria foreign key (id_cat) references Categoria (id_cat);


CREATE TABLE Telefone (
    id_tel INT NOT NULL,
    numero varchar(15),
    descricao VARCHAR(50),
    tipo int,
    tipo_user int, /*Identifica se o campo é: Cliente ou Funcionário*/
    id_user int /*Coluna que vai receber o ID do Cliente ou Funcionario*/
);

ALTER TABLE Telefone ADD CONSTRAINT PK_Telefone PRIMARY KEY (id_tel);


CREATE TABLE Endereco (
    id_end INT NOT NULL,
    tipo varchar(10), /*Tipo de telefone(1=Casa, 2=Parente, 3=Vizinho...)*/
    cep varchar(10),
    lagradouro VARCHAR(100),
    numero varchar(15),
    bairro VARCHAR(100),
    complemento VARCHAR(50),
    cidade VARCHAR(50),
    uf CHAR(2),
    ponto_ref VARCHAR(100),
    tipo_user int, /*Identifica se o campo é: Cliente ou Funcionário*/
    id_user int /*Coluna que vai receber o ID do Cliente ou Funcionario*/
);

ALTER TABLE Endereco ADD CONSTRAINT PK_Endereco PRIMARY KEY (id_end);


CREATE TABLE Itens (
    id_ped INT NOT NULL, /*Chave primaria composta: Tabela Produto e Pedido*/
    id_prod INT,
    num_tens NUMERIC(5) /*numero de itens no carrinho*/
);

ALTER TABLE Itens ADD CONSTRAINT PK_comp_Itens PRIMARY KEY (id_ped, id_prod);
alter table Itens add constraint fk_produto foreign key (id_prod) references Produto (id_prod);
alter table Itens add constraint fk_pedidos foreign key (id_ped) references Pedido (id_ped);

CREATE TABLE Pagamento (
    id_pag INT, /*Chave primaria composta: Tabela Pagamento e Pedido*/
    id_ped INT,
    tipo VARCHAR(20), /*Tipo de pagamento escolhido (Cartão, Boleto, Dinheiro)*/
    dt_pag DATE,
    pago boolean, /*Flag*/
    n_par int /*Numero de parcelas*/
);

alter table Pagamento add constraint pk_pagamento primary key (id_pag, id_ped);
alter table Pagamento add constraint fk_pedido foreign key (id_ped) references Pedido (id_ped);

/*26/05*/
create table login (
    id_log int,
    nome_user varchar(30),
    senha varchar(70),
    tipo_user int, /*Identifica se o campo é: Cliente ou Funcionário*/
    id_user int /*Coluna que vai receber o ID do Cliente ou Funcionario*/
);

alter table login add constraint pk_login primary key (id_log);

07/06/2017

INSERT INTO `categoria`(`id_cat`, `nome`, `descricao`) VALUES (1, 'Bolo', 'Bolos para morrer de amores')
INSERT INTO `categoria`(`id_cat`, `nome`, `descricao`) VALUES (2, 'Docinho', 'Docinhos de carinho')

alter table produto add imagem varchar(100);

INSERT INTO `produto`(`id_prod`, `id_cat`, `nome`, `descricao`, `preco`, `quantidade`, `imagem`) VALUES (1, 1, 'Bolo Kit Kat', 'Bolo de chocolate, recheado com brigadeiro, coberto de brigadeiro, M&Ms e Kit Kat', 150.00, 500, 'image/doces/bolo_kitkat.png')

INSERT INTO `produto`(`id_prod`, `id_cat`, `nome`, `descricao`, `preco`, `quantidade`, `imagem`) VALUES (2, 2, 'Brigadeiro Gourmet', 'Brigadeiros sortidos de: brigadeiro tradicional, leite ninho e Nutella', 30, 10, 'image/doces/brigadeiro_gourmet.gif')