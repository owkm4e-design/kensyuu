package chapter5.program1;

public abstract class Employee {
	String name;//従業員の名前
	String Dept;//従業員の部署
	
	//従業員のコンストラクタ
	public Employee(BT bt,String name,String Dept) {
		this.name=name;
		this.Dept=Dept;
		
		/*
		bt.createEmp("人事", Dept, name, );//String Dept, String targetDept, String targetName, String lang
		*/
	}
	//abstract 情報表示
	public abstract void displayinfo() ;
}
