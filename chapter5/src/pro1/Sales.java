package pro1;

public class Sales extends Employee {
	//営業のコンストラクタ　必ず「営業部」がつく
	//面接していないインスタンスを自動的にリストに追加するためにBTクラスを引数として設定
	public Sales(BT bt, String EmployeeName) {
		super(EmployeeName, "営業");
		//人事がアクセスし、自動的に従業員名、営業で登録される
		bt.createEmployee("人事", EmployeeName, "営業", null);
	}

	//週報返信「週報の返信をした」と出力
	public void reply() {
		System.out.println("週報の返信をした");
	}

	//面談組む（引数：エンジニア）・・・「{エンジニア.名前}の面談を組んだ」と出力
	public void Schedule(Engineer engineer) {//Engineerクラスのインスタンス（engineer）を引数
		System.out.println(engineer.getEmployeeName() + "の面談を組んだ");//エンジニアインスタンスの名前で代入
	}

	//打ち合わせ「新規の打ち合わせをした」と出力
	public void meeting() {
		System.out.println("新規の打ち合わせをした");
	}
	

	//情報表示「{名前}：{所属部署}」を出力
	public void displayinfo() {
		System.out.println("「｛" + getEmployeeName() + "｝:｛" + getDepartmentName() + "｝」");
	}

}
