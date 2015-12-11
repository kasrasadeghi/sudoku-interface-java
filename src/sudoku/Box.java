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
    public boolean conflict;
    public boolean selected;
    
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
        this.selected = false;
    }
    
    /** 
     * Constructor for the primary use of in-game data entry.
     * 
     * @param number
     * @param clue if clue then clue else conflict
     */
    public Box(int number, boolean conflict) {
        this.number = number;
        this.clue = false;
        this.conflict = conflict;
        this.selected = false;
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
        this.selected = false;
    }
    
}
