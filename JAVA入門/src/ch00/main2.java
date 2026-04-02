package ch00;

public class main2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		double d =8.5/2;
		long l =5+2L;
		System.out.println(d);
		System.out.println(l);
		
		int a=5;
		int b=3;
		int m=Math.max(a, b);
		System.out.println("比較実験："+a+"と"+b+"とで大きいほうは…"+m);
		
		int r=new java.util.Random().nextInt(90);
		System.out.println("あなたはたぶん、"+r+"歳ですね？");
		
		System.out.println("あなたの名前を入力してください。");
		String name=new java.util.Scanner(System.in).nextLine();
		System.out.println("あなたの年齢を入力してください。");
		int age=new java.util.Scanner(System.in).nextInt();
		System.out.println("ようこそ、"+age+"歳の"+name+"さん");
		
	}

}
