package fr.xebia.recrutement.mowitnow.implementations;

import fr.xebia.recrutement.mowitnow.entities.Position;
import fr.xebia.recrutement.mowitnow.entities.RectangularGarden;
import fr.xebia.recrutement.mowitnow.entities.Surface;
import fr.xebia.recrutement.mowitnow.enumeration.Direction;
import fr.xebia.recrutement.mowitnow.interfaces.IMoving;

/**
 * MowerMove implements IMoving interface on two axes and a rectangular surface.
 * @author Alexandre Bourget
 *
 */
public class MowerMove implements IMoving {

    /**
     * X_AXE_NUMBER represents the referential's first axe.
     */
    private static final int X_AXE_NUMBER = 0;
    /**
     * Y_AXE_NUMBER represents the referential's second axe.

     */
    private static final int Y_AXE_NUMBER = 1;
    /**
     * UNIT_MOVEMENT represents the unit movement's value.
     */
    private static final float UNIT_MOVEMENT = 1;
    /**
     * direction represent the mobile's direction.
     */
    private Direction direction;
    /**
     * surface represents a surface accessible to the mobile.
     */
    private Surface surface = new RectangularGarden();
    /**
     * position is a position on the surface.
     */
    private Position currentPosition;
    /**
     * sequence is the instruction's sequence of a mobile.
     */
    private String sequence;

    @Override
    public void moveForward() {
        switch (direction) {
        case N: addToCurrentPosition(Y_AXE_NUMBER, UNIT_MOVEMENT);
        break;
        case E: addToCurrentPosition(X_AXE_NUMBER, UNIT_MOVEMENT);
        break;
        case W: addToCurrentPosition(X_AXE_NUMBER, -UNIT_MOVEMENT);
        break;
        case S: addToCurrentPosition(Y_AXE_NUMBER, -UNIT_MOVEMENT);
        break;
        default:                                                // do nothing.
        }
    }

    @Override
    public void executeSequence() {
        char[] tabSeq = getSequence().toCharArray();
        for (int i = 0; i < tabSeq.length; i++) {
            executeInstruction(tabSeq[i]);
        }
    }

    /**
     * @param paramInstruction an instruction
     */
    private void executeInstruction(char paramInstruction) {
        switch (paramInstruction) {
        case 'A': moveForward();
        break;
        case 'G': direction = direction.rotateLeft();
        break;
        case 'D': direction = direction.rotateRight();
        break;
        default:                                                // do nothing.
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getCurrentPosition().toString() + " " + getDirection().getCardinal();
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction paramDirection) {
        direction = paramDirection;
    }

    @Override
    public void addToCurrentPosition(int paramAxeNumber, float paramValue) {
        currentPosition.getCoordinates()[paramAxeNumber] += paramValue;
        if (currentPosition.getCoordinates()[paramAxeNumber] < surface.getBottomLeft().getAxeValue(paramAxeNumber)) {
            currentPosition.getCoordinates()[paramAxeNumber] = surface.getBottomLeft().getAxeValue(paramAxeNumber);
        } else if (currentPosition.getCoordinates()[paramAxeNumber] > surface.getTopRight().getAxeValue(paramAxeNumber)) {
            currentPosition.getCoordinates()[paramAxeNumber] = surface.getTopRight().getAxeValue(paramAxeNumber);
        }
    }

    @Override
    public Surface getSurface() {
        return surface;
    }

    @Override
    public void setSurface(Surface paramSurface) {
        surface = paramSurface;
    }

    @Override
    public Position getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void setCurrentPosition(Position paramCurrentPosition) {
        currentPosition = paramCurrentPosition;
    }

    @Override
    public String getSequence() {
        return sequence;
    }

    @Override
    public void setSequence(String paramSequence) {
        sequence = paramSequence;
    }
}
