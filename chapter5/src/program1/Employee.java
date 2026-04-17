package program1;

//従業員
public abstract class Employee extends BT {
	String EmployeeName;
	String DepartmentName;

	public Employee(String EmployeeName, String DepartmentName) {
		this.EmployeeName = EmployeeName;
		this.DepartmentName = DepartmentName;
	}

	public String getDepartmentList() {
		return DepartmentName;
	}

	public abstract void displayinfo();

}
