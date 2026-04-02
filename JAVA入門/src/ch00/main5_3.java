package ch00;

public class main5_3 {
	public static int add(int x,int y) {
		int ans=x+y;
		return ans;
				
	}
	

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int ans=add(100,10);
		System.out.println("100+10="+ans);
		System.out.println(add(add(10,20),add(30,40)));
		
		

	}

}
