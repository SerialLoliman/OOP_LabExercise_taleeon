package animals;
public class Snail extends Animals {
	public Snail(int energyLevel) {
		super(energyLevel);
	}
	public void move() {
		System.out.println("The snail moved slowly");
		energyLevel -= 10;
	}
	public void roll() {
		System.out.println("The snail rolled away");
		energyLevel -= 10;
	}
	public void hide() {
		System.out.println("The snail hid in its shell");
		energyLevel += 5;
	}
}