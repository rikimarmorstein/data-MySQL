package b;

import java.util.Scanner;

public class Test2Delete {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);){
		

		UserDao dao = new UserDaoDb();

		User user = new User();
		System.out.println("enter id");

		int id = sc.nextInt();
		dao.delete(id);
		System.out.println("delete " + id);
		}catch(UsersException e) {
			System.out.println("Error "+e.getMessage());
		}
	}

}
