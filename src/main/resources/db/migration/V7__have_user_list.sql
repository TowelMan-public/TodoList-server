CREATE TABLE have_user_list(
	space_id INT,
	user_id INT,
	authority_id INT NOT NULL,
	
	PRIMARY KEY(
		space_id,
		user_id
	),
	
	CONSTRAINT fk_space_id2
	    FOREIGN KEY (space_id) 
	    REFERENCES todo_space (space_id)
	    ON DELETE CASCADE ON UPDATE RESTRICT ,
	    
	CONSTRAINT fk_user_id2
	    FOREIGN KEY (user_id) 
	    REFERENCES users (user_id)
	    ON DELETE CASCADE ON UPDATE RESTRICT ,
	    
	CONSTRAINT fk_authority_id
	    FOREIGN KEY (authority_id) 
	    REFERENCES authority_list (authority_id)
	    ON DELETE RESTRICT ON UPDATE RESTRICT
);