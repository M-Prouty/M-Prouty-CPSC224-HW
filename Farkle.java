import java.util.*;

public class Farkle {
    public static void main(String[] args) {
        Dice d1 = new Dice(2);
        List<Integer> listOfRolls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            d1.roll();
            int side = d1.getSideUp();
            listOfRolls.add(side);
            if (d1.getSideUp() < 1) {
                System.out.println("A SIDE IS ZERO");
                System.out.println(side);
            }
            if (d1.getSideUp() > d1.getNumSides()) {
                System.out.println("A SIDE IS HIGHER THAN IT SHOULD BE");
                System.out.println(side);
            }
        }     
        System.out.println(listOfRolls);   
    }
}