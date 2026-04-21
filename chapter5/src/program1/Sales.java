package program1;
//従業員クラスから営業クラスへ継承
public class Sales extends Employee {
	//営業のコンストラクタ　部署名：営業
	public Sales(String EmployeeName) {
		super(EmployeeName, "営業");

	}

	//週報返信
	public void Weeklyreportreply() {
		System.out.println("週報の返信をした");
	}

	//面談組む
	public void interview(Engineer name) {
		System.out.println(name + "の面談を組んだ");
	}

	//打ち合わせ
	public void meeting() {
		System.out.println("新規の打ち合わせをした");
	}

	//情報表示
	public void displayinfo() {
		System.out.println(this.getEmployeeName() + ":" + this.getDepartmentName());

	}

}
