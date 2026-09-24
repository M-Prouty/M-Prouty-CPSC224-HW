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

    public Hand(Dice die1, Dice die2, Dice die3, Dice die4, Dice die5, Dice die6) {
        this.listOfDice = List.of(die1, die2, die3, die4, die5, die6);
    }

    public Hand(List<Dice> list) {
        this.listOfDice = list;
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
        for (int _ : myHandSides) {
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
            List<Integer> eSS = this.getListOfSidesSorted();
            List<Integer> five = List.of(5);
            List<Integer> one = List.of(1);
            if(nES.contains(6)) {
                int numSix = nES.indexOf(6) + 1;
                List<Integer> numSixList = List.of(numSix, numSix, numSix, numSix, numSix, numSix);
                options.add(numSixList);
            }
            else if (this.calcNumEachSide().contains(5)) {
                int numFive = nES.indexOf(5) + 1;
                List<Integer> numFiveList = List.of(numFive, numFive, numFive, numFive, numFive);
                options.add(numFiveList);
                if(eSS.contains(1) && numFive != 1) {
                    options.add(one);
                }
                if(eSS.contains(5) && numFive != 5) {
                    options.add(five);
                }
            }
            else if (this.calcNumEachSide().contains(4)) {
                int numFour = nES.indexOf(4) + 1;
                List<Integer> numFourList = List.of(numFour, numFour, numFour, numFour);
                options.add(numFourList);
                if(nES.contains(2)) {
                    if (eSS.contains(1) && numFour != 1) {
                        options.add(one);
                        options.add(one);
                    }
                    else if (eSS.contains(5) && numFour != 5) {
                        options.add(five);
                        options.add(five);
                    }
                }
                else {
                    if(eSS.contains(1) && numFour != 1) {
                        options.add(one);
                    }
                    else if (eSS.contains(5) && numFour != 5) {
                        options.add(five);
                    }
                }
            }
            else if (this.calcNumEachSide().contains(3)) {
                int tripleCount = 0;
                int triple1 = 0;
                int triple2 = 0;
                for (int i = 0; i < 6; i++) {
                    if (nES.get(i) == 3) {
                        tripleCount++;
                        if(triple1 == 0) {
                            triple1 = i + 1;
                        }
                        else if (triple2 == 0) {
                            triple2 = i + 1;
                        }
                    }
                }
                if (tripleCount == 2) {
                    List<Integer> numThreeList1 = List.of(triple1, triple1, triple1);
                    List<Integer> numThreeList2 = List.of(triple2, triple2, triple2);
                    options.add(numThreeList1);
                    options.add(numThreeList2);
                }
                else {
                    List<Integer> numThreeList = List.of(triple1, triple1, triple1);
                    options.add(numThreeList);
                    if(nES.contains(2)) {
                        if (nES.get(0) == 2) {
                            options.add(one);
                            options.add(one);
                        }
                        if (nES.get(4) == 2) {
                            options.add(five);
                            options.add(five);
                        }
                        }
                    if (nES.contains(1)) {
                        if(nES.get(0) == 1) {
                            options.add(one);
                        }
                        if(nES.get(4) == 1) {
                            options.add(five);
                        }
                    }
                }
            }
            else if (this.calcNumEachSide().contains(2)) {
                int pairCount = 0;
                int pair1 = 0;
                int pair2 = 0;
                int pair3 = 0;
                for(int i = 0; i < 6; i++) {
                    if(nES.get(i) == 2) {
                        pairCount++;
                        if(pair1 == 0) {
                            pair1 = i + 1;
                        }
                        else if (pair2 == 0) {
                            pair2 = i + 1;
                        }
                        else if (pair3 == 0) {
                            pair3 = i + 1;
                        }
                    }
                }
                if (pairCount == 3) {
                    List<Integer> pairsList = List.of(pair1, pair1, pair2, pair2, pair3, pair3);
                    options.add(pairsList);
                }
                else {
                    if(nES.get(0) > 0) {
                        for (int i = 0; i < nES.get(0); i++) {
                            options.add(one);
                        }
                    }
                    if(nES.get(4) > 0) {
                        for (int i = 0; i < nES.get(4); i++) {
                            options.add(five);
                        }
                    }
                }
            }
            else if (!(nES.contains(0))) {
                List<Integer> straight = List.of(1, 2, 3, 4, 5, 6);
                options.add(straight);
            }
            else if (nES.contains(1)) {
                for (int i = 0; i < nES.get(0); i++) {
                    options.add(one);
                }
            }
            else if (nES.contains(5)) {
                for (int i = 0; i < nES.get(4); i++) {
                    options.add(five);
                }
            }
        }
        return options;
    }

    public int calcPoints(List<List<Integer>> sidesToSave) {
        int sum = 0;
        for (List<Integer> elem : sidesToSave) {
            if (elem.size() == 1) {
                if(elem.get(0) == 1) {
                    sum += 100;
                }
                else {
                    sum += 50;
                }
            }
            if (elem.size() == 3) {
                if(elem.get(0) == 1) {
                    sum += 1000;
                }
                else {
                    sum += (elem.get(0) * 100);
                }
            }
            if (elem.size() == 4) {
                if(elem.get(0) == 1) {
                    sum += 1100;
                }
                else {
                    sum += (elem.get(0) * 100) * 2;
                }
            }
            if (elem.size() == 5) {
                if(elem.get(0) == 1) {
                    sum += 1200;
                }
                else {
                    sum += (elem.get(0) * 100) * 3;
                }
            }
            if (elem.size() == 6) {
                if(elem.get(0).equals(elem.get(1))) {
                    if(elem.get(0) == 1) {
                        sum += 1300;
                    }
                    else {
                        sum += (elem.get(0) * 100) * 4;
                    }
                }
                else {
                    sum += 1000;
                }
            }
        }
        return sum;
    }

    public String getSaveableString() {
        String saveableOptions = "";
        List<Character> alphabet = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
        List<List<Integer>> saveable = this.getSaveable();
        for(int i = 0; i < saveable.size(); i++) {
            saveableOptions += (alphabet.get(i)) + ". " + saveable.get(i) + "\n";
        }
        return saveableOptions;
    }

// returns the points scored
    public void turn() {
        this.rollAll();
        List<List<Integer>> savedDice = new ArrayList<>();
        List<String> alphabet = List.of("A", "B", "C", "D", "E");
        System.out.println("Here is your roll: " + this.getListOfSides());
        if(this.isFarkle()) {
            System.out.println("You farkled. You scored no points this round.");
        }
        else {
            System.out.println("Here are your options for dice to set aside: ");
            System.out.println(this.getSaveableString());
        }
        Scanner input = new Scanner(System.in);
        int answerCount = 0;
        System.out.println("Which group of dice would you like to keep? Please type only one letter.");
        String answer = input.nextLine().toUpperCase();
        answerCount++;
        savedDice.add(this.getSaveable().get(alphabet.indexOf(answer)));
        while(answerCount < this.getSaveable().size() && !(answer.equals("-1"))) {
            System.out.println("Would you like to save more? Enter a letter or -1 to stop. ");
            answer = input.nextLine().toUpperCase();
            answerCount++;
            if (!(answer.equals("-1"))) {
                savedDice.add(this.getSaveable().get(alphabet.indexOf(answer)));
            }
        }
        int points = this.calcPoints(savedDice);
        System.out.println("You earned " + points + " points!");
    }
} 