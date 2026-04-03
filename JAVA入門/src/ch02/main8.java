package ch02;

public class main8 {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//１．勇者を生み出す
		Hero8 h = new Hero8();
		//２．最初の名前とHPを設定
		h.name = "ミナト";
		h.hp = 100;
		System.out.println("勇者" + h.name + "を生み出しました！");
		//３．5秒座れ、転べ、２５秒座れ、逃げろと指示を出す
		h.sit(5);
		h.slip();
		h.sit(25);
		h.run();

	}
}
