package fr.xebia.recrutement.mowitnow.exception;

/**
 * SyntaxErrorException represents exception when
 * a syntax error occurs in a Mower project's configuration file.
 * @author Alexandre Bourget.
 *
 */
public class SyntaxErrorException extends Throwable {
    /**
     * serialVersionUID represent a serial version UID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor.
     */
    public SyntaxErrorException() {
        super();
    }
    /**
     * Constructor.
     * @param line The line where the syntax error occurs.
     * @param pattern The pattern to match.
     */
    public SyntaxErrorException(int line, String pattern) {
        super("Syntax error in configuration file at line " + line
        + ". Please use a syntax matching with the following regular expression : ("
        + pattern + "). Line skiped.");
    }
}
