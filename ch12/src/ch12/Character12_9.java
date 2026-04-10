package ch12;

public abstract class Character12_9 implements Life {
	String name;
	int hp;

	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}

	public abstract void attack(Monster12_9 m);
}
