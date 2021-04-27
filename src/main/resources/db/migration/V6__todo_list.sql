DROP TABLE IF EXISTS todo_list;

CREATE TABLE todo_list(
	list_id INT AUTO_INCREMENT PRIMARY KEY,
	space_Id INT NOT_NULL,
	
	CONSTRAINT fk_space_Id
	    FOREIGN KEY (space_Id) 
	    REFERENCES todo_space (space_Id)
	    ON DELETE CASCAD ON UPDATE RESTRICT
);