package ch10;

public class SuperHero10_9 extends Hero10_7 {
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
		super.attack(m); //親インスタンス部分のattack()を呼び出し
		if (this.flying) {
			super.attack(m);
		}

	}
}
