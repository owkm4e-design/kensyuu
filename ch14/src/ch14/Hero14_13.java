package ch14;

public class Hero14_13 {
	String name;
	int hp;
	static int money;

	public static void setRandomMoney() {
		Hero14_13.money = (int) (Math.random() * 1000);
	}
}
