package UMLFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import UMLCreator.ChangeName;
import UMLCreator.Mode;
import UMLCreator.ToGroup;
import UMLCreator.UnGroup;

public class MenuBar extends JMenuBar {
	Canvas canvas = Canvas.getCanvas();
	
	private JMenuBar menuBar;
	
	private JMenu menu_file,menu_edit;
	private JMenuItem chg_name, gp, ugp;
	
	public MenuBar() {
		menuBar = new JMenuBar();
			
		/* --- File menu --- */
		menu_file = new JMenu("File");
		menuBar.add(menu_file);

		/* --- Edit menu --- */
		menu_edit = new JMenu("Edit");
		menuBar.add(menu_edit);
		
		chg_name = new MenuItem("Change object name",new ChangeName());
		menu_edit.add(chg_name);
		
		
		gp = new MenuItem("Group",new ToGroup());
		menu_edit.add(gp);
	
		
		ugp = new MenuItem("Ungroup",new UnGroup());
		menu_edit.add(ugp);
			
		menuBar.add(menu_edit);
	}
	
	private class MenuItem extends JMenuItem{
		public MenuItem(String name,Mode mode) {
			this.setText(name);
			
			this.addMouseListener(mode);
		}
	
	}
	
	public JMenuBar getJmenu(){
		return menuBar;
	}
	
	
}
