package ch02;

public class Weapon extends Item {
	//コンストラクタが定義されていない場合、
	//暗黙的にデフォルトコンストラクタが定義される
	public Weapon() {
		//Itemには引数１or２つのものしかない
		//super();に与える引数の数と型によって指定できる
		super("ななしの剣");
	}
}
