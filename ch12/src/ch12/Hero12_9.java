package ch12;

public class Hero12_9 extends Character12_9 {
	public void attack(Monster12_9 m) {
		System.out.println(this.name + "の攻撃！");
		System.out.println("敵に10ポイントのダメージをあたえた！");
		m.hp -= 10;
	}

}
