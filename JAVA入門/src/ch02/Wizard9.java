package ch02;

public class Wizard9 {
	String name;
	int hp;

	public void heal(Hero9 h) {
		h.hp += 10;
		System.out.println(h.name + "のHPを10回復した！");
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
