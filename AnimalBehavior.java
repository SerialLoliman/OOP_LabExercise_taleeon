package animals;
public class AnimalBehavior {
    public static void main(String[] args) {
        Snake snake = new Snake(100);
        Skunk skunk = new Skunk(100);
        Snail snail = new Snail(100);
        snake.move();
        snake.bite();
        snake.eat();
        System.out.println();
        skunk.move();
        skunk.flee();
        skunk.run();
        System.out.println();
        snail.move();
        snail.roll();
        snail.hide();
    }
}