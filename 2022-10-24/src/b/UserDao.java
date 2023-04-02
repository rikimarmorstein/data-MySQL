package b;

import java.util.List;

public interface UserDao {

	int create(User user) throws UsersException;
	User read(int id) throws UsersException;
	List<User>readAll() throws UsersException;
	void update (User user) throws UsersException;
	void delete (int id) throws UsersException;
	
	
	
}
