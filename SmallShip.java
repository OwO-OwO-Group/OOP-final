/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */
package hw2;

public class SmallShip extends DotCom {
    public SmallShip(String nameStr) {
        super(nameStr, 2);
        super.setHitShout("HIT!");
        super.setHitMoveRange(1);
    }
}
