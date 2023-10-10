INSERT INTO backend.produto (nome, fabricante, valor, peso, data_cadastro)
VALUES('Café', 'Ouro', 12.5, 0.5, sysdate());

INSERT INTO backend.produto (nome, fabricante, valor, peso, data_cadastro)
VALUES('Chinela', 'Rasteiras de madeira', 80.5, 0.2, sysdate());

INSERT INTO backend.produto
 (nome, fabricante , valor, peso, data_cadastro)
 VALUES('Chinela', "Raider", 50, 1, '2023-10-10');
 
 INSERT INTO backend.fabricantes
 (cnpj, CEP, UF, Cidade, nome)
 VALUES('04818506000163', '88495000', 'SC', 'Garopaba', 'Raider');

-- INSERT INTO backend.fabricantes
-- (cnpj, CEP, UF, Cidade, nome)
-- VALUES('', '', '', '', '');


-- ALTER TABLE backend.produto CHANGE id_fabricante fabricante VARCHAR(255) NOT NULL;
-- ALTER TABLE backend.produto MODIFY COLUMN fabricante VARCHAR(255) NOT NULL;

ALTER TABLE backend.produto CHANGE id_fabricante fabricante VARCHAR(255) NOT NULL;
ALTER TABLE backend.produto MODIFY COLUMN fabricante VARCHAR(255) NOT NULL;

ALTER TABLE backend.produto ADD CONSTRAINT produto_FK FOREIGN KEY (fabricante) REFERENCES backend.fabricantes(id);
ALTER TABLE backend.produto ADD CONSTRAINT produto_FK FOREIGN KEY (fabricante) REFERENCES backend.fabricantes(id);
