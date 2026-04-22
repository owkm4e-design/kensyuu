package chapter5.program1;

public class HumanResource extends Employee {
	//人事のコンストラクタ⇒アクセス時にインスタンスのリスト追加
	public HumanResource(BT bt, String name) {
		super(bt, name, "人事");
		bt.createEmp("人事", "人事", name, null);
	}
	//面接
	public void interview(BT bt,String result,String targetDept,String targetName,String lang) {
		if(result.equals("採用")) {
			System.out.println("面接を行い、結果は採用だった");
			bt.createEmp("人事", targetDept, targetName, lang);
		}else {
			System.out.println("面接を行い、結果は不採用だった");
		}
	}
	
	//給与計算
	public int salary() {
		int r=200000;
		return r;
	}
	//情報表示
	@Override
	public void displayinfo() {
		System.out.println("「" + name + ":" + Dept + "」");

	}

}
