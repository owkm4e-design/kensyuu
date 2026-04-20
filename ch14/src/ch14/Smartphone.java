package ch14;

public class Smartphone {
	String modelName;
	String os;

	public String toString() {
		return this.modelName + "[" + this.os + "]";
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Smartphone sp) {
			if (this.modelName.equals(sp.modelName) && this.os.equals(sp.os)) {
				return true;
			}
		}
		return false;

	}

}
