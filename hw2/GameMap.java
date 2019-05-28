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

    public ArrayList<DotCom> getShipList() { return shipList; }

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

    public void updateCollisionMap(DotCom without) {
        // clean map
        Arrays.fill(grid, false);

        // print all ship
        for (DotCom ship : shipList) {
            if (ship == without)
                continue;
            for (String cell : ship.getCells()) {
                grid[locToIndex(cell)] = true;
            }
        }
    }

    public boolean canPut(int loc, int size, boolean northSouth,
                          DotCom without) {
        updateCollisionMap(without);
        for (int i = 0; i < size; i++) {
            int index;
            if (northSouth) {
                index = loc + xyToIndex(0, i);
            } else {
                index = loc + xyToIndex(i, 0);
            }

            if (isOutOfRange(index) || grid[index] == true)
                return false;
        }

        return true;
    }

    public boolean canPut(int loc, int size, boolean northSouth) {
        updateCollisionMap();
        for (int i = 0; i < size; i++) {
            int index;
            if (northSouth) {
                index = loc + xyToIndex(0, i);
            } else {
                index = loc + xyToIndex(i, 0);
            }

            if (isOutOfRange(index) || grid[index] == true)
                return false;
        }

        return true;
    }

    public boolean isOutOfRange(int index) {
        return index < 0 || gridX * gridY <= index;
    }

    public boolean isOutOfRange(ArrayList<String> cells) {
        for (String cell : cells) {
            int index = locToIndex(cell);
            if (isOutOfRange(index))
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
        ship.setMap(this);
        ship.setNorthSouth((int)(Math.random() * 2) == 1 ? true : false);
        // find random loaction
        ArrayList<Integer> destination = new ArrayList<Integer>();
        updateCollisionMap();
        for (int i = 0; i < gridX * gridY; i++) {
            if (grid[i] == false)
                destination.add(i);
        }

        while (!destination.isEmpty()) {
            int index = destination.get(
                (int)(Math.random() * (destination.size() - 1)));

            if (canPut(index, ship.getSize(), ship.isNorthSouth())) {

                ship.setLocation(index);

                shipList.add(ship);

                // System.out.println(index + " NS: " + ship.isNorthSouth());
                return;
            } else
                destination.remove(destination.indexOf(index));
        }
    }
    public void display() {
        updateCollisionMap();
        for (int y = 0; y < gridY; y++) {
            for (int x = 0; x < gridX; x++) {
                System.out.print(grid[xyToIndex(x, y)] == true ? 'x' : '_');
            }
            System.out.print('\n');
        }
    }

    public int locToIndex(String loc) {
        if (loc == null || loc.length() != 2)
            return -1;
        return xyToIndex(loc.charAt(0) - 'a', loc.charAt(1) - '0');
    }

    public int indexToX(int index) { return index % gridX; }
    public int indexToY(int index) { return index / gridY; }

    public String indexToLocation(int index) {
        int x = index % gridX;
        int y = index / gridX;
        return "" + (char)(x + 'a') + (char)(y + '0');
    }

    public int xyToIndex(int x, int y) { return x + y * gridX; }

    public boolean isEmpty() { return shipList.isEmpty(); }
}
