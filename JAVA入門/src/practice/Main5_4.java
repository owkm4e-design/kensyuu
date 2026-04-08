package practice;

public class Main5_4 {

	public static void main(String[] args) {
		// bottom = 10.0;
		//height = 5.0;
		//radius = 5.0;

		double triangleArea = calcTriangleArea(10.0, 5.0);
		System.out.println("三角形の面積は" + triangleArea + "㎠");
		double circleArea = calcCircleArea(5.0);
		System.out.println("円の面積は" + circleArea + "㎠");
	}

	public static double calcTriangleArea(double bottom, double height) {
		double area = (bottom * height) / 2;
		return area;

	}

	public static double calcCircleArea(double radius) {
		double area = radius * radius * 3.14;
		return area;

	}

}
