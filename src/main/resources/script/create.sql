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
  
  CREATE TABLE backend.produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_fabricante INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    peso DECIMAL(8, 2) NOT NULL,
    data_cadastro DATE NOT NULL
);

CREATE TABLE backend.fabricantes (
    cnpj VARCHAR(14) NOT NULL,
    CEP VARCHAR(9) NOT NULL,
    UF CHAR(2) NOT NULL,
    Cidade VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL
);
  
);

CREATE TABLE backend.fabricantes (
	id int auto_increment NOT NULL,
	cnpj varchar(14) NOT NULL,
	CONSTRAINT fabricantes_pk PRIMARY KEY (id)
	

ALTER TABLE backend.fabricantes ADD CEP varchar(12) NOT NULL;
ALTER TABLE backend.fabricantes ADD Cidade varchar(255) NOT NULL;
ALTER TABLE backend.fabricantes ADD UF varchar(2) NOT NULL;

ALTER TABLE backend.produto  ADD fabricante varchar(100) NOT NULL;
