/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */
package hw2;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    
    public void setLocationCells(ArrayList<String> loc)
    {
        locationCells = loc;
    private int hitRange;
    private String hitShout;

    }

    public String checkYourself(String userInput) {
        String result = "miss";

        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }

    private String name;
    public void setName(String string) {
        name = string;
    }

    public void setHitShout(String msg){
        hitShout = msg;
    }

    public void setHitMoveRange(int range){
        hitRange = range;
    }
}
