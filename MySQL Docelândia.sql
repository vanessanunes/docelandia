/*
* @autor Bruno da Costa Silva
* Projeto: Banco de Dados --> Docelândia
* Base de dados/schema: docelandia
*
*/

CREATE TABLE Categoria (
    id_cat INT NOT NULL,
    nome VARCHAR(30),
    descricao VARCHAR(50)
);

ALTER TABLE Categoria ADD CONSTRAINT PK_Categoria PRIMARY KEY (id_cat);


CREATE TABLE Cliente (
    id_clie INT NOT NULL,
    nome VARCHAR(50),
    email VARCHAR(50),
    cpf NUMERIC(12),
    dt_nasc DATE,
    sexo CHAR(1)
);

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente PRIMARY KEY (id_clie);


CREATE TABLE Funcionario (
    id_func INT NOT NULL,
    nome VARCHAR(50),
    funcao VARCHAR(30),
    cpf NUMERIC(12),
    dt_nasc DATE,
    email VARCHAR(30)
);

ALTER TABLE Funcionario ADD CONSTRAINT PK_Funcionario PRIMARY KEY (id_func);

/*Tabela que precisa ser melhorada!!!!!*/
CREATE TABLE Pedido (
    id_ped INT NOT NULL, /*Chave primaria composta: Tabela Pedido e Cliente*/
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

ALTER TABLE Produto ADD CONSTRAINT PK_Produto PRIMARY KEY (id_prod);
ALTER TABLE Produto add constraint fk_categoria foreign key (id_cat) references Categoria (id_cat);


CREATE TABLE Telefone (
    id_tel INT NOT NULL,
    tipo INT,
    numero NUMERIC(15),
    descricao VARCHAR(50),
    id_fk INT /*Chave estrangeira composta: Tabela Cliente e Funcionario*/
);



ALTER TABLE Telefone ADD CONSTRAINT PK_Telefone PRIMARY KEY (id_tel);
alter table Telefone add constraint fk_comp_clie foreign key (id_fk) references Cliente (id_clie);
alter table Telefone add constraint fk_comp_func foreign key (id_fk) references Funcionario (id_func);


CREATE TABLE Endereco (
    id_end INT NOT NULL,
    tipo INT,
    cep NUMERIC(8),
    lagradouro VARCHAR(50),
    numero INT,
    bairro VARCHAR(30),
    complemento VARCHAR(50),
    cidade VARCHAR(50),
    uf CHAR(2),
    ponto_ref VARCHAR(30),
    id_fk INT /*Chave estrangeira composta: Tabela Cliente e Funcionario*/
);

ALTER TABLE Endereco ADD CONSTRAINT PK_Endereco PRIMARY KEY (id_end);
alter table Endereco add constraint fk_end_clie foreign key (id_fk) references Cliente (id_clie);
alter table Endereco add constraint fk_end_func foreign key (id_fk) references Funcionario (id_func);


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
	
	/*18/05*/
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
    tipo boolean, /*Flag - Verifica se o usuario é Floginuncionario ou Cliente(1 ou 0)*/
    id_fk int /*Chave estrangeira composta - Tabelas Cliente e Funcionario*/
);

alter table login add constraint pk_login primary key (id_log);
alter table login add constraint fk_clie foreign key (id_fk) references cliente (id_clie);
alter table login add constraint fk_func foreign key (id_fk) references funcionario (id_func);




ALTER TABLE login MODIFY COLUMN id_log INT auto_increment