/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import apcscvm.DefaultControl;
import apcscvm.GraphicsUtilityFunctions;
import apcscvm.View;
import java.awt.*;
import static java.awt.Font.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author kasra
 */
public class SudokuCV extends DefaultControl<SudokuModel> implements View<SudokuModel>{

    
    
    /**
     * Main Sudoku Paint.
     * Paints everything for the sudoku board.
     * 
     * 
     * @param m
     * @param g
     * @param w
     * @param oh
     */
    @Override
    public void paint(SudokuModel m, Graphics g, int w, int oh) {
        g.setFont(new Font(SANS_SERIF, PLAIN, 50));
        int h = oh - 100;
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j) 
                paintSmallGrid(g, i*w/3, j * h/3, w/3, h/3);
        for (int i = 0; i < 9; ++i) 
            for (int j = 0; j < 9; ++j) 
                paintBox(g, i*w/9, j*h/9, m.get(i, j),w/9, h/9 );
//                System.out.println("I:" + i + "\tJ: "+ j);
        paintGrid(g, w, h);
//        g.drawString(w + ", " + oh, 150, 150);
    }
    
    /**
     * Paints the 3x3 outer grid.
     *
     * @param g
     * @param w
     * @param h
     */
    public void paintGrid(Graphics g, int w, int h) {
        g.setColor(Color.BLACK);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(0, 0, w, h);
        g2.drawRect(0, h/3, w, h/3);
        g2.drawRect(w/3, 0, w/3, h);
        g2.setStroke(new BasicStroke(1));
        
    }
    
    /**
     * Paints the inner, smaller grids.
     *
     * @param g
     * @param tlx
     * @param tly
     * @param w
     * @param h
     */
    public void paintSmallGrid(Graphics g, int tlx, int tly, int w, int h){
        g.setColor(Color.BLACK);
        g.drawRect(tlx + w/3, tly, w/3, h);
        g.drawRect(tlx, tly + h/3, w, h/3);
    }
    
    /**
     *
     * @param g graphics object
     * @param tlx top left x coordinate
     * @param tly top left y coordinate
     * @param s painted string
     * @param w width of outlying box
     * @param h height of outlying box
     */
    public void drawStringBox(Graphics g, int tlx, int tly, String s, int w, int h ){
        GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, s, g.getFont(), tlx, tly, w, h);
    }
    
    /**
     * Paints a box.
     *
     * @param g usable graphics object
     * @param tlx x-coordinate of the top left corner of the box
     * @param tly y-coordinate of the top left corner of the box
     * @param b the Box object
     * @param w
     * @param h
     */
    public void paintBox(Graphics g, int tlx, int tly, Box b, int w, int h) {
        if (b.clue) g.setColor(Color.BLACK);
        else if (b.conflict) g.setColor(Color.RED);
        else g.setColor(Color.BLUE);
        drawStringBox(g, tlx, tly, b.number + "", w, h );
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.GRAY);
        if (b.selected) g2.drawRect(tlx + 5, tly + 5, w - 10, h - 10);
        g2.setStroke(new BasicStroke(1));
    }
    
    /**
     *
     * @param model
     * @param ea
     * @param me
     */
    @Override
    public void handleMouseClick(SudokuModel model, int ea, MouseEvent me){
        
    }
    
    /**
     * Finds where the mouse is.
     *
     * @param me
     * @return
     */
    public int mousePos(MouseEvent me, int w, int h){
        
        return -1;
    }
    
    /**
     *
     * @param model
     * @param ea
     * @param ke
     */
    @Override
    public void handleKeyPress(SudokuModel model, int ea, KeyEvent ke) {
        
    }
}
