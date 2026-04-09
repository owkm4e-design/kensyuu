package ch9;

public class Wizard9_5 {
	String name;
	int hp;

	public void heal(Hero9_3 h) {
		h.hp += 10;
		System.out.println(h.name + "のHPを10回復した！");
	}

}
