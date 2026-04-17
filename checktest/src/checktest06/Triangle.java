package checktest06;

public class Triangle extends Polygon {
	private Point p1;
	private Point p2;
	private Point p3;

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		this.p3 = new Point(x3, y3);
		setAngle(3);
	}

	public void draw() {
		System.out.println("[三角形を描画] 点１" + p1 + "から点２" + p2 + "、点３" + p3 + "の三角形");
	}

	public double getPerimeter() {
		double dx1 = p2.getX() - p1.getX();
		double dy1 = p2.getY() - p1.getY();
		double z1 = Math.sqrt(Math.pow(dx1, 2) + Math.pow(dy1, 2));

		double dx2 = p3.getX() - p2.getX();
		double dy2 = p3.getY() - p2.getY();
		double z2 = Math.sqrt(Math.pow(dx2, 2) + Math.pow(dy2, 2));

		double dx3 = p1.getX() - p3.getX();
		double dy3 = p1.getY() - p3.getY();
		double z3 = Math.sqrt(Math.pow(dx3, 2) + Math.pow(dy3, 2));

		return z1 + z2 + z3;

	}

}
