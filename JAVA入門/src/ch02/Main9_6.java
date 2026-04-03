package ch02;

public class Main9_6 {

	public static void main(String[] args) {
		Hero9 h1 = new Hero9();
		h1.name = "ミナト";
		h1.hp = 100;
		Hero9 h2 = new Hero9();
		h2.name = "アサカ";
		h2.hp = 100;
		Wizard9 w = new Wizard9();
		w.name = "スガワラ";
		w.hp = 50;
		w.heal(h1);//スガワラがミナトを回復
		w.heal(h2);//スガワラがアサカを回復
		w.heal(h2);//スガワラがアサカを回復
		// TODO 自動生成されたメソッド・スタブ

	}

}
