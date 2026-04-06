package ch02;

public class Hero9_16 {
	String name;
	int hp;
	Sword9 sword;

	public void attack() {
		System.out.println(this.name + "は攻撃した！");
		System.out.println("敵に５ポイントのダメージをあたえた！");

	}

	public Hero9_16(String name) {
		this.hp = 100;
		this.name = name;

	}

	public Hero9_16() {
		this("ダミー");
	}

}
