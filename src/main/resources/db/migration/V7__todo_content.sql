DROP TABLE IF EXISTS todo_content;

CREATE TABLE todo_content(
	content_id INT PRIMARY KEY AUTO_INCREMENT,
	list_id INT NOT_NULL,
	title VARCHAR(100) NOT_NULL,
	content_text VARCHAR(2000) NOT_NULL,
	is_enabled TINYINT(1) DEFAULT (1),
	update_timestamp DATETIME DEFAULT (CURRENT_TIMESTAMP),
	
	CONSTRAINT fk_list_id
	    FOREIGN KEY (list_id) 
	    REFERENCES todo_list (list_id)
	    ON DELETE CASCAD ON UPDATE RESTRICT
);