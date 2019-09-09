create table endereco(
id_endereco int not null auto_increment,
rua varchar (50) not null,
numero varchar (50) not null,
complemento varchar(100) not null,
primary key (id_endereco)
)engine = InnoDB;

create table Conta(
id_conta int not null auto_increment,
numero int not null,
saldo double not null,
limite double not null,

primary key (id_conta)
)engine = InnoDB;

create table pessoa(
id_pessoa int not null auto_increment,
nome varchar(50) not null,
sexo varchar(1) not null,
cpf varchar(14) not null,
endereco_id int,
conta_id int,

primary key(id_pessoa),
constraint id_end
foreign key fk_endereco(endereco_id) references endereco(id_endereco),

constraint id_con
foreign key fk_conta(conta_id) references conta(id_conta)

on delete cascade
on update cascade
)engine = InnoDB;


