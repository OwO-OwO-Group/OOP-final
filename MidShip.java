/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */
package hw2;

public class MidShip extends DotCom {
    public MidShip(String nameStr) {
        super(nameStr, 3);
        super.setHitShout("WHACK!");
        super.setHitMoveRange(1);
    }
}
