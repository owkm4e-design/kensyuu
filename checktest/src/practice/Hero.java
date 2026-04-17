package practice;

public class Hero {
	private String name;
	private int hp;

	public Hero(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public void attack(String Matango) {
		System.out.println(this.name + "は" + Matango + "に攻撃した！");
	}

	public void receiveDamage(int damage) {
		this.hp -= damage;
		if (this.hp < 0) {
			this.hp = 0;
			System.out.println(this.name + "は倒れた…");
		}
	}
}
