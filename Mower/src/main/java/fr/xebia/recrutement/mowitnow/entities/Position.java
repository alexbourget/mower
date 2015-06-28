package fr.xebia.recrutement.mowitnow.entities;


/**
 * Position represent a position in a n axes referential.
 * Values are express with floats.
 * @author Alexandre Bourget
 *
 */
public class Position {
    /**
     * coordinates represent the position's coordinates.
     * The number of element in the tab is equal to the number of axes.
     */
    private float[] coordinates;

    /**
     * @return the coordinates
     */
    public float[] getCoordinates() {
        return coordinates;
    }

    /**
     * @param paramCoordinates the coordinates to set
     */
    public void setCoordinates(float[] paramCoordinates) {
        coordinates = paramCoordinates;
    }

    /**
     * getAxeValue return the axe's value.
     * @param axeNumber The axe's number id.
     * @return The axe's value.
     */
    public float getAxeValue(int axeNumber) {
        float value = 0;
        try {
            value = getCoordinates()[axeNumber];
        } catch (Exception e) {
            System.out.println("The axeNumber parameter seems to be out of bounds.");
            e.printStackTrace();
        }
        return value;
    }

    /**
     * setAxeValue define an axe's value.
     * @param axeNumber The axe's number.
     * @param paramValue The value.
     */
    public void setAxeValue(int axeNumber, float paramValue) {
        getCoordinates()[axeNumber] = paramValue;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result;
        if (coordinates == null) {
            result = "Position not defined";
        } else {
            result = "" + coordinates[0];
            for (int i = 1; i < coordinates.length; i++) {
                result = result + " " + coordinates[i];
            }
        }
        return result;
    }

}
