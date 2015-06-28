package fr.xebia.recrutement.mowitnow.interfaces;

import fr.xebia.recrutement.mowitnow.entities.Position;
import fr.xebia.recrutement.mowitnow.entities.Surface;
import fr.xebia.recrutement.mowitnow.enumeration.Direction;

/**
 * IMoving shows moving methods for {@link Mobile}.
 * @author Alexandre Bourget.
 *
 */
public interface IMoving {
    /**
     * moves a {@link Mobile} forward.
     */
    void moveForward();
    /**
     * executes a sequence of movements.
     */
    void executeSequence();

    /**
     * getDirection return the direction.
     * @return the direction
     */
    Direction getDirection();

    /**
     * setDirection set a direction.
     * @param paramDirection the direction to set
     */
    void setDirection(Direction paramDirection);

    /**
     * getSurface return a surface.
     * @return the surface.
     */
    Surface getSurface();

    /**
     * setSurface set a surface.
     * @param paramSurface the surface to set.
     */
    void setSurface(Surface paramSurface);

    /**
     * addToCurrentPosition add a value to an current axe's value.
     * @param paramAxeNumber The axe's number id.
     * @param paramValue The value to add.
     */
    void addToCurrentPosition(int paramAxeNumber, float paramValue);

    /**
     * @return the currentPosition
     */
    Position getCurrentPosition();

    /**
     * @param paramCurrentPosition the currentPosition to set
     */
    void setCurrentPosition(Position paramCurrentPosition);

    /**
     * @return the instruction's sequence.
     */
    String getSequence();

    /**
     * @param paramSequence the sequence to set
     */
    void setSequence(String paramSequence);
}
