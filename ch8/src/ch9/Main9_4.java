package ch9;

public class Main9_4 {

	public static void main(String[] args) {
		Sword9_3 s = new Sword9_3();
		s.name = "炎の剣";
		s.damage = 10;
		Hero9_3 h = new Hero9_3();
		h.name = "ミナト";
		h.hp = 100;
		h.sword = s;
		System.out.println("現在の武器は" + h.sword.name);// TODO 自動生成されたメソッド・スタブ

	}

}
