
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


        // for (int i = 0; i < 100; i++) {
        //     Hand myHand1 = new Hand(6, 6);  
        //     if (myHand1.isFarkle() == true) {
        //         if(!(myHand1.calcNumEachSide().contains(1))) {
        //             System.out.println("You farkled but weren't supposed to :(" + myHand1.getListOfSidesSorted());
        //         }
        //     }
        // }
    }
}