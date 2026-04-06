package ch02;

public class SuperHero10 extends Hero10 {
	boolean flying;

	public SuperHero10() {
		super();
		System.out.println("SuperHeroのコンストラクタが動作");
	}

	public void fly() {
		this.flying = true;
		System.out.println("飛び上がった！");
	}

	public void land() {
		this.flying = false;
		System.out.println("着地した！");
	}

	public void run() {
		System.out.println(this.name + "は撤退した");
	}

	public void attack(matango8 m) {
		super.attack(m);
		if (this.flying) {
			super.attack(m);
		}

	}

}
