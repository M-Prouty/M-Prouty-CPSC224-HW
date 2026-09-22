import java.util.*;

public class Hand {
    private List<Dice> listOfDice = new ArrayList<>();

    public Hand(int numDice, int numSides) {
        // List<Dice> listOfDice = new ArrayList<>();
        for (int i = 0; i < numDice; i++) {
            Dice d = new Dice(numSides);
            listOfDice.add(d);
            // System.out.println(d.getSideUp());
        }
    }

    public List<Dice> getListOfDice() {
        return this.listOfDice;
    }

    public List<Integer> getListOfSides() {
        List<Integer> sides = new ArrayList<>();
        for (int i = 0; i < listOfDice.size(); i++) {
            sides.add(listOfDice.get(i).getSideUp());
        }
        return sides;
    }

    public List<Integer> getListOfSidesSorted() {
        List<Integer> sides = getListOfSides();
        Collections.sort(sides);
        return sides;
    }

    public List<Integer> calcNumEachSide(){
        List<Integer> diceNumberCount = new ArrayList<>();
        List<Integer> myHandSides = this.getListOfSides();
        for (int i = 0; i < myHandSides.size(); i++) {
            diceNumberCount.add(0);
        }
        for (int i = 0; i < 6; i++) {
            int num = myHandSides.get(i);
            diceNumberCount.set(num - 1, diceNumberCount.get(num - 1) + 1);
        }
        return diceNumberCount;
    }

    public boolean isFarkle() {
        boolean farkle = true;
        List<Integer>sides = this.calcNumEachSide();
        // if there's more than zero occurances of 1 or 5, it is not a farkle
        if (sides.get(0) > 0 || sides.get(4) > 0) {
            farkle = false;
        }
        // if there's 3 or more of one number, it is not a farkle
        for(int i = 0; i < 6; i++) {
            if(sides.get(i) >= 3) {
                farkle = false;
            }
        }
        int pairCount = 0;
        for(int i = 1; i < 6; i++) {
            if(sides.get(i) == 2) {
                pairCount++;
            }
        }
        if(pairCount == 3) {
            farkle = false;
        }
        return farkle;
    }

    public void rollAll() {
        for (int i = 0; i < listOfDice.size(); i++) {
            listOfDice.get(i).roll();
        }
    }

    public List<List<Integer>> getSaveable() {
        List<List<Integer>> options = new ArrayList<>();
        if (this.isFarkle()) {
            assert true;
        }
        else {
            List<Integer> nES = this.calcNumEachSide();
            boolean straight = false;
            boolean threePairs = false;
            boolean triple = false;
            boolean fourOfAKind = false;
            boolean fiveOfAKind = false;
            boolean sixOfAKind = false;
            if(nES.contains(6)) {
                sixOfAKind = true;
                int numSix = nES.indexOf(6) + 1;
                List<Integer> numSixList = List.of(numSix, numSix, numSix, numSix, numSix, numSix);
                options.add(numSixList);
            }
            else if (this.calcNumEachSide().contains(5)) {
                fiveOfAKind = true;
                int numFive = nES.indexOf(5) + 1;
                List<Integer> numFiveList = List.of(numFive, numFive, numFive, numFive, numFive);
                options.add(numFiveList);
            }
            else if (this.calcNumEachSide().contains(4)) {
                fourOfAKind = true;
                int numFour = nES.indexOf(5) + 1;
                List<Integer> numFourList = List.of(numFour, numFour, numFour, numFour);
                options.add(numFourList);
            }
            else if (this.calcNumEachSide().contains(3)) {
                triple = true; // need to check if it's two triples
            }
            else if (this.calcNumEachSide().contains(2)) {
                // calc if it's three pairs
            }
            else {
                straight = true;
            }
        }
        return options;
    }

    public int calcPoints(List<Integer> listOfSides) {
        return 1;
    }

    public boolean turn() {
        this.rollAll();
        // System.out.println("Here is your roll: " + this.getListOfSides());
        if(this.isFarkle()) {
            // System.out.println("You farkled. You gained no points this turn.");
        }
        else {
            if (!this.getSaveable().isEmpty()) {
                // System.out.println("Here is your roll: " + this.getListOfSides());
                if(this.getSaveable().get(0).size() == 5) {
                    System.out.println("Here is your roll: " + this.getListOfSides());
                    System.out.println("Here are your options for dice to set aside: " + this.getSaveable());
                }
   
            }
        }
        return true;
    }
}