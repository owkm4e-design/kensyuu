package pro1;

//従業員クラス
public abstract class Employee {
	//属性
	private String EmployeeName;//従業員の名前
	private String DepartmentName;//所属している部署名

	//従業員のコンストラクタ 従業員名、部署名、
	public Employee(String EmployeeName, String DepartmentName) {
		this.EmployeeName = EmployeeName;
		this.DepartmentName = DepartmentName;
	}

	//abstract 情報表示
	public abstract void displayinfo();

	//従業員名の開示
	public String getEmployeeName() {
		return EmployeeName;
	}

	//部署名の開示
	public String getDepartmentName() {
		return DepartmentName;
	}
}
