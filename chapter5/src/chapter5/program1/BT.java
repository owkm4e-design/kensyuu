package chapter5.program1;

public class BT {
	final String companyname = "BT";//BTで固定
	String EmployeeList = "";//従業員リスト
	String DeptList = "人事,営業,エンジニア";//部署リスト

	public BT() {
	}

	//従業員を作成
	public void createEmp(String Dept, String targetDept, String targetName, String lang) {
				//(アクセスする人の部署, 登録する部署, 登録する名前, 登録するエンジニアの言語)

		if (!(Dept.equals("人事"))) {
			System.out.println("アクセス拒否");
			return;//人事以外を拒否

			//以降、人事の操作
		} else if (targetDept.equals("エンジニア")) {
			EmployeeList += "エンジニア：" + targetName +"("+ lang + ")\n";//エンジニアだった場合、リストにlangを追記
		} else {
			EmployeeList += targetDept +":"+ targetName + "\n";
		}
	}

	//全従業員の情報を表示
	public void showAll() {
		System.out.println(EmployeeList);
	}
}
