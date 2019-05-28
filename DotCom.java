/*
 * 10627108 ���屶 10612150 �L���� ��T�G��
 * UTF-8
 */
package hw2;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    
    public void setLocationCells(ArrayList<String> loc)
    {
        locationCells = loc;
    private String name;
    private int size;
    private int hitRange;
    private String hitShout;


    Public Ship(String nameStr, int num){
        size = num;
        name = nameStr;
        hitRange = 0;
        hitShout = "";
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
