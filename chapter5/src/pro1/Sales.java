package pro1;

public class Sales extends Employee {
	//営業のコンストラクタ　必ず「営業部」がつく
	public Sales(String EmployeeName, String DepartmentName) {
		super(EmployeeName, "営業");
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//情報表示「{名前}：{所属部署}」を出力
	public void displayinfo() {
		System.out.println("「｛" + getEmployeeName() + "｝:｛" + getDepartmentName() + "｝」");
	}

}
