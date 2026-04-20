package ch14;

public class Bank {
	String accountNumber;
	int balance;

	public String toString() {
		return "\\" + this.balance + "（口座番号：" + this.accountNumber + ")";
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Bank b) {
			String bn1 = this.accountNumber.trim();
			String bn2 = b.accountNumber.trim();
			if (bn1.equals(bn2)) {
				return true;
			}
		}
		return false;
	}
}
