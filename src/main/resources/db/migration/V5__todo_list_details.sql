DROP TABLE IF EXISTS todo_list_details;

CREATE TABLE todo_list_details(
	list_id INT PRIMARY KEY,
	list_name VARCHAR(100) NOT_NULL,
	list_date DATETIME NOT_NULL,
	is_alarm TINYINT(1),
	is_enabled TINYINT(1) DEFAULT (1),
	update_timestamp DATETIME DEFAULT (CURRENT_TIMESTAMP),
	
	CONSTRAINT fk_list_id
	    FOREIGN KEY (list_id) 
	    REFERENCES todo_list (list_id)
	    ON DELETE CASCAD ON UPDATE RESTRICT
);