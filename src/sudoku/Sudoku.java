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
        SudokuModel m = new SudokuModel();
        SudokuCV v = new SudokuCV();
        new CVMProgram( "Sudoku", 926, 1071, v, v, m ).start();
    }
    
}
