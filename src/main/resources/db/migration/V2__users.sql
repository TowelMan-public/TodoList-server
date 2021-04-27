DROP TABLE IF EXISTS have_user_list;

CREATE TABLE have_user_list(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(100) NOT_NULL UNIQUE,
	password VARCHAR(100) NOT_NULL,
	is_enabled INT DEFAULT(1),
);