// import java.util.Math;

public class Dice {
    private final int numSides;
    private int sideUp;

    public Dice(){
        this.numSides = 6;
    }

    public Dice(int numSides){
        this.numSides = numSides;
    }

    public int getSideUp() {
        return sideUp;
    }

    public int getNumSides() {
        return numSides;
    }

    public void roll() {
        sideUp = (int) (Math.random() * numSides) + 1;
    }
}