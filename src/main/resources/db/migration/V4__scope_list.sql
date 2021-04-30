CREATE TABLE scope_list(
	scope_id INT PRIMARY KEY,
	scope VARCHAR(50) NOT NULL
);
INSERT INTO scope_list (scope_id, scope) VALUES(1,'PUBLIC');
INSERT INTO scope_list (scope_id, scope) VALUES(2,'PROTECTED');
INSERT INTO scope_list (scope_id, scope) VALUES(3,'PRIVATE');