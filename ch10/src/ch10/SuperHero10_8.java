package ch10;

public class SuperHero10_8 extends Hero10_7 {
	boolean flying;

	public void fly() {
		this.flying = true;
		System.out.println(this.name + "は飛び上がった！");
	}

	public void land() {
		this.flying = false;
		System.out.println(this.name + "は着地した！");
	}

	public void run() {
		System.out.println(this.name + "は撤退した！");
	}

	public void attack(Matango8_6 m) {
		System.out.println(this.name + "の攻撃！");
		m.hp -= 5;
		System.out.println("5ポイントのダメージをあたえた！");
		if (this.flying) {
			System.out.println(this.name + "の攻撃！");
			m.hp -= 5;
			System.out.println("5ポイントのダメージをあたえた！");
		}
	}

}