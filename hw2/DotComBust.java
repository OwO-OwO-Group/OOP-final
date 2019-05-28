/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */
package hw2;

import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private GameMap map = new GameMap();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new LargeShip("Pets.com");
        DotCom two = new MidShip("eToys.com");
        DotCom three = new SmallShip("Go2.com");

        map.placeShip(one);
        map.placeShip(two);
        map.placeShip(three);
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println(
            "Try to sink them all in the fewest number of guesses");
    }

    private void startPlaying() {
        while (!map.isEmpty()) {

            // map.display();
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        ArrayList<DotCom> dotComsList = map.getShipList();

        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println(
            "All Dot Coms are dead!  Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses +
                               " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
