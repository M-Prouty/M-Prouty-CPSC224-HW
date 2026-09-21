import java.util.*;

public class Hand {
    public List<Dice> listOfDice = new ArrayList<>();

    public Hand(int numDice, int numSides) {
        // List<Dice> listOfDice = new ArrayList<>();
        for (int i = 0; i < numDice; i++) {
            Dice d = new Dice(numSides);
            listOfDice.add(d);
            // System.out.println(d.getSideUp());
        }
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
}