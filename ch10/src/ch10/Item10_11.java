package ch10;

public class Item10_11 {
	String name;
	int price;

	public Item10_11(String name) {//引数１つのコンストラクタ
		this.name = name;
		this.price = 0;
	}

	public Item10_11(String name, int price) {//引数２つのコンストラクタ
		this.name = name;
		this.price = price;
	}

}
