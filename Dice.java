// import java.util.Math;

public class Dice {
    private int numSides;
    private int sideUp;

    public Dice(){
        this.numSides = 6;
    }

    public Dice(int numSides){
        if (numSides < 1) {
            System.out.println("Invalid number of sides.");
            System.out.println("Sides set to 2.");
            this.numSides = 2;
        }
        else {
            this.numSides = numSides;
        }
    }

    public int getSideUp() {
        return sideUp;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int newNumSides) {
        this.numSides = newNumSides;
    }

    public void roll() {
        sideUp = (int) (Math.random() * numSides) + 1;
    }
}