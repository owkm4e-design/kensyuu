package ch9;

import ch8.Hero8_8;

public class Main9_2 {
	public static void main(String[] args) {
		Hero8_8 h1;
		h1 = new Hero8_8();
		h1.hp = 100;

		Hero8_8 h2;
		h2 = h1;
		h2.hp = 200;
		System.out.println(h1.hp);

	}
}
