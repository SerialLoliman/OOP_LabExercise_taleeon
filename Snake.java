package animals;
public class Snake extends Animals {
	public Snake(int energyLevel) {
		super(energyLevel);
	}
	public void move() {
		System.out.println("The snake moved");
		energyLevel -= 20;
	}
	public void bite() {
		System.out.println("The snake bit something");
		energyLevel -= 20;
	}
	public void eat() {
		System.out.println("The snake ate something");
		energyLevel += 10;
	}
}