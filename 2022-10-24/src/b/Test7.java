package b;

import java.util.Random;

public class Test7 {

	public static void main(String[] args) {
Random random = new Random();
String []names = {"Dan", "Ran", "Roz", "Ari", "Dor"};
	UserDao dao = new UserDaoDb();
	
			User user = new User();

	for (int i = 0; i < 100; i++) {
		String name = names[random.nextInt(names.length)];
		user.setName(name);
		user.setEmail(name.toLowerCase()+ "@gmail.com");
		dao.create(user);
		System.out.println(user);
	}
		
	}

}
