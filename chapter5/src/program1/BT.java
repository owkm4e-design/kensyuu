package program1;

public class BT {
	//属性　会社名（固定）、従業員リスト、部署リスト

	//会社名をBTで固定
	private final String Companyname = "BT";
	//従業員リスト
	private String EmployeeList = "";
	//部署リスト
	private String DepartmentList = "人事,営業,エンジニア";

	//従業員作成　「誰が、誰を、どの部署に、どの言語で」
	public void createEmployee(String EmployeeName, String targetDept, String DepartmentName, String language) {
		//人事クラスのみアクセス可能
		//部署名≠「人事」ではない場合は戻る
		if (!(DepartmentName.equals("人事"))) {
			System.out.println("人事クラスのみアクセス可能です");
			return;
			//部署名＝「人事」の場合はそのまま次の工程へ
		} else {
			//エンジニアは使用言語も持たせる　[部署名 従業員名]/[部署名 従業員名（使用言語：言語）]
			//部署名が「エンジニア」だった場合、使用言語を含ませる
			if (targetDept.equals("エンジニア")) {
				this.EmployeeList += "[エンジニア" + EmployeeName + "(使用言語:" + language + ")]";
				//部署名が「エンジニア」以外だった場合
			} else {
				this.EmployeeList += "[" + targetDept + EmployeeName + "]";
			}
		}

		/*
		if (targetDept.equals("エンジニア")) {
			this.EmployeeList += "[エンジニア" + EmployeeName + "(使用言語:" + language + ")]";
		} else {
			this.EmployeeList += "[" + targetDept + EmployeeName + "]";
		}*/
	}

	//従業員情報の表示
	public String getEmployeeList() {
		return this.EmployeeList;
	}

	//会社名の表示
	public String getCompanyname() {
		return this.Companyname;
	}

	//部署名リストの表示
	public String getDepartmentList() {
		return this.DepartmentList;
	}

	//部署リストの書き換え
	public void setDepartmentList(String departmentList) {
		DepartmentList = departmentList;
	}
}
