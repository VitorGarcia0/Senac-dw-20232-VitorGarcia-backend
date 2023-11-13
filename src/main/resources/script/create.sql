CREATE TABLE backend.fabricante (
	id int auto_increment NOT NULL,
	nome varchar(400) NOT NULL,
	cnpj varchar(14) NOT NULL,
	cep varchar(14) NOT NULL,
	cidade varchar(100) NOT NULL,
	uf varchar(2) NOT null,
	CONSTRAINT fabricantes_pk PRIMARY KEY (id)
);

CREATE TABLE backend.produto (
	id int auto_increment NOT NULL,
	nome varchar(400) NOT NULL,
	id_fabricante int NOT NULL,
	valor DECIMAL NOT NULL,
	peso DECIMAL NOT NULL,
	data_cadastro DATE NOT NULL,
	CONSTRAINT produtos_pk PRIMARY KEY (id),
	CONSTRAINT id_fabricante foreign key (id_fabricante) references backend.fabricante(ID)
);

