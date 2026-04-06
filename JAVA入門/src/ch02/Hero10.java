package ch02;

public class Hero10 {
	String name="ミナト";
	int hp=100;
	//戦う
	public void attack(matango8 m) {
		System.out.println(this.name+"の攻撃！");
		m.hp-=5;
		System.out.println("5ポイントのダメージを与えた！");
	}
	//逃げる
	public void run() {
		System.out.println(this.name+"は逃げ出した！");
	}
	public Hero10() {
		System.out.println("Heroのコンストラクタが動作");
	}
}
