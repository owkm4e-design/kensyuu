package ch02;

public class PoisonMatango10 extends Matango10 {
	int poisonCount = 5;//毒を使える回数を設定→（ウ）

	public PoisonMatango10(char suffix) {//’Ａ’などの文字を引数として受け取る→（イ）
		super(suffix); //親クラスのコンストラクタに文字を渡して初期化する
				
		}
	//攻撃メソッドのオーバーライド→（ア）、（エ）
	public void attack(Hero10 h) {
		//①Matangoと同じ攻撃
		super.attack(h);
		//②毒を使える回数が残っているかチェック
		if (poisonCount > 0) {
			System.out.println("さらに毒の胞子をばらまいた！");//③
			//④勇者の今のHPを5で割った値（20%分）を計算し、HPから差し引く
			int dmg = h.hp / 5;
			h.hp -= dmg;
			System.out.println(dmg + "ポイントのダメージ！");
			//⑤毒を使ったら残り回数を１減らす→（ウ）
			this.poisonCount--;
		}
	}

}
