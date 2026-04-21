package ch15;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main15_16 {

	public static void main(String[] args) {
		// 文字列からLocalDateを生成
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate ldate = LocalDate.parse("2026/04/21", fmt);

		//1000日後を計算する
		LocalDate ldatep = ldate.plusDays(1000);
		String str = ldatep.format(fmt);
		System.out.println("1000日後は" + str);

		//現在日付との比較
		LocalDate now = LocalDate.now();
		if (now.isAfter(ldatep)) {
			System.out.println("本日は、その日より未来です。");
		}
	}
}