package ch9;

public class Hero9_12 {
	String name;
	int hp;
	Sword9_3 sword;

	public void attack() {
		System.out.println(this.name + "は攻撃した！");
		System.out.println("敵に5ポイントのダメージをあたえた！");
	}

	public Hero9_12(String name) {
		this.hp = 100;
		this.name = name;
	}

	public Hero9_12() {
		this.hp = 100;
		this.name = "ダミー";

	}

}
