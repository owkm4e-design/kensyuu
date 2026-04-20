package program1;

public class Engineer extends Employee {
	//使用言語
	private String language;

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
