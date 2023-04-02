package c;

import java.sql.Connection;

public interface AccountDao {

	void deposit(Connection con, int accountIdA, double amount);

	void withdraw(Connection con, int accountIdB, double amount);

	double getBalance(Connection con, int accountId);
}
