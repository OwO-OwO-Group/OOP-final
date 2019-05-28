/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */

package hw2;

import java.util.ArrayList;

public class DotCom {
    private int Haedlocation;
    private String name;
    private int size;
    private ArrayList<Integer> survivingCells;
    private boolean northSouth = false;
    private int hitRange;
    private String hitShout;

    public void setLocation(int loc) {
        Haedlocation = loc;
    }

    private void hitMove() {
        ArrayList<Integer> destination;
        // gen all destination
        // check and remove can't move destination

        // move
        // setLocation();
    }

    public DotCom(String nameStr, int num) {
        size = num;
        name = nameStr;
        hitRange = 0;
        hitShout = "";
    }

    public String checkYourself(String userInput) {
        String result = "miss";

        int index = 0; // = locationCells.indexOf(userInput);
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

    public void setName(String string) {
        name = string;
    }

    public void setHitShout(String msg) {
        hitShout = msg;
    }

    public void setHitMoveRange(int range) {
        hitRange = range;
    }
}
