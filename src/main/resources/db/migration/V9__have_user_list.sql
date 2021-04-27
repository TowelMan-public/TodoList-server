DROP TABLE IF EXISTS have_user_list;

CREATE TABLE have_user_list(
	space_id INT,
	user_id INT,
	autority_id NOT_NULL,
	
	PRIMARY KEY(
		space_id,
		user_id
	),
	
	CONSTRAINT fk_space_id
	    FOREIGN KEY (space_id) 
	    REFERENCES todo_space (space_id)
	    ON DELETE CASCAD ON UPDATE RESTRICT ,
	    
	CONSTRAINT fk_user_id
	    FOREIGN KEY (user_id) 
	    REFERENCES users (user_id)
	    ON DELETE CASCAD ON UPDATE RESTRICT ,
	    
	CONSTRAINT fk_autority_id
	    FOREIGN KEY (autority_id) 
	    REFERENCES autority_list (autority_id)
	    ON DELETE RESTRICT ON UPDATE RESTRICT
);