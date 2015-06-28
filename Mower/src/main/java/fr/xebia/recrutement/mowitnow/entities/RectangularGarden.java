package fr.xebia.recrutement.mowitnow.entities;



/**
 * RectangularGarden represents a rectangular {@link Surface} where positions are defined with {@link PositionTwoAxe}.
 * The bottom left apex coordinates is supposed to be (0,0).
 * @author Alexandre Bourget
 */
public class RectangularGarden extends Surface {

    /**
     * The bottom left corner value on the X axe.
     */
    private static final int BOTTOM_LEFT_CORNER_X = 0;
    /**
     * The bottom left corner value on the Y axe.
     */
    private static final int BOTTOM_LEFT_CORNER_Y = 0;

    /**
     * Default constructor.
     */
    public RectangularGarden() {
        super();
    }

    /**
     * Constructor.
     * The bottom left apex coordinates are (0,0).
     * @param paramTopRightCornerX The top right corner value on the Y axe.
     * @param paramTopRightCornerY The top right corner value on the X axe.
     */
    public RectangularGarden(int paramTopRightCornerX, int paramTopRightCornerY) {
        setBottomLeft(new PositionTwoAxe(BOTTOM_LEFT_CORNER_X, BOTTOM_LEFT_CORNER_Y));
        setTopRight(new PositionTwoAxe(paramTopRightCornerX, paramTopRightCornerY));
    }

}
