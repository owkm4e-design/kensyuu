package practice;

public class Matango10 {
	int hp = 50;
	char suffix;

	public Matango10(char suffix) {
		this.suffix = suffix;
	}

	public void attack(Hero10 h) {
		System.out.println("キノコ" + this.suffix + "の攻撃！");
		System.out.println("10のダメージ");
		h.hp -= 10;
	}

}
