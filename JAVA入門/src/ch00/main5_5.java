package ch00;

public class main5_5 {
	public static void incArray(int[]array) {
		for(int i=0;i<array.length;i++) {
			array[i]++;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[]array= {1,2,3};
		incArray(array);
		for(int i:array) {
			System.out.println(i);
		}

	}

}
