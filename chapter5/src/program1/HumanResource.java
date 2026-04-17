package program1;

//人事
public class HumanResource extends Employee {

	public HumanResource(String EmployeeName) {
		super(EmployeeName, "人事");
	}

	//面接
	public void interview(BT bt, String name, String dept, String language, boolean Hired) {

		if (Hired == true) {
			System.out.println("採用");
		} else {
			System.out.println("不採用");
		}
		System.out.println("面接を行い、結果は" + Hired + "だった");
		if (Hired == true) {
			bt.createEmployee(name, dept, language);
		}
	}

	//給与計算　
	public void CalculateSalary() {
		//給与計算Emp
	}

	//情報表示
	public void displayinfo() {
		System.out.println(this.EmployeeName + ":" + this.DepartmentName);

	}

}
