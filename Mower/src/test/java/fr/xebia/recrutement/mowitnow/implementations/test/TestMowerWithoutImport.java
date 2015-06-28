package fr.xebia.recrutement.mowitnow.implementations.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.xebia.recrutement.mowitnow.entities.Mobile;
import fr.xebia.recrutement.mowitnow.entities.Mower;
import fr.xebia.recrutement.mowitnow.entities.Position;
import fr.xebia.recrutement.mowitnow.entities.PositionTwoAxe;
import fr.xebia.recrutement.mowitnow.entities.RectangularGarden;
import fr.xebia.recrutement.mowitnow.entities.Surface;
import fr.xebia.recrutement.mowitnow.enumeration.Direction;

/**
 * TestMowerWithoutImport test mover's app without configuration file.
 * @author Alexandre Bourget.
 *
 */
public class TestMowerWithoutImport {
    /**
     * Garden's top right coordinate on the X axe.
     */
    private static final int TOP_RIGHT_X_GARDEN = 5;
    /**
     * Garden's top right coordinate on the Y axe.
     */
    private static final int TOP_RIGHT_Y_GARDEN = 5;
    /**
     * garden is the test's surface.
     */
    private static Surface garden = new RectangularGarden(TOP_RIGHT_X_GARDEN, TOP_RIGHT_Y_GARDEN);

    // attributes used by playSequence test methods.
    /**
     * mower1 is a Mower.
     */
    private static Mobile mower1 = new Mower();
    /**
     * mower2 is another Mower.
     */
    private static Mobile mower2 = new Mower();
    /**
     * Mower1's coordinate on X axe.
     */
    private static final int X_POSITION_MOWER1 = 1;
    /**
     * Mower1's coordinate on Y axe.
     */
    private static final int Y_POSITION_MOWER1 = 2;
    /**
     * initPositionMower1 is the initial position of mower1.
     */
    private static Position initPositionMower1 = new PositionTwoAxe(X_POSITION_MOWER1, Y_POSITION_MOWER1);
    /**
     * Mower2's coordinate on X axe.
     */
    private static final int X_POSITION_MOWER2 = 3;
    /**
     * Mower2's coordinate on Y axe.
     */
    private static final int Y_POSITION_MOWER2 = 3;
    /**
     * initPositionMower2 is the initial position of mower2.
     */
    private static Position initPositionMower2 = new PositionTwoAxe(X_POSITION_MOWER2, Y_POSITION_MOWER2);
    /**
     * initDirection1 is the initial direction of mower1.
     */
    private static Direction initDirection1 = Direction.N;
    /**
     * initDirection2 is the initial direction of mower2.
     */
    private static Direction initDirection2 = Direction.E;

    /**
     * sequenceMower1 is the test's sequence for mower1.
     */
    private static String sequenceMower1 = new String("GAGAGAGAA");
    /**
     * sequenceMower2 is the test's sequence for mower2.
     */
    private static String sequenceMower2 = new String("AADAADADDA");
    /**
     * resultPlay1 is the result after playing sequenceMower1.
     */
    private static String resultPlay1 = new String("1 3 N");
    /**
     * resultPlay2 is the result after playing sequenceMower2.
     */
    private static String resultPlay2 = new String("5 1 E");

    // ***************** attributes used by outOfBound tests methods. ********************//
    /**
     * mowerBeyondNorth is a Mower.
     */
    private static Mower mowerBeyondNorth = new Mower();
    /**
     * MowerBeyondNorth's coordinate on X axe.
     */
    private static final int X_POSITION_MOWERBEYONDNORTH = 2;
    /**
     * MowerBeyondNorth's coordinate on Y axe.
     */
    private static final int Y_POSITION_MOWERBEYONDNORTH = 0;
    /**
     * initPositionBeyondNorth is the initial position of mowerBeyondNorth.
     */
    private static Position initPositionBeyondNorth = new PositionTwoAxe(X_POSITION_MOWERBEYONDNORTH, Y_POSITION_MOWERBEYONDNORTH);
    /**
     * initDirectionBeyondNorth is the initial direction of mowerBeyondNorth.
     */
    private static Direction initDirectionBeyondNorth = Direction.N;
    /**
     * sequenceBeyondNorth is the test's sequence to move mowerBeyondNorth beyond
     * north.
     */
    private static String sequenceBeyondNorth = new String("AAAAAA");
    /**
     * resultPlayBeyondNorth is the result after playing sequenceMowerBeyondNorth.
     */
    private static String resultPlayBeyondNorth = new String("2 5 N");
    /**
     * mowerBeyondEast is a Mower.
     */
    private static Mower mowerBeyondEast = new Mower();
    /**
     * MowerBeyondEast's coordinate on X axe.
     */
    private static final int X_POSITION_MOWERBEYONDEAST = 0;
    /**
     * MowerBeyondEast's coordinate on Y axe.
     */
    private static final int Y_POSITION_MOWERBEYONDEAST = 2;
    /**
     * initPositionBeyondEast is the initial position of mowerBeyondEast.
     */
    private static Position initPositionBeyondEast = new PositionTwoAxe(X_POSITION_MOWERBEYONDEAST, Y_POSITION_MOWERBEYONDEAST);
    /**
     * initDirectionBeyondEast is the initial direction of mowerBeyondEast.
     */
    private static Direction initDirectionBeyondEast = Direction.E;
    /**
     * sequenceBeyondEast is the test's sequence to move mowerBeyondEast beyond
     * East.
     */
    private static String sequenceBeyondEast = new String("AAAAAA");
    /**
     * resultPlayBeyondEast is the result after playing sequenceMowerBeyondEast.
     */
    private static String resultPlayBeyondEast = new String("5 2 E");
    /**
     * mowerBeyondWest is a Mower.
     */
    private static Mower mowerBeyondWest = new Mower();
    /**
     * MowerBeyondWest's coordinate on X axe.
     */
    private static final int X_POSITION_MOWERBEYONDWEST = 5;
    /**
     * MowerBeyondWest's coordinate on Y axe.
     */
    private static final int Y_POSITION_MOWERBEYONDWEST = 2;
    /**
     * initPositionBeyondWest is the initial position of mowerBeyondWest.
     */
    private static Position initPositionBeyondWest = new PositionTwoAxe(X_POSITION_MOWERBEYONDWEST, Y_POSITION_MOWERBEYONDWEST);
    /**
     * initDirectionBeyondWest is the initial direction of mowerBeyondWest.
     */
    private static Direction initDirectionBeyondWest = Direction.W;
    /**
     * sequenceBeyondWest is the test's sequence to move mowerBeyondWest beyond
     * West.
     */
    private static String sequenceBeyondWest = new String("AAAAAA");
    /**
     * resultPlayBeyondWest is the result after playing sequenceMowerBeyondWest.
     */
    private static String resultPlayBeyondWest = new String("0 2 W");
    /**
     * mowerBeyondSouth is a Mower.
     */
    private static Mower mowerBeyondSouth = new Mower();
    /**
     * MowerBeyondSouth's coordinate on X axe.
     */
    private static final int X_POSITION_MOWERBEYONDSOUTH = 2;
    /**
     * MowerBeyondSouth's coordinate on Y axe.
     */
    private static final int Y_POSITION_MOWERBEYONDSOUTH = 5;
    /**
     * initPositionBeyondSouth is the initial position of mowerBeyondSouth.
     */
    private static Position initPositionBeyondSouth = new PositionTwoAxe(X_POSITION_MOWERBEYONDSOUTH, Y_POSITION_MOWERBEYONDSOUTH);
    /**
     * initDirectionBeyondSouth is the initial direction of mowerBeyondSouth.
     */
    private static Direction initDirectionBeyondSouth = Direction.S;
    /**
     * sequenceBeyondSouth is the test's sequence to move mowerBeyondSouth beyond
     * South.
     */
    private static String sequenceBeyondSouth = new String("AAAAAA");
    /**
     * resultPlayBeyondSouth is the result after playing sequenceMowerBeyondSouth.
     */
    private static String resultPlayBeyondSouth = new String("2 0 S");


    /**
     * init is the initialisation method before a test start.
     */
    @BeforeClass
    public static void init() {
        // initialize the mower1 :
        mower1.getMoving().setSurface(garden);
        mower1.getMoving().setCurrentPosition(initPositionMower1);
        mower1.getMoving().setDirection(initDirection1);
        mower1.getMoving().setSequence(sequenceMower1);
        // initialize the mower2 :
        mower2.getMoving().setSurface(garden);
        mower2.getMoving().setCurrentPosition(initPositionMower2);
        mower2.getMoving().setDirection(initDirection2);
        mower2.getMoving().setSequence(sequenceMower2);
        // initialize the mowerBeyondNorth :
        mowerBeyondNorth.getMoving().setSurface(garden);
        mowerBeyondNorth.getMoving().setCurrentPosition(initPositionBeyondNorth);
        mowerBeyondNorth.getMoving().setDirection(initDirectionBeyondNorth);
        mowerBeyondNorth.getMoving().setSequence(sequenceBeyondNorth);
        // initialize the mowerBeyondEast :
        mowerBeyondEast.getMoving().setSurface(garden);
        mowerBeyondEast.getMoving().setCurrentPosition(initPositionBeyondEast);
        mowerBeyondEast.getMoving().setDirection(initDirectionBeyondEast);
        mowerBeyondEast.getMoving().setSequence(sequenceBeyondEast);
        // initialize the mowerBeyondWest :
        mowerBeyondWest.getMoving().setSurface(garden);
        mowerBeyondWest.getMoving().setCurrentPosition(initPositionBeyondWest);
        mowerBeyondWest.getMoving().setDirection(initDirectionBeyondWest);
        mowerBeyondWest.getMoving().setSequence(sequenceBeyondWest);
        // initialize the mowerBeyondSouth :
        mowerBeyondSouth.getMoving().setSurface(garden);
        mowerBeyondSouth.getMoving().setCurrentPosition(initPositionBeyondSouth);
        mowerBeyondSouth.getMoving().setDirection(initDirectionBeyondSouth);
        mowerBeyondSouth.getMoving().setSequence(sequenceBeyondSouth);
    }

    /**
     * playSequence tests the execution of a sequence.
     */
    @Test
    public void playSequence() {
        mower1.play();
        mower2.play();
        Assert.assertNotNull(mower1.toString());
        Assert.assertNotNull(mower2.toString());
        Assert.assertEquals(mower1.toString(), resultPlay1);
        Assert.assertEquals(mower2.toString(), resultPlay2);
    }

    /**
     * outOfBound verifies mobile's never goes outside the area.
     */
    @Test
    public void outOfBound() {
        // play sequence to go beyond North
        mowerBeyondNorth.play();
        Assert.assertNotNull(mowerBeyondNorth.toString());
        Assert.assertEquals(resultPlayBeyondNorth, mowerBeyondNorth.toString());
        // play sequence to go beyond East
        mowerBeyondEast.play();
        Assert.assertNotNull(mowerBeyondEast.toString());
        Assert.assertEquals(resultPlayBeyondEast, mowerBeyondEast.toString());
        // play sequence to go beyond West
        mowerBeyondWest.play();
        Assert.assertNotNull(mowerBeyondWest.toString());
        Assert.assertEquals(resultPlayBeyondWest, mowerBeyondWest.toString());
        // play sequence to go beyond South
        mowerBeyondSouth.play();
        Assert.assertNotNull(mowerBeyondSouth.toString());
        Assert.assertEquals(resultPlayBeyondSouth, mowerBeyondSouth.toString());
    }

}
