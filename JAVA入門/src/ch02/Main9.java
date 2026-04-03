package ch02;

public class Main9 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Sword9 s = new Sword9();
		s.name = "炎の剣";
		s.damage = 10;
		Hero9 h = new Hero9();
		h.name = "ミナト";
		h.hp = 100;
		h.sword = s;
		System.out.println("現在の武器は" + h.sword.name);

	}

}
