package checktest06;

public class Circle extends Shape {
	private Point center;//円の中心
	private int radius;//円の半径

	public Circle() {
		this.center = new Point(0, 0);
		this.radius = 0;
	}

	public Circle(int x, int y, int r) {
		this.center = new Point(x, y);
		this.radius = r;
	}

	public void draw() {
		System.out.println("[円を描画] 中心点" + center + "から半径" + radius + "まで");

	}

	public double getPerimeter() {
		return Math.PI * (this.radius * 2);
	}

}
