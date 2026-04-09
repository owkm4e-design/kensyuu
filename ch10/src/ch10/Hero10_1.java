package ch10;

public class Hero10_1 {
	String name = "ミナト";
	int hp = 100;

	//戦う
	public void attack(Matango8_6 m) {
		System.out.println(this.name + "の攻撃！");
		m.hp -= 5;
		System.out.println("5ポイントのダメージをあたえた！");
	}

	//逃げる
	public void run() {
		System.out.println(this.name + "は逃げ出した！");
	}
}
