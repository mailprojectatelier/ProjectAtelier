package it.sdefri.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

public class SettingPanel extends JFrame{
	
	
	
	public SettingPanel(){
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(192, 192, 192));
		
		// setto una grandezza iniziale per la finestra
	    setPreferredSize(new Dimension(700, 300));
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
		
		setBackground(Color.LIGHT_GRAY);
		
		this.setTitle("Setting");
		getContentPane().setLayout(null);
		
		//bottone di ricerca
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBounds(543, 115, 89, 23);
		getContentPane().add(btnCerca);
		
		//relativa label
		JTextArea txtrInserisciIlPercorso = new JTextArea();
		txtrInserisciIlPercorso.setBackground(new Color(192, 192, 192));
		txtrInserisciIlPercorso.setEditable(false);
		txtrInserisciIlPercorso.setFont(new Font("Calibri Light", Font.BOLD, 13));
		txtrInserisciIlPercorso.setText("Inserisci il percorso dove si trovano i documenti degli incarichi");
		txtrInserisciIlPercorso.setBounds(58, 116, 423, 22);
		getContentPane().add(txtrInserisciIlPercorso);
		
		//titolo interno della label
		JTextArea titoloSettings = new JTextArea();
		titoloSettings.setFont(new Font("Calibri Light", Font.BOLD, 30));
		titoloSettings.setBackground(new Color(192, 192, 192));
		titoloSettings.setEditable(false);
		titoloSettings.setText("[ SETTINGS ]");
		titoloSettings.setBounds(243, 40, 256, 41);
		getContentPane().add(titoloSettings);
		
		
		//icona a fondo pagina
		JLabel labelIcona = new JLabel("");
		Image iconaAziendaleSettings = new ImageIcon(this.getClass().getResource("/icona.png")).getImage();
		labelIcona.setIcon(new ImageIcon(iconaAziendaleSettings));
		labelIcona.setBackground(SystemColor.control);
		labelIcona.setBounds(10, 188, 101, 73);
		getContentPane().add(labelIcona);
	}
}
