package ch00;

public class main4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int sansu=20;
		int kokugo=30;
		int rika=40;
		int eigo=50;
		int syakai=80;
		
		int sum=sansu+kokugo+rika+syakai+eigo;
		
		int avg=sum/5;
		System.out.println("合計点:"+sum);
		System.out.println("平均点:"+avg);
		
		int[] scores;
		scores=new int[5];
		int num=scores.length;
		System.out.println("要素の数："+num);
		
		scores[1]=30;
		System.out.println(scores[1]);
		
		
		
		

	}

}
