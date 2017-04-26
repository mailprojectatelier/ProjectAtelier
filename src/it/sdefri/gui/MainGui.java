package it.sdefri.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class MainGui extends JFrame{
	private SettingPanel settingPanel;
	private AboutPanel aboutPanel;
	private IncaricoLocazionePanel incaricoLocazionePanel;
	
	public MainGui() {
		setFont(new Font("Calibri Light", Font.PLAIN, 12));
		getContentPane().setEnabled(false);
		getContentPane().setBackground(new Color(192, 192, 192));
		
		
		// setto una grandezza iniziale per la finestra
		setPreferredSize(new Dimension(800, 600));
	    pack();
	    setLocationRelativeTo(null);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		this.setTitle("L'Atelier project v1.0");
		
		//creazione e setting bottoni
		JButton btnIncaricoLocazione = new JButton("Incarico di Locazione");
		btnIncaricoLocazione.setToolTipText("Stipula un nuovo contratto di Locazione");
		btnIncaricoLocazione.setBackground(SystemColor.control);
		btnIncaricoLocazione.setFont(new Font("Calibri Light", Font.BOLD, 11));
		btnIncaricoLocazione.setBounds(26, 103, 148, 77);
		getContentPane().add(btnIncaricoLocazione);
		//associo l'azione che mi fa aprire il frame per il contratto selezionato
		btnIncaricoLocazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apre la label settings (evitando di poterla aprire più volte)
				if (incaricoLocazionePanel != null) {
					incaricoLocazionePanel.setVisible( true );
					
				} else {
					incaricoLocazionePanel = new IncaricoLocazionePanel();
					incaricoLocazionePanel.setVisible(true);
						}	
				
			}
		});
		
		
		JButton btnIncaricoVendita = new JButton("Incarico di Vendita");
		btnIncaricoVendita.setFont(new Font("Calibri Light", Font.BOLD, 11));
		btnIncaricoVendita.setBackground(SystemColor.control);
		btnIncaricoVendita.setBounds(311, 103, 148, 77);
		getContentPane().add(btnIncaricoVendita);
		
		JButton button_1 = new JButton("New button");
		button_1.setFont(new Font("Calibri Light", Font.BOLD, 11));
		button_1.setBackground(SystemColor.control);
		button_1.setBounds(598, 103, 148, 77);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setFont(new Font("Calibri Light", Font.BOLD, 11));
		button_2.setBackground(SystemColor.control);
		button_2.setBounds(26, 264, 148, 77);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setFont(new Font("Calibri Light", Font.BOLD, 11));
		button_3.setBackground(SystemColor.control);
		button_3.setBounds(26, 431, 148, 74);
		getContentPane().add(button_3);
		
		JButton button_5 = new JButton("New button");
		button_5.setFont(new Font("Calibri Light", Font.BOLD, 11));
		button_5.setBackground(SystemColor.control);
		button_5.setBounds(311, 264, 148, 77);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setFont(new Font("Calibri Light", Font.BOLD, 11));
		button_6.setBackground(SystemColor.control);
		button_6.setBounds(598, 264, 148, 77);
		getContentPane().add(button_6);
		
		//scritta in alto
		JLabel lblSelezionaIlContratto = new JLabel("<html><b>[<u>SELEZIONA IL CONTRATTO</u>]</b>");
		lblSelezionaIlContratto.setForeground(new Color(204, 0, 102));
		lblSelezionaIlContratto.setFont(new Font("Calibri Light", Font.BOLD, 40));
		lblSelezionaIlContratto.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelezionaIlContratto.setBounds(112, 11, 565, 52);
		getContentPane().add(lblSelezionaIlContratto);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Calibri Light", Font.BOLD, 19));
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(192, 192, 192));
		menuBar.setBounds(0, 0, 45, 28);
		getContentPane().add(menuBar);
		
		
		//menù e item con relative azioni
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(new Color(192, 192, 192));
		mnFile.setFont(new Font("Calibri Light", Font.BOLD, 18));
		menuBar.add(mnFile);
		mnFile.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenuItem menuItemSettings = new JMenuItem("Settings");
		menuItemSettings.setFont(new Font("Calibri Light", Font.BOLD, 12));
		menuItemSettings.setIcon(new ImageIcon(MainGui.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		mnFile.add(menuItemSettings);
		menuItemSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apre la label settings (evitando di poterla aprire più volte)
				if (settingPanel != null) {
					settingPanel.setVisible( true );
					
				} else {
					settingPanel = new SettingPanel();
					settingPanel.setVisible(true);
						}	
				
			}
		});
		
		JMenuItem menuItemAbout = new JMenuItem("About");
		menuItemAbout.setFont(new Font("Calibri Light", Font.BOLD, 12));
		menuItemAbout.setIcon(new ImageIcon(MainGui.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mnFile.add(menuItemAbout);
		menuItemAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//apre la label about (evitando di poterla aprire più volte)
				if (aboutPanel != null) {
					aboutPanel.setVisible( true );
					
				} else {
						aboutPanel = new AboutPanel();
						aboutPanel.setVisible(true);
						}				
			}
		});
		
		
		
		//inserisco il logo aziendale in una label a fondo pagina
		JLabel logoLabel = new JLabel("");
		Image logoAziendale = new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		logoLabel.setIcon(new ImageIcon(logoAziendale));
		logoLabel.setBounds(430, 450, 344, 100);
		getContentPane().add(logoLabel);
		
		
		
		
		
	}
	
		 
		 
	
	//main di prova
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                MainGui frame = new MainGui();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
}


