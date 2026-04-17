package program1;

public class BT {
	String name;
	private String EmployeeList;
	String DepartmentList;

	//BTのコンストラクタ
	public BT() {
		this.name = "BT";
	}

	//従業員リストの表示
	public String getEmployeeList() {
		return this.EmployeeList;
	}

	//人事クラスのみアクセス可能にする
	public void setEmployeeLIst(String name) {
		if (name == null) {
			System.out.println("名前を入力してください。");
		}

	}
}
