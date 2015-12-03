/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import apcscvm.CVMProgram;

/**
 *
 * @author kasra
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SudokuModelImpl m = new SudokuModelImpl();
        SudokuCV v = new SudokuCV();
        new CVMProgram( "Word Twist", 800, 600, v, v, m ).start();
    }
    
}
