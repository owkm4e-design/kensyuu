package program1;
//従業員クラスからエンジニアクラスへ継承
public class Engineer extends Employee {
	//使用言語
	private String language;

	//エンジニアのコンストラクタ　部署名：エンジニア＋言語を持たせる
	public Engineer(String EmployeeName, String language) {
		super(EmployeeName, "エンジニア");
		this.language = language;
	}

	//開発実施
	public void development() {
		System.out.println(this.language + "で開発を行った");

	}

	//情報表示
	public void displayinfo() {
		System.out.println(this.getEmployeeName() + ":" + this.getDepartmentName());
	}

}
