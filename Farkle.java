public class Farkle {
    public static void main(String[] args) {
        Dice d1 = new Dice(20);
        for (int i = 0; i < 100; i++) {
            d1.roll();
            // System.out.println(d1.getSideUp());
            if (d1.getSideUp() < 1) {
                System.out.println("A SIDE IS ZERO");
                System.out.println(d1.getSideUp());
            }
            if (d1.getSideUp() > d1.getNumSides()) {
                System.out.println("A SIDE IS HIGHER THAN IT SHOULD BE");
                System.out.println(d1.getSideUp());
            }
        }        
    }
}