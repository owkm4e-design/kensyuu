package checktest06;

public abstract class Polygon extends Shape {
	protected int angle;

	public int getInternalAngle() {
		return (this.angle - 2) * 180;
	}

	public int getAngle() {
		return this.angle;
	}

	public void setAngle(int angle) {
		if (angle < 3) {
			this.angle = 3;
		} else {
			this.angle = angle;
		}
	}

}
