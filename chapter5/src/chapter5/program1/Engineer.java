package chapter5.program1;

public class Engineer extends Employee {
	String lang;

	public Engineer(BT bt, String name,String lang) {
		super(bt, name, "エンジニア");
		this.lang=lang;
		bt.createEmp("人事", "エンジニア", name, lang);
	}
	//開発実施
	public void develop() {
		System.out.println(lang+"で開発を行った");
	}

	//情報表示
	@Override
	public void displayinfo() {
		System.out.println("「" + name + ":" + Dept + " 使用言語："+lang+"」");

	}

}
