package ch9;

public class Main9_2 {
	public static void main(String[] args) {
		ch8.Hero8_8 h1;
		h1 = new ch8.Hero8_8();
		h1.hp = 100;

		ch8.Hero8_8 h2;
		h2 = h1;
		h2.hp = 200;
		System.out.println(h1.hp);

	}
}
