package pro1;
//
public class Engineer extends Employee {
	String lang;//使用言語（java, pythonなど）
	
	//エンジニアのコンストラクタ　必ず「エンジニア部」がつく
	public Engineer(String EmployeeName, String DepartmentName) {
		super(EmployeeName, "エンジニア");
	}

	//情報表示「{名前}：{所属部署}　使用言語：{使用言語}」を出力
	public void displayinfo() {
		System.out.println("「｛"+getEmployeeName()+"｝:｛"+getDepartmentName()+"｝　使用言語：｛"+lang+"}」");	
	}	
}
