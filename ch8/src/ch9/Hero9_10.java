package ch9;

public class Hero9_10 {
	String name;
	int hp;
	Sword9_3 sword;

	public void attack() {
		System.out.println(this.name + "は攻撃した！");
		System.out.println("敵に5ポイントのダメージをあたえた！");
	}

	public Hero9_10(String name) {
		this.hp = 100;
		this.name = name; //引数の値でnameフィールドを初期化
	}

}
