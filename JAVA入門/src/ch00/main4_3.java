package ch00;

public class main4_3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	
		
		int[]scores={20,30,40,50,80};
		
		int count=0;
		for(int i=0;i<scores.length;i++) {
			if(scores[i]>=50) {
				count++;
			}
		}
		System.out.println("50点以上の科目の数は："+count);
		
		int[]seq=new int[10];
		
		
		for(int i=0;i<seq.length;i++) {
			seq[i]=new java.util.Random().nextInt(4);
		}
		
		
		for(int i=0;i<seq.length;i++) {
			switch(seq[i]) {
			case 0->{
				System.out.print("A");
			}
			case 1->{
				System.out.print("T");
			}
			case 2->{
				System.out.print("G");
			}
			case 3->{
				System.out.print("C");
			}
			}
		}
			
	}
}


	
