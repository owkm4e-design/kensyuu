package practice;

public class Account {
	private String owner;
	private int balance;

	public Account(String owner, int balance) {
		this.owner = owner;
		this.balance = balance;
	}

	public String getOwner() {
		return this.owner;
	}

	public int getBalance() {
		return this.balance;
	}

	public void deposit(int m) {
		this.balance += m;
		System.out.println(m + "円入金しました。現在の残高は" + balance + "円です");
	}

	public void withdraw(int m) {
		if (m > this.balance) {
			System.out.println("残高不足です。");
		} else {
			this.balance -= m;
			System.out.println(m + "円出金しました。現在の残高は" + this.balance + "円です");
		}

	}

}
