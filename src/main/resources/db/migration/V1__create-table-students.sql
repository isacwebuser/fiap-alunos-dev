create table students (
   id bigint not null auto_increment,
   nome varchar(100) not null,
   matricula varchar(20) not null unique,
   telefone varchar(20) not null,
   cpf varchar(20) not null,
   curso varchar(100) not null,

   primary key(id)
);