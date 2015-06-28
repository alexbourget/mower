package fr.xebia.recrutement.mowitnow.entities;

import fr.xebia.recrutement.mowitnow.interfaces.IMoving;


/**
 * Mobile represents a mobile object with a kind of moving.
 * @author Alexandre Bourget
 *
 */
public abstract class Mobile {

    /**
     * moving represents a moving strategy.
     */
    private IMoving moving;
    /**
     * Default constructor.
     */
    public Mobile() {
        super();
        moving = null;
    }

    /**
     * Constructor.
     * @param paramMoving {@link #moving}
     */
    public Mobile(IMoving paramMoving) {
        super();
        moving = paramMoving;
    }

    /**
     * executeSequence play the sequence's instructions.
     */
    public abstract void play();


    /**
     * @return the moving
     */
    public IMoving getMoving() {
        return moving;
    }

    /**
     * @param paramMoving the moving to set
     */
    public void setMoving(IMoving paramMoving) {
        moving = paramMoving;
    }
}
