package fr.xebia.recrutement.mowitnow.entities;

/**
 * PositionTwoAxe represents a {@link Position} with two axes.
 * Values are expressed with integers.
 * @author Alexandre Bourget.
 *
 */
public class PositionTwoAxe extends Position {

    /**
     * Default constructor.
     */
    public PositionTwoAxe() {
        setCoordinates(new float[2]);
    }

    /**
     * Constructor.
     * @param paramX the position's value on the X axe.
     * @param paramY  the position's value on the Y axe.
     */
    public PositionTwoAxe(int paramX, int paramY) {
        float[] initCoordinates = {paramX, paramY};
        setCoordinates(initCoordinates);
    }

    /* (non-Javadoc)
     * @see fr.xebia.recrutement.mowitnow.entities.Position#toString()
     */
    @Override
    public String toString() {
        String result;
        if (getCoordinates() == null) {
            result = "Position not defined";
        } else {
            result = "" + Math.round(getCoordinates()[0]);
            for (int i = 1; i < getCoordinates().length; i++) {
                result = result + " " + Math.round(getCoordinates()[i]);
            }
        }
        return result;
    }
}
