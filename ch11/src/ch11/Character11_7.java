package ch11;

public class Character11_7 {
	String name;
	int hp;

	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}

	public abstract void attack(Matango m);
	
}
