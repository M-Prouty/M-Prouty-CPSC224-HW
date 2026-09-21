
public class Farkle {
    public static void main(String[] args) {
        System.out.println("Farkle Rolling and Scoring Java Example");
        Hand myHand = new Hand(6, 6);  
        System.out.println("Unsorted list of sides: " + myHand.getListOfSides());
        System.out.println("Sorted list of sides    " + myHand.getListOfSidesSorted());
        System.out.println("Number of each side:    " + myHand.calcNumEachSide());
    }
}