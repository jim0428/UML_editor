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

public class MenuBar extends JMenuBar {
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
		
		chg_name = new JMenuItem("Change object name");
		menu_edit.add(chg_name);
		
		
		gp = new JMenuItem("Group");
		menu_edit.add(gp);
	
		
		ugp = new JMenuItem("Ungroup");
		menu_edit.add(ugp);
			
		menuBar.add(menu_edit);
	}
	
//	public void addListener(Canvas can) {
//		
//		chg_name.addActionListener(new ActionListener() {
//	        @Override
//	        public void actionPerformed(ActionEvent e) {
//	        	can.setColor(Color.BLACK);
//	        }
//	     });
//	}
	
	public JMenuBar getJmenu(){
		return menuBar;
	}
	
	
}
