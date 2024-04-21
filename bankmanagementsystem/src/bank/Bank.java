package bank;

public class Bank {
	private int accNoSize = 10;
	private Customer customer[];
	static double interest = 3;
	private int size;

	public Bank() {
		customer = new Customer[accNoSize];
		size = 0;
	}

	public void addAccount(Customer customer1) {
		if (size < this.customer.length) {
			customer[size++] = customer1;
		} else {
			System.out.println("Account is full..");
		}
	}

	public void deleteAccount(Customer customer2) {
		for (int i = 0; i < size; i++) {
			if (customer[i] == customer2) {
				for (int j = i; j < size-1; j++) {
					customer[j] = customer[j + 1];
				}
				customer[size - 1] = null;
				size--;
			}
		}
	}

	public void addInterest() {
		for (int i = 0; i < size; i++) {
			double inter = customer[i].account.getBalance();
			double addInterest = inter * (interest / 100);
			customer[i].account.setBalance(addInterest + customer[i].account.getBalance());
		}
	}

	public void displayCustomerDetails(Customer customer3) {
		customer3.display();
	}

	public void withdraw(Customer customer3, double amt) {
		customer3.withdraw(amt);
	}

	public void deposit(Customer customer3, double amt) {
		customer3.deposit(amt);
	}

	public void transfer(Customer customer3,Customer customer4, double amt) {
		customer3.transfer(customer3,customer4, amt);
	}

}
