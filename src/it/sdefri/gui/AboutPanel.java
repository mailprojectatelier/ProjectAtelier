package it.sdefri.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class AboutPanel extends JFrame{
	public AboutPanel() {
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(192, 192, 192));
		
		// setto una grandezza iniziale per la finestra
	    setPreferredSize(new Dimension(250, 250));
	    pack();
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	 
	    
	    
	    //per rendere assoluto il layout
		getContentPane().setLayout(null);
		this.setTitle("About");

		//label che mostra le info sul programma
		JLabel textAreaAbout = new JLabel("<html><b><u><center>POWERED BY</u><br>FABRIZIO RAPETTI"
				+ "<br><center>&<br>SILVIA GIUSTI</center><br><center>2017</center></b>");
		textAreaAbout.setBackground(new Color(192, 192, 192));
		textAreaAbout.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaAbout.setBounds(0, 0, 234, 211);
		getContentPane().add(textAreaAbout);
	}
}
