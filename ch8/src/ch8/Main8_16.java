package ch8;

public class Main8_16 {

	public static void main(String[] args) {
		Hero8_8 h = new Hero8_8();
		h.name = "ミナト";
		h.hp = 100;

		Matango8_6 m1 = new Matango8_6();
		m1.hp = 50;
		m1.suffix = 'A';

		Matango8_6 m2 = new Matango8_6();
		m2.hp = 48;
		m2.suffix = 'B';

		//冒険のはじまり
		h.slip();
		m1.run();
		m2.run();
		h.run();

	}

}
