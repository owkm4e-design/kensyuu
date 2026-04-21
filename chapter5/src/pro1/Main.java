package pro1;

public class Main {

	public static void main(String[] args) {
		//BTを用意
		BT bt = new BT();
		//人事部の佐藤さん(仮)を作成
		HumanResource hr = new HumanResource("佐藤");
		//佐藤さんの情報を表示
		hr.displayinfo();
		//
		hr.interview(bt, "エンジニア", "奥津", "java", true);

		System.out.println();
		bt.showAll();
		System.out.println(bt.getEmployeeList());
	}

}
