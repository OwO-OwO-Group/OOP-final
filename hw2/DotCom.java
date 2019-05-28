/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */

package hw2;

import java.util.ArrayList;

public class DotCom {
    private int headLoc;
    private String name;
    private int size;
    private ArrayList<Integer> survivingCells = new ArrayList<Integer>();
    private boolean northSouth = false;
    private int hitRange;
    private String hitShout;
    private GameMap map;

    public void setLocation(int loc) { headLoc = loc; }

    public int getLocation() { return headLoc; }
    public int getSize() { return size; }
    public boolean isNorthSouth() { return northSouth; }
    public void setNorthSouth(boolean is) { northSouth = is; }

    public ArrayList<String> getCells() {
        ArrayList<String> cells = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (northSouth) {
                cells.add(map.indexToLocation(headLoc + map.xyToIndex(0, i)));
            } else {
                cells.add(map.indexToLocation(headLoc + map.xyToIndex(i, 0)));
            }
        }
        // System.out.println(cells + " loc:" + headLoc);
        return cells;
    }

    private void hitMove() {
        ArrayList<Integer> destination = new ArrayList<Integer>();
        // gen all destination
        for (int i = -hitRange; i <= hitRange; i++) {
            if (i != 0) {
                // use x or y axis
                int index;
                if (northSouth) {
                    index = headLoc + map.xyToIndex(0, i);
                } else {
                    index = headLoc + map.xyToIndex(i, 0);
                }

                // System.out.println(index);
                // check can move destination
                if (map.canPut(index, size, northSouth, this)) {
                    destination.add(index);
                }
            }
        }

        // move
        if (!destination.isEmpty()) {
            setLocation(destination.get(
                (int)(Math.random() * (destination.size() - 1))));
        }
    }

    public DotCom(String nameStr, int num) {
        size = num;
        for (int i = 0; i < size; i++)
            survivingCells.add(i);
        name = nameStr;
        hitRange = 0;
        hitShout = "";
    }

    public String checkYourself(String userInput) {
        String result = "miss";

        ArrayList<String> cells = new ArrayList<String>();
        for (int cell : survivingCells) {
            if (northSouth) {
                cells.add(
                    map.indexToLocation(headLoc + map.xyToIndex(0, cell)));
            } else {
                cells.add(
                    map.indexToLocation(headLoc + map.xyToIndex(cell, 0)));
            }
        }

        int index = cells.indexOf(userInput);
        // System.out.println(cells);
        if (index != -1) {
            hitMove();
            // System.out.println(index);
            survivingCells.remove(index);
            if (survivingCells.isEmpty()) {
                result = "kill";
            } else {
                System.out.println(hitShout);
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
