package ch14;

public class Main14_7 {

	public static void main(String[] args) {
		Hero14_7 h1 = new Hero14_7();
		h1.name = "ミナト";
		h1.hp = 100;

		Hero14_7 h2 = new Hero14_7();
		h2.name = "ミナト";
		h2.hp = 100;
		if (h1.equals(h2) == true) {
			System.out.println("同じ内容です");
		} else {
			System.out.println("違う内容です");
		}

	}

}
