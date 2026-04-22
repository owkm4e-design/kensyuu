package pro1;

//
public class Engineer extends Employee {
	String lang = "";//使用言語（java, pythonなど）

	//エンジニアのコンストラクタ　必ず「エンジニア部」がつく
	//面接していないインスタンスを自動的にリストに追加するためにBTクラスを引数として設定
	public Engineer(BT bt, String EmployeeName, String lang) {
		super(EmployeeName, "エンジニア");
		this.lang = lang;//言語が引数として代入された言語で表示される
		//人事がアクセスし、自動的に従業員名、エンジニア、言語名で登録される
		bt.createEmployee("人事", EmployeeName, "エンジニア", lang);
	}

	//「{使用言語}で開発を行なった」と出力
	public void develop() {
		System.out.println(lang + "で開発を行った");
	}

	//情報表示「{名前}：{所属部署}　使用言語：{使用言語}」を出力
	public void displayinfo() {
		System.out.println("「｛" + getEmployeeName() + "｝:｛" + getDepartmentName() + "｝　使用言語：｛" + lang + "}」");
	}
}
