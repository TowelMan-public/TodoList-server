CREATE TABLE authority_list(
	authority_id INT PRIMARY KEY,
	authority VARCHAR(50) NOT NULL
);
INSERT INTO authority_list (authority_id, authority) VALUES(1,'MASTER');
INSERT INTO authority_list (authority_id, authority) VALUES(2,'SUPER');
INSERT INTO authority_list (authority_id, authority) VALUES(3,'USER');