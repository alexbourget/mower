package fr.xebia.recrutement.mowitnow.implementations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.xebia.recrutement.mowitnow.entities.Mobile;
import fr.xebia.recrutement.mowitnow.entities.Mower;
import fr.xebia.recrutement.mowitnow.entities.Position;
import fr.xebia.recrutement.mowitnow.entities.PositionTwoAxe;
import fr.xebia.recrutement.mowitnow.entities.RectangularGarden;
import fr.xebia.recrutement.mowitnow.entities.Surface;
import fr.xebia.recrutement.mowitnow.enumeration.Direction;
import fr.xebia.recrutement.mowitnow.exception.SyntaxErrorException;
import fr.xebia.recrutement.mowitnow.interfaces.IImportInstruction;

/**
 * <p>ImportFile implements IInstruction.
 * This class import configuration from a configuration file and return a list of Mobile.</p>
 * <p>The first line of a the text file needs to be surface's informations
 * like: "5 5". This represents the surface's top right coordinates.</p>
 * <p>Each following blocs of two line are Mobile's informations:</p>
 * <ul>
 *  <li>First line of a bloc gives position and direction of the mobile.<br>
 * For example: "1 2 N" which could be read as 1 on X axe, 2 on Y axe, North direction.</li>
 * <li>Second line of a bloc gives instruction's sequence to move the mobile.<br>
 * For example: "AGAD" which could be read as move forward, turn left, move forward, turn right.</li>
 * </ul>
 * <p>Syntax of the file is checked with patterns. In case of syntax error, an Exception occurs.</p>
 * @author Alexandre Bourget.
 *
 */
public class ImportMowerFile implements IImportInstruction {
    /**
     * patternInitSurface represents the regular expression
     * to validate the surface's initialization line.
     */
    private Pattern patternInitSurface = Pattern.compile("^([0-9]+) ([0-9]+)$");
    /**
     * initSurfaceGroup1 represent the second group in patternInitSurface.
     */
    private final int initSurfaceGroup1 = 1;
    /**
     * initSurfaceGroup2 represent the third group in patternInitSurface.
     */
    private final int initSurfaceGroup2 = 2;
    /**
     * patternInitMower represents the regular expression
     * to validate the mower's initialization line.
     */
    private Pattern patternInitMower = Pattern.compile("^([0-9]+) ([0-9]+) ([NEWS])$");
    /**
     * initMowerGroup1 represent the second group in patternInitMower.
     */
    private final int initMowerGroup1 = 1;
    /**
     * initMowerGroup2 represent the third group in patternInitMower.
     */
    private final int initMowerGroup2 = 2;
    /**
     * initMowerGroup3 represent the forth group in patternInitMower.
     */
    private final int initMowerGroup3 = 3;
    /**
     * patternSequenceMower represents the regular expression
     * to validate the mower's sequence line.
     */
    private Pattern patternSequenceMower = Pattern.compile("^([GDA]+)$");
    /**
     * initSequenceGroup1 represent the second group in patternSequenceMower.
     */
    private final int initSequenceGroup1 = 1;
    /**
     * br represents a bufferedReader.
     */
    private BufferedReader br = null;
    /**
     * mobiles represents a list of mobiles.
     */
    private List<Mobile> mobiles = null;
    /**
     * line represents a line in the configuration file.
     */
    private String line;
    /**
     * lineNumber represents the actual line's number.
     */
    private int lineNumber;
    /**
     * surface represents a surface to set up.
     */
    private Surface surface;
    /**
     * mobile represents a mobile to set up.
     */
    private Mobile mower;

    @Override
    public List<Mobile> importInstruction(String filePath) {
        setMobiles(new ArrayList<Mobile>());
        setLine("");
        setLineNumber(0);
        setSurface(null);

        try {
            setBr(new BufferedReader(new FileReader(filePath)));
            parseFile();

        } catch (FileNotFoundException e) {
            System.out.println("Configuration file not found. Please check file path : " + filePath);
        } catch (IOException e3) {
            System.out.println("Configuration file can't be access.");
            e3.printStackTrace();
        } finally {
            if (getBr() != null) {
                try {
                    getBr().close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        validateMobiles();
        return getMobiles();

    }

    /**
     * validateMobiles nullify mobiles attribute if empty.
     */
    private void validateMobiles() {
        if (getMobiles().size() == 0) {
            setMobiles(null);
        }
    }

    /**
     * @throws IOException Input/Output exception.
     */
    private void parseFile() throws IOException {

        // initialize
        nextLine();
        try {
            // parsing first line of file.
            parseSurfaceInstruction();
            nextLine();
            // parsing each following blocs of two lines.
            while (getLine() != null) {
                // new Mower.
                setMower(new Mower());
                getMower().getMoving().setSurface(getSurface());
                try {
                    // parse position and direction
                    parsePositionDirectionInstruction();
                    nextLine();
                    // parse sequence
                    parseSequenceInstruction();
                    nextLine();
                    // add the new mower to list
                    getMobiles().add(getMower());
                } catch (SyntaxErrorException e) {
                    System.out.println(e.getMessage());
                    nextLine();
                }
            }
        } catch (SyntaxErrorException e1) {
            // first not empty line needs to hold surface informations. Exit.
            validateMobiles();
        }
    }

    /**
     * nextLine reads the next line of a bufferReader and increments a line number.
     * @throws IOException An exception.
     */
    private void nextLine() throws IOException {
        setLine(getBr().readLine());
        if (getLine() != null) {
            setLineNumber(getLineNumber() + 1);
            // empty line are ignored.
            if (getLine().equals("")) {
                nextLine();
            }
        }
    }

    /**
     * Parse Surface informations.
     * @throws SyntaxErrorException A line's syntax error exception.
     */
    private void parseSurfaceInstruction()
            throws SyntaxErrorException {
        if (getLine() != null) {
            Matcher mInitSurface = patternInitSurface.matcher(getLine());
            if (mInitSurface.matches()) {                         // check if syntax corresponds to a surface definition.
                setSurface(new RectangularGarden(Integer.parseInt(mInitSurface.group(initSurfaceGroup1)),
                        Integer.parseInt(mInitSurface.group(initSurfaceGroup2))));
            } else {
                throw new SyntaxErrorException(getLineNumber(), patternInitSurface.pattern());
            }
        }
    }

    /**
     * Parse position and direction informations.
     * @throws SyntaxErrorException A line's syntax error exception.
     */
    private void parsePositionDirectionInstruction()
            throws SyntaxErrorException {
        if (getLine() != null && !getLine().equals("")) {
            Matcher mInitMower = patternInitMower.matcher(getLine());
            if (mInitMower.matches()) {                                // check if syntax corresponds to a mower's starting position.
                Position initPosition = new PositionTwoAxe(Integer.parseInt(mInitMower.group(initMowerGroup1)),
                        Integer.parseInt(mInitMower.group(initMowerGroup2)));
                Direction initDirection = Direction.valueOf(mInitMower.group(initMowerGroup3));
                getMower().getMoving().setCurrentPosition(initPosition);
                getMower().getMoving().setDirection(initDirection);
            } else {
                throw new SyntaxErrorException(getLineNumber(), patternInitMower.pattern());
            }
        }
    }

    /**
     * Parse sequence moving instructions.
     * @throws SyntaxErrorException A line's syntax error exception.
     */
    private void parseSequenceInstruction()
            throws SyntaxErrorException {
        if (getLine() != null) {
            Matcher mSequenceMower = patternSequenceMower.matcher(getLine());
            if (getLine() != null && mSequenceMower.matches()) {            // check if syntax corresponds to a mower's instructions sequence.
                String initSequence = mSequenceMower.group(initSequenceGroup1);
                getMower().getMoving().setSequence(initSequence);
            } else {
                throw new SyntaxErrorException(getLineNumber(), patternSequenceMower.pattern());
            }
        }
    }

    /**
     * @return the br
     */
    public BufferedReader getBr() {
        return br;
    }

    /**
     * @param paramBr the br to set
     */
    public void setBr(BufferedReader paramBr) {
        br = paramBr;
    }

    /**
     * @return the mobiles
     */
    public List<Mobile> getMobiles() {
        return mobiles;
    }

    /**
     * @param paramMobiles the mobiles to set
     */
    public void setMobiles(List<Mobile> paramMobiles) {
        mobiles = paramMobiles;
    }

    /**
     * @return the line
     */
    public String getLine() {
        return line;
    }

    /**
     * @param paramLine the line to set
     */
    public void setLine(String paramLine) {
        line = paramLine;
    }

    /**
     * @return the lineNumber
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * @param paramLineNumber the lineNumber to set
     */
    public void setLineNumber(int paramLineNumber) {
        lineNumber = paramLineNumber;
    }

    /**
     * @return the surface
     */
    public Surface getSurface() {
        return surface;
    }

    /**
     * @param paramSurface the surface to set
     */
    public void setSurface(Surface paramSurface) {
        surface = paramSurface;
    }

    /**
     * @return the mower
     */
    public Mobile getMower() {
        return mower;
    }

    /**
     * @param paramMower the mower to set
     */
    public void setMower(Mobile paramMower) {
        mower = paramMower;
    }

}
