package ch13;

public class Wand {
	private String name;//杖の名前
	private double power;//杖の魔力

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 3) {
			throw new IllegalArgumentException("杖の名前が短すぎる。3文字以上で入力してください。");
		}
		this.name = name;
	}

	public double getPower() {
		return this.power;
	}

	public void setPower(double power) {
		if (power <= 0.5 || power >= 100.0) {
			throw new IllegalArgumentException("増幅率の数値に異常があります。");
		}
		this.power = power;
	}
}
