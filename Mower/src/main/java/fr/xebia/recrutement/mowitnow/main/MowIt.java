package fr.xebia.recrutement.mowitnow.main;

import java.util.List;

import fr.xebia.recrutement.mowitnow.entities.Mobile;
import fr.xebia.recrutement.mowitnow.implementations.ImportMowerFile;
import fr.xebia.recrutement.mowitnow.interfaces.IImportInstruction;

/**
 * MowIt class holds main method.
 * @author Alexandre Bourget.
 *
 */
public final class MowIt {
    /**
     * Default constructor.
     */
    private MowIt() {
    }

    /**
     * Methode d'entrée main.
     * @param args .
     */
    public static void main(String[] args) {
        String firstArgument = "";
        try {
            firstArgument = args[0];
            switch (firstArgument) {
            case "-h": printhelp();
            break;
            case "--help": printhelp();
            break;
            default: getResultImport(firstArgument);
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("Please specify a configuration file in parameter.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * printhelp print a help.
     */
    private static void printhelp() {
        System.out.println(
                "USE: java -jar mower-1.0.jar FILEPATH \n"
                + "mower-1.0.jar is the default name of this app.\n"
                + "FILEPATH is a necessary configuration file.\n"
                + "-h, --help : show this help.\n"
                + "\n"
                + "This app moves mowers on a garden.\n"
                + "When a mower has finished his sequence movement, the mower gives his position and direction.\n"
                + "Only one mower can move at a time.\n"
                + "\n"
                + "The configuration file needs:\n"
                + "** a first line which define the garden.\n"
                + "For example: a first line like '5 5' gives the top right coordinate of "
                + "the garden (5,5) on a (x,y) referential. The bottom left coordinate is always (0,0).\n"
                + "** and one or several bloc of two lines to define a mower.\n"
                + "For example:\n"
                + "First line of a bloc give the initial coordinates position of the mower. '1 2 N' "
                + "means coordinates (1,2) and direction North.\n"
                + "Second line of a bloc give a sequence for moving the mower. 'ADGA' means move forward, then turn right, "
                + "then turn left, then move forward.\n"
                + "\n"
                + "You can use N E W S for direction respectively North, East, West and South.\n"
                + "You can use A D G for moving respectively 'A' for moving forward,"
                + "'D' for turning right, 'G' for turning left'.\n"
                + "Empty line will be skiped.\n"
                + "In case of syntax error, line and pattern to match will be given.\n"
                + "\n"
                + "Following lines are a valid configuration:\n"
                + "5 5\n"
                + "1 2 N\n"
                + "GAGAGAGAA\n"
                + "3 3 E\n"
                + "AADAADADDA\n"
                + "\n"
                + "This valid configuration gives folowing result:\n"
                + "1 3 N\n"
                + "5 1 E\n"
                + "\n"
                );
    }

    /**
     * @param filePath The configuration file path provided by the user.
     * @throws Exception An eventual unknown error.
     */
    private static void getResultImport(String filePath) throws Exception {
        IImportInstruction importInstruction = new ImportMowerFile();
        List<Mobile> resultImport = null;
        resultImport = importInstruction.importInstruction(filePath);
        if (resultImport != null) {
            for (Mobile mobile : resultImport) {
                if (mobile != null) {
                    mobile.play();
                    System.out.println(mobile.toString());
                }
            }
        } else {
            System.out.println("Nothing to move.");
        }
    }
}
