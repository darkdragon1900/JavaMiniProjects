package bank;

public class Customer {

	private String name, address, mobileNum;
	Account account;

	public Customer(String name, String address, String mobileNum, Account account) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNum = mobileNum;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void withdraw(double amt) {
		account.withdraw(amt);
	}

	public void deposit(double amt) {
		account.deposit(amt);
	}

	public void transfer(Customer customer1,Customer customer2, double amt) {
		if (account.getBalance() > amt) {
			customer1.withdraw(amt);
			customer2.deposit(amt);
		}
	}

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("AccNo : " + account.accountNumber);
		System.out.println("AccBal : " + account.balance);
		System.out.println("Address : " + address);
		System.out.println("Mobile Num : " + mobileNum);

	}

}
