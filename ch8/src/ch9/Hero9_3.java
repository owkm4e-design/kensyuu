package ch9;

public class Hero9_3 {
	String name;
	int hp;
	Sword9_3 sword;

	public void attack() {
		System.out.println(this.name + "は攻撃した！");
		System.out.println("敵に5ポイントのダメージをあたえた！");
	}

}
