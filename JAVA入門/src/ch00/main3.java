package ch00;

public class main3 {
	public static void main(String[] args) {
		boolean tenki=true;
		if(tenki==true) {
			System.out.println("洗濯をします");
			System.out.println("散歩に行きます");
		}else {
			System.out.println("映画を見ます");
		}
		
		System.out.println("あなたの運勢を占います");
		int fortune=new java.util.Random().nextInt(5)+1;
		switch(fortune) {
		 case 1,2->{
			 System.out.println("いいね");
		}
		 case 3->{
			 System.out.println("普通です");
		 }
		 case 4,5->{
			 System.out.println("うーん…");
		 }
		}
		
		for(int i=0;i<10;i++) {
			System.out.println("こんにちは");
				
		}
		
		for(int j=0;j<3;j++) {
			System.out.println("現在"+(j+1)+"週目→");
		}
		
		
	}


}
	
	
