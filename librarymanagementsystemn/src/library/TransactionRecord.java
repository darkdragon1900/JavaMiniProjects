package library;

import java.util.Date;

public class TransactionRecord {
	private String memberId;
	private String bookId;
	private String transactionType; // Borrow or Return
	private Date transactionDate;

	public TransactionRecord(String memberId, String bookId, String transactionType) {
		this.memberId = memberId;
		this.bookId = bookId;
		this.transactionType = transactionType;
		this.transactionDate = new Date(); // Current date and time
	}

	public String getMemberId() {
		return memberId;
	}

	public String getBookId() {
		return bookId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
}
