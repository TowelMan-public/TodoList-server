CREATE VIEW simple_todo_list AS (
	SELECT
		have_user_list.user_id AS user_id,
    	todo_list_details.list_id AS list_id,
    	todo_list_details.list_name AS list_name,
    	todo_list_details.list_date AS list_date
    FROM todo_list_details
    INNER JOIN todo_list
    	USING(list_id)
    INNER JOIN have_user_list
    	ON todo_list.space_id = have_user_list.space_id
    INNER JOIN todo_space_details
    	ON todo_list.space_id = todo_space_details.space_id
    WHERE
    	todo_space_details.is_simple = 1
      AND
      	todo_list_details.is_enabled = 1
)