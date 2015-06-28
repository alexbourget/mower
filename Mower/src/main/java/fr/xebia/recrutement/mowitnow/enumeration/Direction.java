package fr.xebia.recrutement.mowitnow.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Represent a direction in the cardinality system.
 * Values are N, E, W, S respectively for North, East, West and South.
 * <ul>
 * <li>N is equivalent to 0 degree.</li>
 * <li>E is equivalent to 270 degree.</li>
 * <li>W is equivalent to 90 degree.</li>
 * <li>S is equivalent to 180 degree.</li>
 * </ul>
 * @author Alexandre Bourget.
 */
public enum Direction {
    /**
     * North.
     */
    N(0, "N") {
    },
    /**
     * East.
     */
    E(90, "E") {
    },
    /**
     * South.
     */
    S(180, "S") {
    },
    /**
     * West.
     */
    W(270, "W") {
    };

    /**
     * turnRightDegree represent degrees to turn on the right .
     */
    private final int turnRightDegree = 90;
    /**
     * rightDegree represent degrees to turn on the left .
     */
    private final int turnLeftDegree = 270;
    /**
     * maxDegree represent degrees to perform a full turn around.
     */
    private final int maxDegree = 360;

    /**
     * The direction's degrees.
     */
    private final int degrees;
    /**
     * The direction's cardinal.
     */
    private final String cardinal;

    /**
     * Constructor.
     * @param paramDegrees {@link #degrees}
     * @param paramCardinal {@link #cardinal}
     */
    private Direction(final int paramDegrees, final String paramCardinal) {
        degrees = paramDegrees;
        cardinal = paramCardinal;
    }

    /**
     * @return the direction's degrees.
     */
    public int getDegrees() {
        return degrees;
    }

    /**
     * @return the cardinal.
     */
    public String getCardinal() {
        return cardinal;
    }

    /**
     * LOOKUP is a map of all Direction.
     */
    private static final Map<Integer, Direction> LOOKUP = new HashMap<Integer, Direction>();

    static {
        for (Direction d : EnumSet.allOf(Direction.class)) {
            LOOKUP.put(d.getDegrees(), d);

        }
    }

    /**
     * Return a direction corresponding to the degree.
     * @param degrees The degrees
     * @return The direction
     */
    public static Direction get(int degrees) {
        return LOOKUP.get(degrees);
    }

    /**
     * @return the direction after a rotation of 90° on the right.
     */
    public Direction rotateRight() {
        return Direction.get((degrees + turnRightDegree) % maxDegree);
    }

    /**
     * @return the direction after a rotation of 90° on the left.
     */
    public Direction rotateLeft() {
        return Direction.get((degrees + turnLeftDegree) % maxDegree);
    }

}
