
 INSERT INTO backend.fabricante
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000222', '88075260', 'SC', 'Florianopolis', 'Adidas');

INSERT INTO backend.fabricante
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000444', '88495000', 'SC', 'Garopaba', 'Melita');

INSERT INTO backend.fabricante
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000163', '88495000', 'SC', 'Garopaba', 'Raider');

INSERT INTO backend.fabricante
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000555', '88495000', 'SC', 'Garopaba', 'Bauduco');
 
INSERT INTO backend.produto
 (nome, id_fabricante , valor, peso, data_cadastro)
 VALUES('Sandália', 1, 50, 0.5, sysdate());

INSERT INTO backend.produto (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 2, 12.5, 0.5, sysdate());

INSERT INTO backend.produto (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela', 3, 80.5, 0.2, sysdate());

INSERT INTO backend.produto (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Pão', 4, 15, 1, sysdate());

select * from fabricante f ;

select * from produto p ;