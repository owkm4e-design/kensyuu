package ch12;

public class Main12 {

	public static void main(String[] args) {
		Y[] z = new Y[1];
		z[0] = new A();
		z[1] = new B();
		for (Y y : z) {
			y.b();
		}

	}

}
