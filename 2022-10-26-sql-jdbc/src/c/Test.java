package c;

public class Test {

	public static void main(String[] args) {

		try {

			BusinessLogic b1 = new BusinessLogic();
			b1.deposit(1, 500);
			b1.withdraw(2, 5);
			System.out.println("end");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
