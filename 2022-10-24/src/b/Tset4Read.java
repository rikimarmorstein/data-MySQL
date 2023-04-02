package b;

public class Tset4Read {

	public static void main(String[] args) {

try { 
		int id = 8;
		UserDaoDb dao = new UserDaoDb();
		User user = dao.read(id);
		System.out.println(user);
}catch (UsersException e) {
	System.out.println(e.getMessage());
e.printStackTrace();
}
System.out.println("End");
	}

}
