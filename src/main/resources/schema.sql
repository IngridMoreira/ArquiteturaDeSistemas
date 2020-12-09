CREATE TABLE IF NOT EXISTS cliente(
    id int AUTO_INCREMENT primary key,
    nome varchar(30) not null,
    endereco varchar(100) not null,
    cpf varchar(11) not null,
    telefone varchar(15),
    nascimento date not null
);

CREATE TABLE IF NOT EXISTS produto(
    id int AUTO_INCREMENT primary key,
    nome varchar(30) not null,
    descricao varchar(100) not null,
    quantidade int not null,
    valor decimal not null
);

CREATE TABLE IF NOT EXISTS pedido(
    id int AUTO_INCREMENT primary key not null,
    data_compra date,
    data_devolucao date,
    cliente_id int ,
    produto_id int ,
    quantidade int,
    valor decimal,

    foreign key (cliente_id) references cliente(id),
    foreign key (produto_id) references produto(id)
);

CREATE TABLE IF NOT EXISTS disponibilidade(
    id int AUTO_INCREMENT primary key not null,
    data_devolucao date not null,
    nome varchar(30) not null,
    quantidade int not null

);

insert into cliente(NOME ,ENDERECO ,CPF,TELEFONE ,NASCIMENTO ) values('lucas','fortaleza','123456','654321','2020-12-07');
insert into cliente(NOME ,ENDERECO ,CPF,TELEFONE ,NASCIMENTO ) values('thiago','fortaleza','101112','6578430','2000-02-08');

insert into produto(NOME ,DESCRICAO ,QUANTIDADE ,VALOR  ) values('cadeira','tem 4 pernas',20,70);
insert into produto(NOME ,DESCRICAO ,QUANTIDADE ,VALOR  ) values('mesa','mesa para festa',35,250);
insert into produto(NOME ,DESCRICAO ,QUANTIDADE ,VALOR  ) values('chapeu de natal','descricao',12,1);

insert into pedido (cliente_id,produto_id,data_compra,data_devolucao,quantidade,valor) values(1,1,'2020-12-07','2020-12-30',5,350);

insert into disponibilidade (data_devolucao,nome,quantidade) values('2020-12-30','cadeira',10);
