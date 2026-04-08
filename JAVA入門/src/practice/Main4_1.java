package practice;

public class Main4_1 {

	public static void main(String[] args) {

		double[] weights = new double[5];
		boolean[] answers = new boolean[3];
		String[] names = new String[3];

		int[] moneyList = { 121902, 8302, 55100 };
		for (int i = 0; i < moneyList.length; i++) {
			System.out.println(moneyList[i]);
		}
		for (int i : moneyList) {
			System.out.println(i);
		}
		int[] numbers = { 3, 4, 9 };
		System.out.println("1桁の数字を入力してください");
		int input = new java.util.Scanner(System.in).nextInt();
		for (int n : numbers) {
			if (n == input) {
				System.out.println("アタリ！");
			}
		}
	}

}
