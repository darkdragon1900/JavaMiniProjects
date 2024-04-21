package bank;

import java.util.Scanner;

public class TestBank {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Customer customers[] = new Customer[3];
		Bank bank[] = new Bank[3];

		boolean exit1 = true, last = true, exit2 = true, exit3 = true;
		int ch;
		int sign;
		boolean flag = true;
		int size = 3;
		String userName;
		String userPassword;
		String password = "123456";

		Account account = new Account("132564", 50000);
		Account account2 = new Account("4984321", 456679);
		Account account3 = new Account("5644789", 514214);

		customers[0] = new Customer("Amit", "USA-Nagpur", "9921503830", account);
		customers[1] = new Customer("QWEWE", "ASAjhg", "32465416", account2);
		customers[2] = new Customer("iutyef", "ASKjgh", "324567489", account3);

//		Customer customer = new Customer("Amit", "USA-Nagpur", "9921503830", account);
//		Customer customer2 = new Customer("QWEWE", "ASAjhg", "32465416", account2);
//		Customer customer3 = new Customer("iutyef", "ASKjgh", "324567489", account3);

		// Instantiate Bank objects and assign them to the array elements
		for (int i = 0; i < size; i++) {
			bank[i] = new Bank();
			bank[i].addAccount(customers[i]);
		}

		while (last) {
			System.out.println("-------Login-------\n1.Cutomer Login\n2.Bank Login\n3.Exit");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				while (exit1) {
					System.out.println(
							"----------Cutomer----------\n1.Sign-In(Resgister User Only)\n2.Sign(To Resgister)\n3.Forgot Password\n4.Back");
					int cutomerCh = scanner.nextInt();

					exit2 = true;

					switch (cutomerCh) {
					case 1:
						System.out.println("Enter UserName(Same as Customer Name)");
						userName = scanner.next();
						scanner.nextLine();
						System.out.println("Enter Password");
						userPassword = scanner.nextLine();
						flag = true;
						for (int i = 0; i < size; i++) {
							if (userName.equalsIgnoreCase(customers[i].getName()) && userPassword.equals(password)) {
								flag = false;
								while (exit2) {
									System.out.println("Welcome " + customers[i].getName() + "\n1.Account Details"
											+ "\n2.Withdraw" + "\n3.Deposit" + "\n4.Transfer" + "\n5.Exit");
									sign = scanner.nextInt();

									switch (sign) {
									case 1:
										System.out.println(
												"===============================================================================");
										bank[i].displayCustomerDetails(customers[i]);
										System.out.println(
												"===============================================================================");
										System.out.println();
										break;

									case 2:
										System.out.println(
												"===============================================================================");
										System.out.println("Enter amount to withdraw");
										System.out.println(
												"===============================================================================");
										double amt = scanner.nextDouble();
										bank[i].withdraw(customers[i], amt);
										System.out.println(
												"===============================================================================");
										System.out.println();
										break;

									case 3:
										System.out.println(
												"===============================================================================");
										System.out.println("Enter amount to deposit");
										amt = scanner.nextDouble();
										bank[i].deposit(customers[i], amt);
										System.out.println(
												"===============================================================================");
										System.out.println();
										break;

									case 4:
										System.out.println(
												"===============================================================================");
										System.out.println("Enter Account Number to Transfer");
										String accNo = scanner.next();
										System.out.println(
												"===============================================================================");
										flag = true;
										for (int j = 0; j < size; j++) {
											if (accNo.equals(customers[j].account.getAccountNumber())) {
												flag = false;
												System.out.println("Enter amount to transfer");
												amt = scanner.nextDouble();
												bank[i].transfer(customers[i],customers[j], amt);
											}
										}
										if (flag == true) {
											System.out.println("Please Enter correct account number");
										}
										System.out.println(
												"===============================================================================");
										System.out.println();
										break;

									case 5:
										System.out.println("Thank for vist...");
										exit2 = false;
										System.out.println(
												"===============================================================================");
										System.out.println();
										break;

									default:
										System.out.println("Invalid Choice....");
										break;
									}

								}
							}
							if (flag == true) {
								System.out.println(
										"===============================================================================");
								System.out.println("Incorrect UserName or Password");
								System.out.println(
										"===============================================================================");
							}
						}

						break;

					case 2:
						System.out.println(
								"===============================================================================");
						System.out.println("Resgister");
						System.out.println("Enter UserName(Same as Customer Name)");
						userName = scanner.next();
						scanner.nextLine();
						boolean check = true;
						for (int i = 0; i < size; i++) {
							if (userName.equalsIgnoreCase(customers[i].getName())) {
								check = false;
								System.out.println("Enter Password");
								password = scanner.nextLine();
								System.out.println("Resigisteration successfull");
							}
						}
						if (check == true) {
							System.out.println("Not valid UserName");
						}
						System.out.println(
								"===============================================================================");
						break;

					case 3:
						System.out.println(
								"===============================================================================");
						System.out.println("Forgot Password");
						System.out.println("Enter UserName(Same as Customer Name)");
						userName = scanner.next();
						check = true;
						for (int i = 0; i < size; i++) {
							if (userName.equalsIgnoreCase(customers[i].getName())) {
								System.out.println("Enter Moblie number");
								String mobNo = scanner.next();
								if (mobNo.equals(customers[i].getMobileNum())) {
									check = false;
									System.out.println("Enter Password");
									password = scanner.nextLine();
									System.out.println("Password change successfull");
								}
							}
						}
						if (check == true) {
							System.out.println("Enter correct details");
						}
						System.out.println(
								"===============================================================================");
						break;

					case 4:
						System.out.println(
								"===============================================================================");
						System.out.println("Thank for vist...");
						exit1 = false;
						break;

					default:
						System.out.println("Invalid input");
						break;
					}

				}

				break;

			case 2:
				System.out.println("Banker");
				while (exit3) {
					System.out.println("1.Delete Account\n2.Add Interest\n3.Display all\n4.Exit");
					int check = scanner.nextInt();

					switch (check) {
					case 1:
						System.out.println("Enter UserName (Same as Customer Name)");
						userName = scanner.next();
						flag = true;
						for (int i = 0; i < size; i++) {
							if (customers[i].getName().equalsIgnoreCase(userName)) {
								flag = false;
								bank[i].displayCustomerDetails(customers[i]);
								System.out.println("Confirmation for Deletion");
								System.out.println("Y - Confirmation\nN - To Cancellation");
								String cancellation = scanner.next();
								if (cancellation.equalsIgnoreCase("Y")) {
									bank[i].deleteAccount(customers[i]);
									for (int j = i; j < size - 1; j++) {
										customers[j] = customers[j + 1];
									}
									customers[size - 1] = null;
									size--;
								}
							}
						}
						if (flag) {
							System.out.println("Customer not found");
						}
						break;

					case 2:
						for (int i = 0; i < size; i++) {
							bank[i].addInterest();
						}
						System.out.println("Add interest succefull");
						System.out.println(
								"===============================================================================");
						break;

					case 3:
						System.out.println(
								"===============================================================================");
						for (int i = 0; i < size; i++) {
							bank[i].displayCustomerDetails(customers[i]);
						}
						System.out.println(
								"===============================================================================");
						break;

					case 4:
						exit3 = false;
						System.out.println("Thank you.....");
						break;

					default:
						System.out.println("Invalid choice");
						break;
					}

				}
				break;

			case 3:
				last = false;
				break;

			default:
				System.out.println("Invalid Choice....");
				break;
			}
			
			scanner.close();
		}

	}

}
