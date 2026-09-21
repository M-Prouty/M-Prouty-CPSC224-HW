
public class Farkle {
    public static void main(String[] args) {
        System.out.println("Farkle Rolling and Scoring in Java");
        Hand myHand = new Hand(6, 6);  
        System.out.println("Sorted list of sides: " + myHand.getListOfSidesSorted());
        if (myHand.isFarkle() == true) {
            System.out.println("Sorry, you farkled.");
        }
        else {
            System.out.println("You didn't farkle!");
        }
    }
}