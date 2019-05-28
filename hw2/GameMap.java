/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */

package hw2;

import java.util.*;

public class GameMap {
    private static final String alphabet = "abcdefg";
    private ArrayList<DotCom> shipList = new ArrayList<DotCom>();
    private int gridX = 7, gridY = 7;
    private boolean grid[] = new boolean[gridX * gridY];

    public void updateCollisionMap() {
        // clean map
        Arrays.fill(grid, false);

        // print all ship
        for (DotCom ship : shipList) {
            for (String cell : ship.getCells()) {
                grid[locToIndex(cell)] = true;
            }
        }
    }

    public boolean canPut(int loc, int size, boolean s) {}

    public boolean isOutOfRange(ArrayList<String> cells) {
        for (String cell : cells) {
            int index = locToIndex(cell);
            if (index < 0 || gridX * gridY <= index)
                return true;
        }

        return false;
    }

    public boolean collisionMap(DotCom a, DotCom b) {
        ArrayList<String> cellsA = a.getCells();
        ArrayList<String> cellsB = b.getCells();
        cellsA.retainAll(cellsB);

        return !cellsA.isEmpty();
    }

    public void placeShip(DotCom ship) {
        updateCollisionMap();
        shipList.add(ship);
        ship.setMap(this);

        // find random loaction
    }

    public int locToIndex(String loc) {
        return xyToIndex(loc.charAt(0) - 'a', loc.charAt(1) - '0');
    }

    public String indexToLocation(int index) {
        int x = index % gridX;
        int y = index / gridX;
        return "" + (x + 'a') + (y + '0');
    }

    public int xyToIndex(int x, int y) { return x + y * gridX; }

    public boolean isEmpty() { return shipList.isEmpty(); }
}
