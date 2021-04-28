CREATE TABLE todo_list_details(
	list_id INT PRIMARY KEY,
	list_name VARCHAR(100) NOT NULL,
	list_date DATETIME NOT NULL,
	is_alarm TINYINT(1),
	is_enabled TINYINT(1) DEFAULT 1,
	update_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT fk_list_id
	    FOREIGN KEY (list_id) 
	    REFERENCES todo_list (list_id)
	    ON DELETE CASCADE ON UPDATE RESTRICT
);