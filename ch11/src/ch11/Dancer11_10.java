package ch11;

public class Dancer11_10 extends Character11_7 {
	public void dance() {
		System.out.println(this.name + "は情熱的に踊った");
	}

	public void attack(Matango m) {
		System.out.println(this.name + "の攻撃");
		System.out.println("敵に3ポイントのダメージ");
		m.hp -= 3;
	}

}
