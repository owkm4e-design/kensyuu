package ch12;

public class Main12_10 {

	public static void main(String[] args) {
		Monster12_9[] monsters = new Monster12_9[3];
		monsters[0] = new Slime();
		monsters[1] = new Goblin();
		monsters[2] = new DeathBat();
		for (Monster12_9 m : monsters) {
			m.run();
		}
	}

}
