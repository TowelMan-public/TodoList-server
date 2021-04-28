CREATE TABLE todo_content(
	content_id INT PRIMARY KEY AUTO_INCREMENT,
	list_id INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	content_text VARCHAR(2000) NOT NULL,
	is_enabled TINYINT(1) DEFAULT 1,
	update_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT fk_list_id2
	    FOREIGN KEY (list_id) 
	    REFERENCES todo_list (list_id)
	    ON DELETE CASCADE ON UPDATE RESTRICT
);