/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kasra
 */
public class SudokuModel{

    private Box[][] boxes;
    private int selectedRow;
    private int selectedCol;
    
    public SudokuModel() {
        selectedRow = selectedCol = 4;
        boxes = read();
    }
    
    /**
     * Reads from file.
     * Reads a text file in the main directory called "Sudoku1.txt";
     * Will print out "Clues not found" in system.out if text file is not found.
     *
     * @return a 2D array of Boxes.
     */
    public static Box[][] read(){
        Scanner sc;
        try
        {
            sc = new Scanner( new File("Sudoku1.txt") );
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
                boxes[j][i] = parsed[j].charAt(i) == '.'
                        ?new Box( 0, false)
                        :new Box( parsed[j].charAt(i) - '0');
        }
        
        return boxes;
    }
    
    public void submit(int number) {
        Box box = boxes[selectedRow][selectedCol];
        if (box.clue) return;
        box.number = number;
        checkConflict();
    }
    
    public boolean gameOver() {
        boolean output = true;
        for (int i = 0; i < boxes.length; ++i)
            for (int j = 0; j < boxes.length; ++j)
                output = output && ((!boxes[i][j].conflict && boxes[i][j].number != 0) || boxes[i][j].clue);
        return output;
    }
    
    public void checkConflict(){
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                boxes[i][j].conflict = false;
        for (int i = 0; i < 9; ++i) {
            rowConflict(i);
            colConflict(i);
        }
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                bigConflict(i*3, j*3);
    }
    
    public void colConflict(int col) {
        for (int num = 1; num < 10; ++num){
            ArrayList<Integer> indices = new ArrayList<>();
            for (int i = 0; i < 9; ++i)
                if (boxes[i][col].number == num)
                    indices.add(i);
            if (indices.size() > 1 )
                indices.stream().forEach(i -> 
                    boxes[i][col].conflict = true);
        }
    }
    
    public void rowConflict(int row) {
        for (int num = 1; num < 10; ++num){
            ArrayList<Integer> indices = new ArrayList<>();
            for (int i = 0; i < 9; ++i)
                if (boxes[row][i].number == num)
                    indices.add(i);
            if (indices.size() > 1 )
                indices.stream().forEach(i -> 
                    boxes[row][i].conflict = true);
        }
    }
    
    public void bigConflict(int biggie, int smalls) {
        for (int num = 1; num < 10; ++num) {
            ArrayList<int[]> indices = new ArrayList<>();
            for (int i = 0; i < 3; ++i)
                for (int j = 0; j < 3; ++j)
                    if (boxes[biggie + i][smalls + j].number == num)
                        indices.add(new int[] {i, j});
            if (indices.size() > 1 )
                indices.stream().forEach(indexArr -> 
                    boxes[biggie + indexArr[0]][smalls + indexArr[1]].conflict = true);
        }
    }
    
    public Box get(int row, int col) {
        return boxes[row][col];
    }
    
    /**
     *
     * @param row
     * @param col
     */
    public void setSelected(int row, int col) {
        selectedRow = row;
        selectedCol = col;
    }
    
    /**
     *
     * @param dr
     * @param dc
     */
    public void move(int dr, int dc) {
        if (selectedRow == 0 && dr == -1) return;
        if (selectedRow == 8 && dr == 1) return;
        if (selectedCol == 0 && dc == -1) return;
        if (selectedCol == 8 && dc == 1) return;
        selectedRow += dr;
        selectedCol += dc;
    }
    
    public void updateSelection() {
        for (int i = 0; i < boxes.length; ++i)
            for (int j = 0; j < boxes[i].length; ++j)
                boxes[i][j].selected = false;
        if (selectedRow != -1 && selectedRow != -1)
            boxes[selectedRow][selectedCol].selected = true;
//        System.out.println("row:" + selectedRow + "\tcol:" + selectedCol);
        //return new int[] {selectedRow, selectedCol};
    }
}
