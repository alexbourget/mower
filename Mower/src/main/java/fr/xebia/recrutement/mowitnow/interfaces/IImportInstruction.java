package fr.xebia.recrutement.mowitnow.interfaces;

import java.util.List;

import fr.xebia.recrutement.mowitnow.entities.Mobile;

/**
 * Instruction is an interface for importing instructions.
 * @author Alexandre Bourget
 *
 */
public interface IImportInstruction {
    /**
     * importInstruction method import instruction to parse
     * initialization informations for a surface,
     * and at least one mower and his move sequence.
     * @param filePath The file's path to import.
     * @return a mobiles list
     * @throws Exception Exception raised on syntax error.
     */
    List<Mobile> importInstruction(String filePath) throws Exception;
}
