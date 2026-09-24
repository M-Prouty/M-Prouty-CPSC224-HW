import java.util.*;

public class Farkle {
    public static void main(String[] args) {
        System.out.println("Farkle Rolling and Scoring in Java");
        Hand myHand = new Hand(6, 6);  
        List<Dice> allDice = myHand.getListOfDice();
        List<List<Dice>> savedDice = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myHand.turn();
        }

        // Dice die1 = new Dice();
        // Dice die2 = new Dice();
        // Dice die3 = new Dice();
        // Dice die4 = new Dice();
        // Dice die5 = new Dice();
        // Dice die6 = new Dice();
        // List<Dice> list = List.of(die1, die2, die3, die4, die5, die6);
        // Hand myHandTest = new Hand(list);
        // die1.setSideUp(1);
        // die2.setSideUp(2);
        // die3.setSideUp(2);
        // die4.setSideUp(2);
        // die5.setSideUp(5);
        // die6.setSideUp(6);
        // System.out.println(myHandTest.getListOfSidesSorted());
        // System.out.println(myHandTest.getSaveable());
        // System.out.println(myHandTest.calcPoints(myHandTest.getSaveable()));
    }
}