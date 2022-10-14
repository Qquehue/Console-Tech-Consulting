create database deep_abyss;

use deep_abyss;

create table Usuario(
idUsuario int primary key auto_increment,
nome varchar(45),
email varchar(45),
telefone char (11),
cpf char (11),
senha varchar(15)
);

create table pontuacao(
idPontuacao int auto_increment,
fkUsuario int unique,
foreign key (fkUsuario) references Usuario(idUsuario),
primary key (idPontuacao, fkUsuario),
acertos int,
erros int,
dt date
);