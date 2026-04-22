package chapter5.program1;

public class Sales extends Employee {

	public Sales(BT bt, String name) {
		super(bt, name, "営業");
		bt.createEmp("人事", "営業", name, null);
	}

	//週報返信
	public void reply() {
		System.out.println("週報の返信をした");
	}

	//面談組む
	public void schedule(Engineer eng) {
		System.out.println(eng.name + "の面談を組んだ");
	}

	//打ち合わせ
	public void meeting() {
		System.out.println("新規の打ち合わせをした");
	}

	//情報表示
	@Override
	public void displayinfo() {
		System.out.println("「" + name + ":" + Dept + "」");

	}

}
