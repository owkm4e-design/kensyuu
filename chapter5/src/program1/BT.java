package program1;

public class BT {
	private final String Companyname = "BT";
	private String EmployeeList = "";
	private String DepartmentList = "人事,営業,エンジニア";

	//従業員作成　「誰が、誰を、どの部署に、どの言語で」
	public void createEmployee(String EmployeeName, String DepartmentName, String targetDept, String language) {
		//人事クラスのみアクセス可能
		if (!(DepartmentName.equals("人事"))) {
			System.out.println("人事クラスのみアクセス可能です");
			return;
		}
		//エンジニアは使用言語も持たせる
		if (targetDept.equals("エンジニア")) {
			this.EmployeeList += "[エンジニア" + EmployeeName + "(使用言語:" + language + ")]";
		} else {
			this.EmployeeList += "[" + targetDept + EmployeeName + "]";
		}
	}

	//従業員情報の表示
	public String getEmployeeList() {
		return this.EmployeeList;
	}

	public String getCompanyname() {
		return this.Companyname;
	}

	public String getDepartmentList() {
		return this.DepartmentList;
	}

	public void setDepartmentList(String departmentList) {
		DepartmentList = departmentList;
	}
}
