package ch14;

public class Main14_11 {

	public static void main(String[] args) {
		Hero14_9 h1 = new Hero14_9();
		Hero14_9 h2 = new Hero14_9();

		Hero14_9.money = 100;
		System.out.println(Hero14_9.money);
		System.out.println(h1.money);
		h1.money = 300;
		System.out.println(h2.money);
	}

}
