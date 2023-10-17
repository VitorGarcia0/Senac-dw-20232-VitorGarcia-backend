INSERT INTO backend.fabricantes
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000222', '88075260', 'SC', 'Florianopolis', 'Pera');

INSERT INTO backend.fabricantes
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000444', '88495000', 'SC', 'Garopaba', 'Melita');

INSERT INTO backend.fabricantes
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000163', '88495000', 'SC', 'Garopaba', 'Raider');

INSERT INTO backend.fabricantes
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000555', '88495000', 'SC', 'Garopaba', 'Bisnaguinha');
 
INSERT INTO backend.produto
 (nome, fabricante , valor, peso, data_cadastro)
 VALUES('Chinela', "Raider", 50, 0.5, '2023-10-10');

INSERT INTO backend.produto (nome, fabricante, valor, peso, data_cadastro)
VALUES('Chinela', 'Rasteiras de madeira', 80.5, 0.2, sysdate());

INSERT INTO backend.produto (nome, fabricante, valor, peso, data_cadastro)
VALUES('Café', 'Melita', 12.5, 0.5, sysdate());

INSERT INTO backend.produto (nome, fabricante, valor, peso, data_cadastro)
VALUES('Pão', 'Bisnaguinha', 15, 1, sysdate());
