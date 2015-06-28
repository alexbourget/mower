package fr.xebia.recrutement.mowitnow.entities;

import fr.xebia.recrutement.mowitnow.implementations.MowerMove;


/**
 * Mower is a {@link Mobile} object.
 * By default, the Mower's {@link Mobile#moving} is set to {@link MowerMove}.
 * @author Alexandre Bourget.
 *
 */
public class Mower extends Mobile {

    /**
     * Default constructor.
     * moving property is set to {@link MoverMove}.
     */
    public Mower() {
        setMoving(new MowerMove());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getMoving().toString();
    }

    @Override
    public void play() {
        getMoving().executeSequence();
    }

}
