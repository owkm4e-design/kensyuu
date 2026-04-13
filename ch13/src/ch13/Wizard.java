package ch13;

public class Wizard {
	private int hp;
	private int mp;
	private String name;
	private Wand wand;

	public void heal(Hero13_13 h) {
		int basePoint = 10;//基本回復ポイント
		int recovPoint = (int) (basePoint * this.getWand().getPower());//杖による増幅
		h.setHp(h.getHp() + recovPoint);//勇者のHPを回復する
		System.out.println(h.getName() + "のHPを" + recovPoint + "回復した！");
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		if (hp > 0) {
			this.hp = hp;
		} else {
			this.hp = 0;
		}
		this.hp = hp;
	}

	public int getMp() {
		return this.mp;
	}

	public void setMp(int mp) {
		if (mp < 0) {
			throw new IllegalArgumentException("MPの数値に異常があります。");
		}
		this.mp = mp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 3) {
			throw new IllegalArgumentException("名前が短すぎる。3文字以上で入力してください。");
		}
		this.name = name;
	}

	public Wand getWand() {
		return this.wand;
	}

	public void setWand(Wand wand) {
		if (wand == null) {
			throw new IllegalArgumentException("杖がnullです。杖を装備させてください。");
		}
		this.wand = wand;
	}
}
