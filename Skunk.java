package animals;
public class Skunk extends Animals {
	public Skunk(int energyLevel) {
		super(energyLevel);
	}
	public void move() {
		System.out.println("The skunk moved");
		energyLevel -= 10;
	}
	public void flee() {
		System.out.println("The skunk fled");
		energyLevel -= 10;
	}
	public void run() {
		System.out.println("The skunk run");
		energyLevel -= 10;
	}
}