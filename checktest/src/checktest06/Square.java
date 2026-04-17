package checktest06;

public class Square extends Rectangle {

	public Square(int x, int y, int width) {
		super(x, y, width, width);
	}

	public void draw() {
		System.out.println("[正方形を描画] 点" + p + "を基準として幅・高さ" + width + "の正方形");
	}

}
