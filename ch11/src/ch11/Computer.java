package ch11;

public class Computer extends TangibleAsset {

	String makerName;

	//コンストラクタ
	public Computer(String name, int price, String color, double weight, String makerName) {
		super(name, price, color, weight);
		this.makerName = makerName;
	}
	//メソッド

	public String getMakerName() {
		return this.makerName;
	}

	@Override
	public double getweight() {
		return this.weight;
	}

	@Override
	public double setweight(double weight) {
		this.weight = weight;
		return this.weight;
	}
}
