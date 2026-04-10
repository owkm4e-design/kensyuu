package ch11;

public class Book extends TangibleAsset {

	String isbn;

	//コンストラクタ
	public Book(String name, int price, String color, double weight, String isbn) {
		super(name, price, color, weight);
		this.isbn = isbn;
	}

	//メソッド

	public String getIsbn() {
		return this.isbn;
	}

	@Override
	public double setweight(double weight) {
		this.weight = weight;
		return this.weight;
	}

	@Override
	public double getweight() {
		// TODO 自動生成されたメソッド・スタブ
		return this.weight;
	}

}
