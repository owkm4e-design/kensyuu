package ch12;

public class Main12 {

	public static void main(String[] args) {
		Y[] array = new Y[1]; //要素２の箱を用意
		array[0] = new A();//[0]にはAクラス
		array[1] = new B();//[1]にはBクラス
		//
		for (Y y : array) {
			y.b();
		}

	}

}
