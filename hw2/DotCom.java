/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */

package hw2;

import java.util.ArrayList;

public class DotCom {
    private int HaedLocation;
    private String name;
    private int size;
    private ArrayList<Integer> survivingCells;
    private boolean northSouth = false;
    private int hitRange;
    private String hitShout;
    private GameMap map;

    public void setLocation(int loc) { HaedLocation = loc; }

    public ArrayList<String> getCells() {
        ArrayList<String> cells = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (northSouth) {
                cells.add(
                    map.indexToLocation(HaedLocation + map.xyToIndex(0, i)));
            } else {
                cells.add(
                    map.indexToLocation(HaedLocation + map.xyToIndex(i, 0)));
            }
        }
        return cells;
    }

    private void hitMove() {
        ArrayList<Integer> destination = new ArrayList<Integer>();
        // gen all destination
        for (int i = -hitRange; i <= hitRange; i++) {
            if (i != 0) {
                // use x or y axis
                if (northSouth) {
                    destination.add(HaedLocation + map.xyToIndex(0, i));
                } else {
                    destination.add(HaedLocation + map.xyToIndex(i, 0));
                }
            }
        }

        // check and remove can't move destination
        map.updateCollisionMap();

        // move
        if (!destination.isEmpty()) {

            // setLocation();
        }
    }

    public DotCom(String nameStr, int num) {
        size = num;
        name = nameStr;
        hitRange = 0;
        hitShout = "";
    }

    public String checkYourself(String userInput) {
        String result = "miss";

        int index = map.locToIndex(userInput);
        if (index >= 0) {
            hitMove();
            survivingCells.remove(index);
            if (survivingCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }

    public void setName(String string) { name = string; }

    public void setHitShout(String msg) { hitShout = msg; }

    public void setHitMoveRange(int range) { hitRange = range; }

    public void setMap(GameMap getMap) { map = getMap; }
}
