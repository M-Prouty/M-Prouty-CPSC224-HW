public class Farkle {
    public static void main(String[] args) {
        System.out.println("Farkle Rolling and Scoring in Java");
        Hand myHand = new Hand(6, 6);  
        myHand.turn();
    }
}