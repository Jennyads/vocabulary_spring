drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(150) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_anotacao (
  ant_id bigint unsigned not null auto_increment,
  ant_texto varchar(256) not null,
  ant_data_hora datetime not null,
  ant_usr_id bigint unsigned not null,
  primary key (ant_id),
  foreign key ant_usr_fk (ant_usr_id) references usr_usuario(usr_id)
);

create table ent_entrega (
  ent_id bigint primary key auto_increment,
  ent_descricao varchar(100) not null,
  ent_data_hora_cadastro datetime not null,
  ent_data_hora_limite datetime not null,
  ent_peso int not null,
  ent_observacoes varchar(200)
);

create table voc_vocabulo (
 voc_id bigint primary key auto_increment,
 voc_termo varchar(100) not null,
 voc_significado varchar(200) not null,
 voc_versao int not null default 0,
 voc_data_hora_cadastro datetime not null,
 voc_data_hora_desativacao datetime
);

create table emp_empregado (
  emp_id bigint primary key auto_increment,
  emp_nome_completo varchar(100) not null,
  emp_ctps bigint unique not null,
  emp_data_hora_cadastro datetime not null,
  emp_email varchar(30) unique not null,
  emp_carga_horaria float
);

create table tmp_temperatura (
  tmp_id bigint primary key auto_increment,
  tmp_data_hora datetime not null,
  tmp_medida float not null,
  tmp_umidade float,
  tmp_vento float,
  tmp_particulas float
);

insert into usr_usuario (usr_nome, usr_senha)
  values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
  values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao (usr_id, aut_id) 
  values (1, 1);
insert into ant_anotacao(ant_texto, ant_data_hora, ant_usr_id)
  values ('Meu novo projeto', '2023-08-01 19:10', 1);
insert into ent_entrega (ent_descricao, ent_data_hora_cadastro, ent_data_hora_limite, ent_peso)
  values ('Teste 1', current_timestamp(), '2023-10-5 23:59:59', 3),
         ('Teste 2', current_timestamp(), '2023-10-12 23:59:59', 3);
insert into voc_vocabulo (voc_termo, voc_significado, voc_versao, voc_data_hora_cadastro)
  values ('tupla', 'linha de uma tabela', 1, '2023-10-01 10:00:06'),
  ('tupla', 'conjunto de atributos relacionados', 2, current_timestamp());
insert into emp_empregado (emp_nome_completo, emp_ctps, emp_data_hora_cadastro, emp_email)
  values ('Charles Smith', 12345678910, current_timestamp(), 'chsmith@email.com'),
         ('Ann Doe', 23456743212, current_timestamp(), 'anndoe@email.com');
insert into tmp_temperatura (tmp_data_hora, tmp_medida, tmp_umidade, tmp_particulas)
  values ('2023-10-24 10:00', 25.4, null, 31.3),
         ('2023-10-24 11:00', 26.1, 43.2, null);