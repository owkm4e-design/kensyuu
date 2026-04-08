package practice;

public class Main5 {

	public static void main(String[] args) {
		introduceOneself();
		String title = "メールのタイトル";
		String address = "メールの宛先アドレス";
		String text = "メールの本文";
		email(title, address, text);
		email(address, text);

	}

	public static void introduceOneself() {
		String name = "湊雄輔";
		int age = 22;
		double height = 169.9;
		char zodiac = '辰';
		System.out.println("私の名前は" + name + "です。");
		System.out.println("歳は" + age + "歳です。");
		System.out.println("身長は" + height + "㎝です。");
		System.out.println("十二支は" + zodiac + "です。");
	}

	public static void email(String title, String address, String text) {
		System.out.println(address + "に、以下のメールを送信しました");
		System.out.println("件名：" + title);
		System.out.println("本文：" + text);

	}

	public static void email(String address, String text) {
		System.out.println(address + "に、以下のメールを送信しました");
		System.out.println("件名：無題");
		System.out.println("本文：" + text);
	}

}
