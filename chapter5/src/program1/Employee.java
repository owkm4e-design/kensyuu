package program1;

//従業員
public abstract class Employee {
	private String EmployeeName;
	private String DepartmentName;

	public Employee(String EmployeeName, String DepartmentName) {
		this.setEmployeeName(EmployeeName);
		this.setDepartmentName(DepartmentName);
	}

	public abstract void displayinfo();

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getDepartmentName() {
		return this.DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

}
