package chapter5.program1;

public class Main {

	public static void main(String[] args) {
		//各インスタンスを作成
		BT bt = new BT();
		HumanResource hr = new HumanResource(bt, "佐藤");
		Engineer eg = new Engineer(bt, "後藤", "python");
		Sales s = new Sales(bt, "伊藤");

		//メソッドが正しく動くか確認
		hr.interview(bt, "採用", "エンジニア", "奥津", "java");
		hr.salary();
		hr.displayinfo();
		System.out.println("");

		eg.displayinfo();
		eg.develop();
		System.out.println("");

		s.reply();
		s.schedule(eg);
		s.meeting();
		s.displayinfo();
		System.out.println("");

		bt.showAll();
	}

}
/*
//BTを用意
		BT bt = new BT();

		//人事部の佐藤さん(仮)を作成
		HumanResource hr = new HumanResource(bt, "佐藤");
		hr.displayinfo();//佐藤さんの情報を表示

		//エンジニアの後藤さんを作成
		Engineer eg = new Engineer(bt, "後藤", "java");
		eg.displayinfo();//後藤さんの情報を表示
		eg.develop();//開発実施
		Engineer eg2 = new Engineer(bt, "斎藤", "java");

		//営業の伊藤さんを作成
		Sales s = new Sales(bt, "伊藤");
		s.displayinfo();//伊藤さんの情報を表示
		s.reply();//週報返信
		s.Schedule(eg);//エンジニアの後藤さんと面談を組んだ
		s.Schedule(eg2);//エンジニアの斎藤さんと面談を組んだ
		s.meeting();//新規の打ち合わせ

		//
		hr.interview(bt, "エンジニア", "奥津", "java", true);
		hr.interview(bt, "営業", "田中", "java", true);
		hr.interview(bt, "営業", "渡辺", "java", false);

		System.out.println();

		bt.showAll();

 */
