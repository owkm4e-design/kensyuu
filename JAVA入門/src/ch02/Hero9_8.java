package ch02;

public class Hero9_8 {
	String name;
	int hp;
	Sword9 sword;

	public void attack() {
		System.out.println(this.name + "は攻撃した！");
		System.out.println("敵に５ポイントのダメージをあたえた！");
	}

	public Hero9_8() {
		this.hp = 100;//HPフィールドを100で初期化

	}

}
