package animals;
public class Animals {
    protected int energyLevel = 50;
    
    public int display(){
        System.out.println("Energy level: " + energyLevel);
        return energyLevel;
    }
    public Animals(int energyLevel){
        this.energyLevel = energyLevel;
    }   
}
