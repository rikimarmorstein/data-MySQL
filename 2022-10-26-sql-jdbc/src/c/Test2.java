package c;

public class Test2 {

	public static void main(String[] args) {

		try {

			BusinessLogic b1 = new BusinessLogic();
			b1.transfer(1, 2, 30);
			System.out.println("end");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
