CREATE TABLE todo_list(
	list_id INT AUTO_INCREMENT PRIMARY KEY,
	space_Id INT NOT NULL,
	
	CONSTRAINT fk_space_Id3
	    FOREIGN KEY (space_Id) 
	    REFERENCES todo_space (space_Id)
	    ON DELETE CASCADE ON UPDATE RESTRICT
);