package pro1;

public class HumanResource extends Employee {
	//人事のコンストラクタ　必ず「人事部」がつく
	public HumanResource(String EmployeeName) {
		super(EmployeeName, "人事");
	}

	//面接
	//引数としてBTのインスタンス(従業員作成で必要)、所属部署、名前、言語、結果
	public void interview(BT bt, String targetDept, String EmployeeName, String lang, boolean result) {
		//結果がtrueなら採用し、従業員作成
		if (result == true) {
			System.out.println("面接を行い、結果は採用だった");
			//従業員作成⇒BTクラスのcreateEmployee（）メソッドを呼び出す
			bt.createEmployee(getDepartmentName(), EmployeeName, targetDept, lang);
			//それ以外は不採用
		} else {
			System.out.println("面接を行い、結果は不採用だった");
		}
	}

	//給与計算Emp 
	public int salary() {
		int r = 200000;//一律２０万に設定（仮）
		return r;
	}

	//情報表示「{名前}：{所属部署}」を出力
	public void displayinfo() {
		System.out.println("「｛" + getEmployeeName() + "｝:｛" + getDepartmentName() + "｝」");
	}

}
