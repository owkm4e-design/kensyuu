package ch02;

public class main8_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Hero8 h = new Hero8();
		h.name = "ミナト";
		h.hp = 100;

		matango8 m1 = new matango8();
		m1.hp = 50;
		m1.suffix = 'A';

		matango8 m2 = new matango8();
		m2.hp = 50;
		m2.suffix = 'B';

		//冒険のはじまり
		h.slip();
		m1.run();
		m2.run();
		h.run();
	}

}
