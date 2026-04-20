package ch14;

public class IDCard {
	int idNumber;
	String ownerName;

	public String toString() {
		return "名前：" + this.ownerName + "／社員番号:" + this.idNumber;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof IDCard idc) {
			if (this.idNumber == (idc.idNumber)) {
				return true;
			}
		}
		return false;
	}

}
