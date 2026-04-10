package practice;

public class PoisonMatango10 extends Matango10 {
	int poisoncount = 5;

	public PoisonMatango10(char suffix) { //イ
		super(suffix);
	}

	public void attack(Hero10 h) {
		super.attack(h);
		if (this.poisoncount > 0)
			;
		{
			System.out.println("さらに毒の胞子をばらまいた！");
			int dmg = h.hp / 5;
			h.hp -= dmg;
			System.out.println(dmg + "ポイントのダメージ！");
			this.poisoncount--;

		}

	}

}
