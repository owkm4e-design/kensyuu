package practice;

public class Employee {
	private String name;
	private int age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
			System.out.println("マイナスの年齢は登録できません");
		} else {
			this.age = age;
		}

	}
}
