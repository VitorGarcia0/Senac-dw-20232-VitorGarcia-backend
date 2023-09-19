CREATE TABLE backend.produto (
	CREATE TABLE `produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(400) NOT NULL,
  `id_fabricante` int NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  `peso` decimal(10,0) NOT NULL,
  `data_cadastro` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fabricante` (`id_fabricante`),
  CONSTRAINT `id_fabricante` FOREIGN KEY (`id_fabricante`) REFERENCES `fabricantes` (`id`)
  
);

CREATE TABLE backend.fabricantes (
	id int auto_increment NOT NULL,
	cnpj varchar(14) NOT NULL,
	CONSTRAINT fabricantes_pk PRIMARY KEY (id)
	

ALTER TABLE backend.fabricantes ADD CEP varchar(12) NOT NULL;
ALTER TABLE backend.fabricantes ADD Cidade varchar(255) NOT NULL;
ALTER TABLE backend.fabricantes ADD UF varchar(2) NOT NULL;
