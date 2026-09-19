
public class Farkle {
    public static void main(String[] args) {
        System.out.println("Farkle Rolling and Scoring Java Example");
        Hand myHand = new Hand(6, 6);  
        System.out.println(myHand.getListOfSides());
        System.out.println(myHand.getListOfSidesSorted());
    }
}