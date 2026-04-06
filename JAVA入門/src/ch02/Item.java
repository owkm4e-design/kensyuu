package ch02;

public class Item {
	String name;
	int price;

	//引数が１つ（nameのみ）
	public Item(String name) {
		this.name = name;
		this.price = 0;
	}

	//引数が２つ（nameとprice）
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
}
//引数が１つor２つのものしかItem内には存在しない
//引数がない呼び出しは不可！
