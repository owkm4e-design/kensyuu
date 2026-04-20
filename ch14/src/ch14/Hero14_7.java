package ch14;

public class Hero14_7 {
	String name;
	int hp;

	public String toString() {
		return "名前：" + this.name + "／HP:" + this.hp;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Hero14_7 h) {
			if (this.name.equals(h.name)) {
				return true;
			}
		}
		return false;
	}
}
