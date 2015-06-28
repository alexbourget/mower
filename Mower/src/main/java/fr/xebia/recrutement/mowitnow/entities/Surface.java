package fr.xebia.recrutement.mowitnow.entities;

/**
 * Surface represents a geometric surface define by a bottom left position
 * and a top right position.
 * @author Alexandre Bourget.
 *
 */
public abstract class Surface {
    /**
     * bottomLeft represents the surface's bottom left position.
     */
    private Position bottomLeft;
    /**
     * topRight represents the surface's top right position.
     */
    private Position topRight;

    /**
     * Default constructor. The surface have no dimension.
     */
    public Surface() {
        super();
        bottomLeft = null;
        topRight = null;
    }

    /**
     * Constructor.
     * @param paramBottomLeft {@link #bottomLeft}
     * @param paramTopRight {@link #topRight}
     */
    public Surface(Position paramBottomLeft, Position paramTopRight) {
        super();
        bottomLeft = paramBottomLeft;
        topRight = paramTopRight;
    }

    /**
     * @return the bottomLeft
     */
    public Position getBottomLeft() {
        return bottomLeft;
    }

    /**
     * @param paramBottomLeft the bottomLeft to set
     */
    public void setBottomLeft(Position paramBottomLeft) {
        bottomLeft = paramBottomLeft;
    }

    /**
     * @return the topRight
     */
    public Position getTopRight() {
        return topRight;
    }

    /**
     * @param paramTopRight the topRight to set
     */
    public void setTopRight(Position paramTopRight) {
        topRight = paramTopRight;
    }

}
