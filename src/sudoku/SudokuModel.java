/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author kasra
 */
public class SudokuModel{

    private Box[][] boxes;
    private Integer[] selected;
    
    public SudokuModel() {
        Scanner sc;
        boxes = read();
    }
    
    public static Box[][] read(){
        Scanner sc;
        try
        {
            sc = new Scanner( new File("sudoku.txt") );
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println( "Clues not found" );
            System.exit(0);
            return null;
        }
        
        // read words from the scanner object into an array list and return the array list
        String[] parsed = new String[9];
        for (int i = 0; sc.hasNext(); ++i)
            parsed[i] = sc.next();
        
        Box[][] boxes = new Box[9][9];
        for (int i = 0; i < 9; ++i){
            for (int j = 0; j < 9; ++j)
                boxes[i][j] = new Box(parsed[i].charAt(j) == '.'?0:( parsed[i].charAt(j) - '0'), false);
        }
        
        return boxes;
    }
    
    public void submit(int number) {
    }

    public boolean rowComplete(int row) {
        
        return true;
    }

    public boolean colComplete(int col) {
        return true;
    }

    public boolean bigComplete(int index) {
        return true;
    }

    public Box get(int row, int col) {
        return boxes[row][col];
    }
    
    public void select(int row, int col) {
        if (row == selected[0] && col == selected[1])
            selected[0] = selected[1] = null;
        
    }
    
    public Integer[] getSelected() {
        return selected;
    }
}
