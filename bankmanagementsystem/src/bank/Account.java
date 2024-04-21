package bank;

public class Account {
	String accountNumber;
	double balance;

	public Account(String accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public void withdraw(double amt) {
		if (balance > amt) {
			balance -= amt;
			System.out.println(amt + " withdrawn successfully...");
			System.out.println("Remaining balance" + balance);
		} else {
			System.out.println("insufficient funds...");
		}
	}

	public void deposit(double amt) {
		balance += amt;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
