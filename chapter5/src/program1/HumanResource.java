package program1;

//従業員クラスから人事クラスへ継承
public class HumanResource extends Employee {
	//人事のコンストラクタ　部署名：人事
	public HumanResource(String EmployeeName) {
		super(EmployeeName, "人事");
	}

	//面接
	public void interview(BT bt, String name, String dept, String language, boolean Hired) {
		//面接結果
		if (Hired) {
			System.out.println("面接を行い、結果は採用だった");
			bt.createEmployee(this.getDepartmentName(), dept, language, name);
		} else {
			System.out.println("面接を行い、結果は不採用だった");
		}

	}

	//給与計算　
	public int CalculateSalary() {
		//給与計算Emp
		int r = 200000;
		return r;
	}

	//情報表示
	public void displayinfo() {
		System.out.println(this.getEmployeeName() + ":" + this.getDepartmentName());

	}

}
