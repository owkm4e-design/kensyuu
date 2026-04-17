package program1;

public class BT {
	final String Companyname = "BT";
	private String EmployeeList = "";
	String DepartmentList = "人事,営業,エンジニア";

	//従業員作成
	public void createEmployee(String EmployeeName, String DepartmentName, String language) {
		//人事クラスのみアクセス可能
		if (!(DepartmentName == "人事")) {
			System.out.println("人事クラスのみアクセス可能です");
			return;
		}
		//エンジニアは使用言語も持たせる
		if (DepartmentName == "エンジニア") {
			this.EmployeeList += "エンジニア" + EmployeeName + "言語" + language;
		} else {
			this.EmployeeList += DepartmentName + EmployeeName;
		}
	}

	//従業員情報の表示
	public String getEmployeeList() {
		return this.EmployeeList;
	}
}
