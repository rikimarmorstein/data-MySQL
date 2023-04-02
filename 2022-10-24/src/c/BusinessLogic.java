package c;

public class BusinessLogic {

	private AccountDao accountdao = new AccountDaoDb();

	public void transferMoney(double sum, int accountIdSrc, int accountIdDst) {
		accountdao.withdraw(accountIdSrc, sum);
		accountdao.deposit(accountIdDst, sum);
	}

	public static void main(String[] args) {
		BusinessLogic b1 = new BusinessLogic();
		b1.transferMoney(5, 1, 2);
		System.out.println("Transfer was successful");
	}
}
