package program1;

public class Sales extends Employee {

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
		System.out.println(this.EmployeeName + ":" + this.DepartmentName);

	}

}
