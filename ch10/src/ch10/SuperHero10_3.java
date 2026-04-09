package ch10;

public class SuperHero10_3 extends Hero10_1 {
	boolean flying;

	public void fly() {
		this.flying = true;
		System.out.println(this.name + "は飛び上がった！");
	}

	public void land() {
		this.flying = false;
		System.out.println(this.name + "は着地した！");
	}

}
