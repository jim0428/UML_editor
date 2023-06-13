package UMLFrame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import UMLCreator.CanvasSingleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UML extends JFrame {

    //private DrawingCanvas canvas;
 
    private MenuBar menubar;
    private ToolBar toolbar;
    private Canvas canvas;
    
    public UML() {
        // Create components
        //canvas = new DrawingCanvas();
    	
    	canvas =  CanvasSingleton.getCanvas();
        menubar = new MenuBar();
        toolbar = new ToolBar();
       
        this.setLayout(new BorderLayout());
        this.setJMenuBar(menubar.getJmenu());
        this.add(toolbar.getPanel(), BorderLayout.WEST);
        this.add(canvas,BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
    	
    	
        UML mainwindow = new UML();
        
        mainwindow.setTitle("Drawing Program");
        mainwindow.setSize(800, 600);
        mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainwindow.setVisible(true);
    }
    
}