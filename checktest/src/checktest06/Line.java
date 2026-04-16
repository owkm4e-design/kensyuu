package checktest06;

public class Line implements Figure {
	private Point p1;//始点
	private Point p2;//終点

	public Line() {
		this.p1 = new Point(0, 0);
		this.p2 = new Point(0, 0);
	}

	public Line(int x1, int y1, int x2, int y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
	}

	public void draw() {
		System.out.println("[線を描画] 始点" + p1 + "から終点" + p2 + "まで");
	}

	public double getPerimeter() {
		//((x2-x1)^2+(y2-y1)^2)=z^2

		return Math.sqrt(Math.pow(x2 - x1) + Math.pow(y2 - y1));
	}

}
