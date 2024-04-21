package library;

import java.util.ArrayList;

public class Transaction {
	private ArrayList<TransactionRecord> transactions;

	public Transaction() {
		this.transactions = new ArrayList<>();
	}

	public void recordBorrowTransaction(String memberId, String bookId) {
		transactions.add(new TransactionRecord(memberId, bookId, "Borrow"));
	}

	public void recordReturnTransaction(String memberId, String bookId) {
		transactions.add(new TransactionRecord(memberId, bookId, "Return"));
	}

	public void displayTransactions() {
		System.out.println("All Transactions:");
		for (TransactionRecord record : transactions) {
			System.out.println("Member ID: " + record.getMemberId());
			System.out.println("Book ID: " + record.getBookId());
			System.out.println("Transaction Type: " + record.getTransactionType());
			System.out.println("Transaction Date: " + record.getTransactionDate());
		}
	}
}
