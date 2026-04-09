package ch10;

public class SuperHero10_2 {
	String name = "ミナト";
	int hp = 100;
	boolean flying; //追加

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

	//飛ぶ
	public void fly() {
		this.flying = true;
		System.out.println(this.name + "は飛び上がった！");
	}

	//飛ぶ
	public void land() {
		this.flying = false;
		System.out.println(this.name + "は着地した！");
	}
}
