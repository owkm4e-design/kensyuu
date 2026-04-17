package practice;

public class Smartphone {
	private String model;
	private int battery;

	public Smartphone(String model) {
		this.model = model;
		this.battery = 100;
	}

	public void use(int amount) {
		if (amount < this.battery) {
			this.battery -= amount;
		}
	}

	public void showStatus() {
		System.out.println(model + "の現在の電池残量は" + this.battery + "%です");

	}

}
