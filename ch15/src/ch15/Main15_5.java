package ch15;

public class Main15_5 {

	public static void main(String[] args) {
	}

	public boolean isValidPlayerName(String name) {
		return name.matches("[A-Z][A-Z0-9]{7}");
	}

}
