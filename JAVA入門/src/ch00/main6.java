package ch00;

public class main6 {
	public class Calc{
		public static void main(String[] args) {
			// TODO 自動生成されたメソッド・スタブ
			int a=10;int b=2;
			int total=CalcLogic.tasu(a,b);
			int delta=CalcLogic.hiku(a,b);
			System.out.println("足すと"+total+"、引くと"+delta);
	}
	public class CalcLogic{
		public static int tasu(int a,int b) {
			return(a+b);
		}
		public static int hiku(int a,int b) {
			return(a-b);
		}
	}
		//

	}

}
