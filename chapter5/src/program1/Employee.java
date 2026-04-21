package program1;

//従業員
public abstract class Employee {
	//社員の名前
	private String EmployeeName;
	//所属部署の名前
	private String DepartmentName;
	
	//従業員クラスのコンストラクタ　名前、部署名
	public Employee(String EmployeeName, String DepartmentName) {
		this.setEmployeeName(EmployeeName);
		this.setDepartmentName(DepartmentName);
	}
	
	//情報表示
	public abstract void displayinfo();
	
	//privateしたEmployeeNameの閲覧
	public String getEmployeeName() {
		return EmployeeName;
	}
	//privateしたEmployeeNameの入力
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	//privateしたDepartmentNameの閲覧
	public String getDepartmentName() {
		return this.DepartmentName;
	}
	//privateしたDepartmentNameの入力
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

}
