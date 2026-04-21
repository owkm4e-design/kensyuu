package pro1;

public class BT {
	//会社名をBTで固定
	final String Companyname = "BT";
	//従業員のリスト
	private String EmployeeList = "";
	//部署リスト（従業員クラス.所属部署と対応）
	//→「人事・営業・エンジニア」の3部署を想定
	private String DepartmentList = "人事,営業,エンジニア";

	//従業員を作成 create(部署名、名前、（言語））
	//①人事クラスのみアクセス可能にすること
	//②エンジニアを作成する場合は使用言語も情報として持たせること
	public void createEmployee(String DepartmentName, String EmployeeName, String targetDept, String lang) {//部署名、登録する従業員名、登録する部署、言語
		//①部署名（DepartmentName）≠人事だったらアクセス拒否
		if (!(DepartmentName.equals("人事"))) {
			System.out.println("人事クラスのみアクセス可能です");
			return;
			//以降は人事で確定
			//②エンジニアの登録する場合、言語langを追加
		} else if (targetDept.equals("エンジニア")) {
			//従業員リストに[エンジニア：Aさん（言語）]を追加
			EmployeeList += "[エンジニア：" + EmployeeName + "(" + lang + ")]";
			//エンジニア以外の登録をする場合
		} else {
			//従業員リストに[部署名（targetDept）：Aさん]を追加
			EmployeeList += "[" + targetDept + ":" + EmployeeName + "]";
		}
	}

	//従業員情報表示
	//全従業員の情報を表示（従業員.情報表示を実行）
	public void showAll() {
		getEmployeeList();
		getDepartmentList();
	}

	//従業員リストの開示
	public String getEmployeeList() {
		return EmployeeList;
	}

	//部署リストの開示
	public String getDepartmentList() {
		return DepartmentList;
	}

}
