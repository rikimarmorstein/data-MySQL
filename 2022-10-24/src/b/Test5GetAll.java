package b;

import java.util.List;

public class Test5GetAll {

	public static void main(String[] args) {

		UserDao dao = new UserDaoDb();
		List<User> list = dao.readAll();

for (User user : list) {
	System.out.println(user);
}
		//System.out.println(list);

	}

}
