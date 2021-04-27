DROP TABLE IF EXISTS todo_space_details;

CREATE TABLE todo_space_details(
	space_id INT PRIMARY KEY,
	space_name VARCHAR(100) NOT_NULL,
	scope_id INT DEFAULT (2),
	is_simple TINYINT(1) DEFAULT (0),
	is_enabled TINYINT(1) DEFAULT (1),
	update_timestampe DATETIME DEFAULT (CURRENT_TIMESTAMP)
	
	CONSTRAINT fk_space_id
	    FOREIGN KEY (space_id) 
	    REFERENCES todo_space (space_id)
	    ON DELETE CASCAD ON UPDATE RESTRICT ,
	    
	CONSTRAINT fk_scope_id
	    FOREIGN KEY (scope_id) 
	    REFERENCES scope_list (scope_id)
	    ON DELETE RESTRICT ON UPDATE RESTRICT
);