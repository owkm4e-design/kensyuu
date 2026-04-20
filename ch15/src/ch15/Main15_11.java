package ch15;

import java.util.Date;

public class Main15_11 {

	public static void main(String[] args) {
		Date now = new Date();//現在の時刻を取得
		System.out.println(now);
		System.out.println(now.getTime());
		Date past = new Date(1694984000000L);
		System.out.println(past);
		// TODO 自動生成されたメソッド・スタブ

	}

}
