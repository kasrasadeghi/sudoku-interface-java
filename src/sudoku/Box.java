/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author kasra
 */
public class Box {
    public boolean clue;
    public int number;
    private boolean conflict;
    
    /** 
     * Constructor for Boxes for the initialization of the board. 
     * Assumes boxes that are made with this method are clues on the board that
     * are non-conflicting.
     *
     * @param number
     */
    public Box(int number) {
        this.number = number;
        this.clue = true;
        this.conflict = false;
    }
    
    /** 
     * Constructor for the primary use of in-game data entry.
     * 
     * @param number
     * @param clue
     */
    public Box(int number, boolean clue) {
        this.number = number;
        this.clue = clue;
        this.conflict = checkConflict();
    }
    
    /**
     * Constructor for boxes of known conflict.
     * I'm not sure if I'll ever need this.
     *
     * @param number
     * @param clue
     * @param conflict
     */
    public Box(int number, boolean clue, boolean conflict) {
        this.number = number;
        this.clue = clue;
        this.conflict = conflict;
    }
    
    /**
     * Checks whether there is a conflict or something... I dunno. I'll see how 
     * I write the rest of the code.
     *
     * @return
     */
    public static /*maybe private?*/ boolean checkConflict() {
        return false;
    }
}
