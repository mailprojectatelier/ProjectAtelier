package it.sdefri.gui;


import java.awt.*;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import it.sdefri.utils.DateLabelFormatter;



public class IncaricoLocazionePanel extends JFrame{
	
	//dichiarazioni iniziali di variabili
	private JTextArea numeroContratto;
	private JDatePickerImpl dataContratto;
	private JTextArea nome;
	private JTextArea codFiscale;
	private JTextArea natoA;
	private JTextArea provinciaNascita;
	private JDatePickerImpl dataNascita;
	private JTextArea luogoRes;
	private JTextArea provRes;
	private JTextArea viaRes;
	private JTextArea civicoRes;
	private JTextArea cap;
	private JTextArea telCasa;
	private JTextArea cellulare;
	private JTextArea email;
	private JTextArea inQualitaDi;
	private JTextArea comuneLocazione;
	private JTextArea provLocazione;
	private JTextArea viaLocazione;
	private JTextArea civLocazione;
	private JTextArea piano;
	private JTextArea scala;
	private JTextArea interno;
	private JTextArea descrizioneLocazione;
	private JTextArea destinazioneUso;
	private JPanel dettagliContratto;
	private JPanel datiAnagrafici;
	private SpringLayout springLayout;
	private JDatePickerImpl dataContrattoDa;
	private JDatePickerImpl dataContrattoA;
	private JTextArea tipoContratto;
	private JTextArea durataDelContratto;
	private JTextArea canoneLocazioneAnnuoLettere;
	private JTextArea numeroRate;
	private JTextArea daCorrispondereIlGiorno;
	private JTextArea iban;
	private JTextArea intestatarioCC;
	private JTextArea nomeBanca;
	private JTextArea contoCorrente;
	private JTextArea speseCaricoConduttore;
	private JTextArea mensilitaCauzione;
	private JCheckBox checkboxInData;
	private JCheckBox checkboxSottoscrizioneContratto;
	private JTextArea altreGaranzie;
	private JDatePickerImpl dataConsImm;
	private JTextArea giorniVisitaImpegnoLocatoreDaOra;
	private JTextArea giorniVisitaAOra;
	private JTextArea giorniVisitaImpegnoLocatore;
	private JTextArea giorniVisita;
	private JTextArea giorniVisitaDaOra;
	private JTextArea giorniVisitaImpegnoLocatoreAOra;
	private JCheckBox checkBoxCompensoPariA;
	private JCheckBox checkboxAForfait;
	private JTextArea percCanoneAnnuale;
	private JTextArea percCanAnnualeLettere;
	private JTextArea euroForfait;
	private JTextArea euroForfaitLettere;
	private JTextArea sottoscrizioneContrattoPresso;
	private JTextArea noteAggiuntive;
	private JDatePickerImpl dataSottContr;
	
	
	public IncaricoLocazionePanel() {
		
		// setto una grandezza iniziale per la finestra (della dimensione dello schermo
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	    setLocationRelativeTo(null);
	    setVisible(true);
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		setTitle("Incarico di Locazione");
		setFont(new Font("Calibri Light", Font.PLAIN, 12));
		setAlwaysOnTop(true);
		
		//titolo nella finestra
		JLabel labelIncarLocaz = new JLabel("[ INCARICO DI LOCAZIONE ]");
		labelIncarLocaz.setHorizontalAlignment(SwingConstants.CENTER);
		labelIncarLocaz.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelIncarLocaz.setBackground(new Color(192, 192, 192));
		labelIncarLocaz.setBounds(10, 11, 1340, 54);
		getContentPane().add(labelIncarLocaz);
		
		
		
		
		
		
		
		//[ CREO I VARI CAMPI DA COMPILARE CON I RELATIVI BORDI ]
		
		
		
		
		
		//pannello in cui inserisco i dettagli del contratto
		TitledBorder titleDettContratto;
		titleDettContratto = BorderFactory.createTitledBorder("Dettagli Contratto");
		titleDettContratto.setTitlePosition(TitledBorder.ABOVE_TOP);
		dettagliContratto = new JPanel();
		dettagliContratto.setToolTipText("Dati Generali del Contratto");
		dettagliContratto.setBackground(new Color(192, 192, 192));
		dettagliContratto.setBounds(43, 76, 182, 130);
		getContentPane().add(dettagliContratto);
		dettagliContratto.setLayout(null);
		dettagliContratto.setBorder(titleDettContratto);
		
		
		
		//numero contratto
		TitledBorder titleNumeroContratto;
		titleNumeroContratto = BorderFactory.createTitledBorder("Numero Contratto");
		titleNumeroContratto.setTitlePosition(TitledBorder.ABOVE_TOP);
		setResizable(false);
		numeroContratto = new JTextArea();
		numeroContratto.setBounds(10, 21, 161, 38);
		numeroContratto.setBackground(new Color(255, 255, 255));
		numeroContratto.setColumns(10);
		numeroContratto.setBorder(titleNumeroContratto);
		
		
		
		//data contratto
		TitledBorder titleDataContratto;
		titleDataContratto = BorderFactory.createTitledBorder("Data Contratto");
		titleDataContratto.setTitlePosition(TitledBorder.ABOVE_TOP);		
		//setto nella text area il calendario per far scegliere le date
		UtilDateModel model = new UtilDateModel(); 
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		setResizable(false);
		dataContratto = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		dataContratto.setBounds(10, 70, 161, 49);
		dataContratto.setBorder(titleDataContratto);
	
		
		//aggiungo gli elementi i dettaglio contratto al contenitore
		dettagliContratto.add(numeroContratto);
		dettagliContratto.add(dataContratto);
		
		
		
		//pannello contenitore per i dati anagrafici
		TitledBorder titleDatAnaContratto;
		titleDatAnaContratto = BorderFactory.createTitledBorder("Dati Anagrafici");
		titleDatAnaContratto.setTitlePosition(TitledBorder.ABOVE_TOP);
		datiAnagrafici = new JPanel();
		datiAnagrafici.setToolTipText("Dati Anagrafici");
		datiAnagrafici.setBackground(new Color(192, 192, 192));
		datiAnagrafici.setBounds(252, 76, 1063, 130);
		getContentPane().add(datiAnagrafici);
		datiAnagrafici.setBorder(titleDatAnaContratto);
		
		
		//nome
		TitledBorder titleNome;
		titleNome = BorderFactory.createTitledBorder("Nome");
		titleNome.setTitlePosition(TitledBorder.ABOVE_TOP);
		nome = new JTextArea();
		nome.setColumns(10);
		nome.setBackground(Color.WHITE);
		nome.setBounds(43, 24, 139, 46);
		setResizable(false);
		nome.setBorder(titleNome);
		
		//CF
		TitledBorder titleCF;
		titleCF = BorderFactory.createTitledBorder("Cod. Fiscale");
		titleCF.setTitlePosition(TitledBorder.ABOVE_TOP);
		codFiscale = new JTextArea();
		codFiscale.setColumns(10);
		codFiscale.setBackground(Color.WHITE);
		codFiscale.setBounds(213, 24, 120, 46);
		setResizable(false);
		codFiscale.setBorder(titleCF);
		
		//nato a
		TitledBorder titleNatoA;
		titleNatoA = BorderFactory.createTitledBorder("Nato/a a");
		titleNatoA.setTitlePosition(TitledBorder.ABOVE_TOP);
		natoA = new JTextArea();
		natoA.setColumns(10);
		natoA.setBackground(Color.WHITE);
		natoA.setBounds(365, 24, 109, 46);
		setResizable(false);
		natoA.setBorder(titleNatoA);
		
		//provincia
		TitledBorder titelProvinciaN;
		titelProvinciaN = BorderFactory.createTitledBorder("Prov.");
		titelProvinciaN.setTitlePosition(TitledBorder.ABOVE_TOP);
		provinciaNascita = new JTextArea();
		provinciaNascita.setColumns(2);
		provinciaNascita.setBackground(Color.WHITE);
		provinciaNascita.setBounds(502, 24, 48, 46);
		setResizable(false);
		provinciaNascita.setBorder(titelProvinciaN);
		
		//data nascita
		TitledBorder titleDataNascita;
		titleDataNascita = BorderFactory.createTitledBorder("Data di Nascita");
		titleDataNascita.setTitlePosition(TitledBorder.ABOVE_TOP);		
		//setto nella text area il calendario per far scegliere le date
		UtilDateModel modelNascita = new UtilDateModel(); 
		Properties pNasc = new Properties();
		pNasc.put("text.today", "Today");
		pNasc.put("text.month", "Month");
		pNasc.put("text.year", "Year");
		JDatePanelImpl datePanelNascita = new JDatePanelImpl(modelNascita, pNasc);
		dataNascita = new JDatePickerImpl(datePanelNascita, new DateLabelFormatter());
		springLayout = (SpringLayout) dataNascita.getLayout();
		dataNascita.setLocation(578, 24);
		dataNascita.setSize(139, 46);
		dataNascita.setBorder(titleDataNascita);
		setResizable(false);
		
		
		//residente a
		TitledBorder titleResidenteA;
		titleResidenteA = BorderFactory.createTitledBorder("Residente a");
		titleResidenteA.setTitlePosition(TitledBorder.ABOVE_TOP);
		luogoRes = new JTextArea();
		luogoRes.setColumns(10);
		luogoRes.setBackground(Color.WHITE);
		luogoRes.setBounds(854, 24, 109, 46);
		setResizable(false);
		luogoRes.setBorder(titleResidenteA);
			
		//provincia residenza
		TitledBorder titelProvinciaR;
		titelProvinciaR = BorderFactory.createTitledBorder("Prov.");
		titelProvinciaR.setTitlePosition(TitledBorder.ABOVE_TOP);
		provRes = new JTextArea();
		provRes.setColumns(2);
		provRes.setBackground(Color.WHITE);
		provRes.setBounds(985, 24, 54, 46);
		setResizable(false);
		provRes.setBorder(titelProvinciaR);
		
		
		//via residenza
		TitledBorder titleViaRes;
		titleViaRes = BorderFactory.createTitledBorder("Via");
		titleViaRes.setTitlePosition(TitledBorder.ABOVE_TOP);
		viaRes = new JTextArea();
		viaRes.setColumns(10);
		viaRes.setBackground(Color.WHITE);
		viaRes.setBounds(43, 81, 139, 38);
		setResizable(false);
		viaRes.setBorder(titleViaRes);
		
		//civico residenza
		TitledBorder titleCivRes;
		titleCivRes = BorderFactory.createTitledBorder("N°");
		titleCivRes.setTitlePosition(TitledBorder.ABOVE_TOP);
		civicoRes = new JTextArea();
		civicoRes.setColumns(10);
		civicoRes.setBackground(Color.WHITE);
		civicoRes.setBounds(213, 81, 42, 38);
		setResizable(false);
		civicoRes.setBorder(titleCivRes);
		
		//cap
		TitledBorder titleCap;
		titleCap = BorderFactory.createTitledBorder("CAP");
		titleCap.setTitlePosition(TitledBorder.ABOVE_TOP);
		cap = new JTextArea();
		cap.setColumns(10);
		cap.setBackground(Color.WHITE);
		cap.setBounds(282, 81, 96, 39);
		cap.setBorder(titleCap);
		
		//telefono casa
		TitledBorder titleTelCasa;
		titleTelCasa = BorderFactory.createTitledBorder("Telefono fisso");
		titleTelCasa.setTitlePosition(TitledBorder.ABOVE_TOP);
		telCasa = new JTextArea();
		telCasa.setColumns(10);
		telCasa.setBackground(Color.WHITE);
		telCasa.setBounds(472, 81, 96, 39);
		telCasa.setBorder(titleTelCasa);
		
		//cellulare
		TitledBorder titleCell;
		titleCell = BorderFactory.createTitledBorder("Cellulare");
		titleCell.setTitlePosition(TitledBorder.ABOVE_TOP);
		cellulare = new JTextArea();
		cellulare.setColumns(10);
		cellulare.setBackground(Color.WHITE);
		cellulare.setBounds(588, 81, 96, 39);
		cellulare.setBorder(titleCell);
		
		//email
		TitledBorder titleEmail;
		titleEmail = BorderFactory.createTitledBorder("Email");
		titleEmail.setTitlePosition(TitledBorder.ABOVE_TOP);
		email = new JTextArea();
		email.setColumns(10);
		email.setBackground(Color.WHITE);
		email.setBounds(706, 81, 96, 39);
		email.setBorder(titleEmail);
		
		
		//in qualità di
		TitledBorder titleInQualitaDi;
		titleInQualitaDi = BorderFactory.createTitledBorder("In Qualità di");
		titleInQualitaDi.setTitlePosition(TitledBorder.ABOVE_TOP);
		inQualitaDi = new JTextArea();
		inQualitaDi.setColumns(10);
		inQualitaDi.setBackground(Color.WHITE);
		inQualitaDi.setBounds(854, 81, 185, 39);
		inQualitaDi.setBorder(titleInQualitaDi);
		datiAnagrafici.setLayout(null);
		
		//aggiungo gli elementi relativi ai dati anagrafici nel contenitore
		datiAnagrafici.add(nome);
		datiAnagrafici.add(codFiscale);
		datiAnagrafici.add(natoA);
		datiAnagrafici.add(provinciaNascita);
		datiAnagrafici.add(dataNascita);
		datiAnagrafici.add(luogoRes);
		datiAnagrafici.add(provRes);
		datiAnagrafici.add(viaRes);
		datiAnagrafici.add(civicoRes);
		datiAnagrafici.add(cap);
		datiAnagrafici.add(telCasa);
		datiAnagrafici.add(cellulare);
		datiAnagrafici.add(email);
		datiAnagrafici.add(inQualitaDi);
		
		
		
		
		
		
		// 1) il contenitore che delimita la parte di incarico
		TitledBorder titleIncarico;
		titleIncarico = BorderFactory.createTitledBorder("1) Incarico");
		titleIncarico.setTitlePosition(TitledBorder.ABOVE_TOP);
		JPanel contenitoreLocazione = new JPanel();
		contenitoreLocazione.setBackground(new Color(192, 192, 192));
		contenitoreLocazione.setToolTipText("parte dedicata alla locazione");
		contenitoreLocazione.setBounds(44, 237, 1006, 161);
		getContentPane().add(contenitoreLocazione);
		contenitoreLocazione.setBorder(titleIncarico);
		
		//comune di locazione
		TitledBorder titleComuneLoc;
		titleComuneLoc = BorderFactory.createTitledBorder("Immobile nel comune di");
		titleComuneLoc.setTitlePosition(TitledBorder.ABOVE_TOP);
		comuneLocazione = new JTextArea();
		comuneLocazione.setColumns(10);
		comuneLocazione.setBackground(Color.WHITE);
		comuneLocazione.setBounds(10, 21, 157, 39);
		comuneLocazione.setBorder(titleComuneLoc);
		
		//provincia di locazione
		TitledBorder titleProvLoc;
		titleProvLoc = BorderFactory.createTitledBorder("Prov.");
		titleProvLoc.setTitlePosition(TitledBorder.ABOVE_TOP);
		
		
		//indirizzo di locazione
		TitledBorder titleViaLoc;
		titleViaLoc = BorderFactory.createTitledBorder("Situato in via");
		titleViaLoc.setTitlePosition(TitledBorder.ABOVE_TOP);
		viaLocazione = new JTextArea();
		viaLocazione.setColumns(10);
		viaLocazione.setBackground(Color.WHITE);
		viaLocazione.setBounds(397, 21, 209, 39);
		viaLocazione.setBorder(titleViaLoc);
		
		//civico di locazione
		TitledBorder titleCivLoc;
		titleCivLoc = BorderFactory.createTitledBorder("N°");
		titleCivLoc.setTitlePosition(TitledBorder.ABOVE_TOP);
		civLocazione = new JTextArea();
		civLocazione.setColumns(10);
		civLocazione.setBackground(Color.WHITE);
		civLocazione.setBounds(647, 21, 56, 39);
		civLocazione.setBorder(titleCivLoc);
		
		//piano
		TitledBorder titlePiano;
		titlePiano = BorderFactory.createTitledBorder("Piano");
		titlePiano.setTitlePosition(TitledBorder.ABOVE_TOP);
		piano = new JTextArea();
		piano.setColumns(10);
		piano.setBackground(Color.WHITE);
		piano.setBounds(740, 21, 63, 39);
		piano.setBorder(titlePiano);
		
		//scala
		TitledBorder titleScala;
		titleScala = BorderFactory.createTitledBorder("Scala");
		titleScala.setTitlePosition(TitledBorder.ABOVE_TOP);
		scala = new JTextArea();
		scala.setColumns(10);
		scala.setBackground(Color.WHITE);
		scala.setBounds(840, 21, 63, 39);
		scala.setBorder(titleScala);
		
		//interno
		TitledBorder titleInterno;
		titleInterno = BorderFactory.createTitledBorder("Interno");
		titleInterno.setTitlePosition(TitledBorder.ABOVE_TOP);
		interno = new JTextArea();
		interno.setColumns(10);
		interno.setBackground(Color.WHITE);
		interno.setBounds(932, 21, 63, 39);
		interno.setBorder(titleInterno);
		
		//descrizione locazione
		TitledBorder titleDescLoc;
		titleDescLoc = BorderFactory.createTitledBorder("Così descritto: ");
		titleDescLoc.setTitlePosition(TitledBorder.ABOVE_TOP);
		descrizioneLocazione = new JTextArea();
		descrizioneLocazione.setColumns(10);
		descrizioneLocazione.setBackground(Color.WHITE);
		descrizioneLocazione.setBounds(10, 75, 693, 69);
		descrizioneLocazione.setBorder(titleDescLoc);
		
		//destinazione d'uso
		TitledBorder titleDestUso;
		titleDestUso = BorderFactory.createTitledBorder("Destinazione d'Uso");
		titleDestUso.setTitlePosition(TitledBorder.ABOVE_TOP);
		destinazioneUso = new JTextArea();
		destinazioneUso.setBounds(740, 75, 255, 39);
		destinazioneUso.setColumns(10);
		destinazioneUso.setBackground(Color.WHITE);
		destinazioneUso.setBorder(titleDestUso);
		
		//checkbox arredato
		JCheckBox arredato = new JCheckBox("Arredato");
		arredato.setBounds(740, 121, 69, 23);
		
		//checkbox non arredato
		JCheckBox nonArredato = new JCheckBox("Non Arredato");
		nonArredato.setBounds(834, 121, 69, 23);
		
		//checkbox semiarredato
		JCheckBox semiarredato = new JCheckBox("SemiArredato");
		semiarredato.setBounds(926, 121, 69, 23);
		contenitoreLocazione.setLayout(null);
		
		
		//metto tutti gli elementi locazione nel contenitore locazione
		contenitoreLocazione.add(comuneLocazione);
		contenitoreLocazione.add(viaLocazione);
		contenitoreLocazione.add(civLocazione);
		contenitoreLocazione.add(piano);
		contenitoreLocazione.add(scala);
		contenitoreLocazione.add(interno);
		contenitoreLocazione.add(descrizioneLocazione);
		provLocazione = new JTextArea();
		provLocazione.setColumns(2);
		provLocazione.setBackground(Color.WHITE);
		provLocazione.setBounds(210, 21, 56, 39);
		provLocazione.setBorder(titleProvLoc);
		contenitoreLocazione.add(provLocazione);
		contenitoreLocazione.add(destinazioneUso);
		contenitoreLocazione.add(arredato);
		contenitoreLocazione.add(nonArredato);
		contenitoreLocazione.add(semiarredato);
		
	
		
		
		//contenitore della parte 2) durata dell'incarico
		TitledBorder titleDurataInc;
		titleDurataInc = BorderFactory.createTitledBorder("2) Durata dell'Incarico");
		titleDurataInc.setTitlePosition(TitledBorder.ABOVE_TOP);
		
		
		//data inizio contratto
		TitledBorder titleDataContrattoDa;
		titleDataContrattoDa = BorderFactory.createTitledBorder("Dal");
		titleDataContrattoDa.setTitlePosition(TitledBorder.ABOVE_TOP);		
		//setto nella text area il calendario per far scegliere le date
		UtilDateModel modelDataContrattoDa = new UtilDateModel(); 
		Properties pContDa = new Properties();
		pContDa.put("text.today", "Today");
		pContDa.put("text.month", "Month");
		pContDa.put("text.year", "Year");
		JDatePanelImpl datePanelContrattoDa = new JDatePanelImpl(modelDataContrattoDa, pContDa);
		datePanelContrattoDa.setBounds(0, 68, 150, -68);
		setResizable(false);
		
		//data fine contratto
	
		TitledBorder titleDataContrattoA;
		titleDataContrattoA = BorderFactory.createTitledBorder("Al");
		titleDataContrattoA.setTitlePosition(TitledBorder.ABOVE_TOP);		
		//setto nella text area il calendario per far scegliere le date
		UtilDateModel modelDataContrattoA = new UtilDateModel(); 
		Properties pContA = new Properties();
		pContA.put("text.today", "Today");
		pContA.put("text.month", "Month");
		pContA.put("text.year", "Year");
		JDatePanelImpl datePanelContrattoA = new JDatePanelImpl(modelDataContrattoA, pContA);
		datePanelContrattoA.setBounds(0, 62, 60, -62);
		setResizable(false);
		
		JPanel durataIncaricoConten = new JPanel();
		durataIncaricoConten.setBounds(1133, 237, 182, 161);
		getContentPane().add(durataIncaricoConten);
		durataIncaricoConten.setBackground(new Color(192, 192, 192));
		durataIncaricoConten.setToolTipText("Periodo di Durata dell'Incarico");
		durataIncaricoConten.setLayout(null);
		durataIncaricoConten.setBorder(titleDurataInc);
		dataContrattoA = new JDatePickerImpl(datePanelContrattoA, new DateLabelFormatter());
		springLayout = (SpringLayout) dataContrattoA.getLayout();
		dataContrattoA.setLocation(10, 80);
		dataContrattoA.setSize(162, 46);
		dataContrattoA.setBorder(titleDataContrattoA);
		durataIncaricoConten.add(dataContrattoA);
		dataContrattoDa = new JDatePickerImpl(datePanelContrattoDa, new DateLabelFormatter());
		dataContrattoDa.setBounds(10, 21, 162, 46);
		durataIncaricoConten.add(dataContrattoDa);
		springLayout = (SpringLayout) dataContrattoDa.getLayout();
		dataContrattoDa.setBorder(titleDataContrattoDa);
		
		
		
		
		//contenitore della parte 3) contenuto dell'incarico
		TitledBorder titleContenutoInc;
		titleContenutoInc = BorderFactory.createTitledBorder("3) Contenuto dell'Incarico");
		titleContenutoInc.setTitlePosition(TitledBorder.ABOVE_TOP);
		JPanel contenutoIncaricoContenitore = new JPanel();
		contenutoIncaricoContenitore.setToolTipText("Dettagli del Contenuto dell'Incarico");
		contenutoIncaricoContenitore.setBackground(new Color(192, 192, 192));
		contenutoIncaricoContenitore.setBounds(43, 409, 1272, 167);
		getContentPane().add(contenutoIncaricoContenitore);
		contenutoIncaricoContenitore.setLayout(null);
		contenutoIncaricoContenitore.setBorder(titleContenutoInc);
		
		
		
		//tipologia contratto
		TitledBorder titleTipoContratto;
		titleTipoContratto = BorderFactory.createTitledBorder("Tipologia Contratto");
		titleTipoContratto.setTitlePosition(TitledBorder.ABOVE_TOP);
		tipoContratto = new JTextArea();
		tipoContratto.setBounds(10, 14, 145, 44);
		tipoContratto.setColumns(10);
		tipoContratto.setBorder(titleTipoContratto);
		
		//durata del contratto
		TitledBorder titleDurataContratto;
		titleDurataContratto = BorderFactory.createTitledBorder("Durata Contratto");
		titleDurataContratto.setTitlePosition(TitledBorder.ABOVE_TOP);
		durataDelContratto = new JTextArea();
		durataDelContratto.setBounds(208, 14, 116, 39);	
		durataDelContratto.setColumns(10);
		durataDelContratto.setBorder(titleDurataContratto);
		
		
		//canone annuo di locazione in euro
		TitledBorder titleCanLocEuroContratto;
		titleCanLocEuroContratto = BorderFactory.createTitledBorder("C.L.A. €");
		titleCanLocEuroContratto.setTitlePosition(TitledBorder.ABOVE_TOP);
		JFormattedTextField canoneLocAnnuoEuro = new JFormattedTextField();
		canoneLocAnnuoEuro.setBounds(395, 14, 98, 39);
		canoneLocAnnuoEuro.setBorder(titleCanLocEuroContratto);
		
		
		//canone annuo di locazione in lettere
		TitledBorder titleCanLocLettereContratto;
		titleCanLocLettereContratto = BorderFactory.createTitledBorder("(In Lettere)");
		titleCanLocLettereContratto.setTitlePosition(TitledBorder.ABOVE_TOP);
		canoneLocazioneAnnuoLettere = new JTextArea();
		canoneLocazioneAnnuoLettere.setBounds(555, 14, 116, 39);
		canoneLocazioneAnnuoLettere.setColumns(10);
		canoneLocazioneAnnuoLettere.setBorder(titleCanLocLettereContratto);
		
		//numero rate mensili
		TitledBorder titleNumeroRateMensili;
		titleNumeroRateMensili = BorderFactory.createTitledBorder("Nr. Rate Mensili");
		titleNumeroRateMensili.setTitlePosition(TitledBorder.ABOVE_TOP);
		numeroRate = new JTextArea();
		numeroRate.setBounds(738, 14, 98, 39);
		numeroRate.setColumns(10);
		numeroRate.setBorder(titleNumeroRateMensili);
		
		//da corrispondere il giorno
		TitledBorder titleDataCorrispondenzaRate;
		titleDataCorrispondenzaRate = BorderFactory.createTitledBorder("Da Corr. Il Giorno");
		titleDataCorrispondenzaRate.setTitlePosition(TitledBorder.ABOVE_TOP);
		daCorrispondereIlGiorno = new JTextArea();
		daCorrispondereIlGiorno.setBounds(920, 14, 107, 39);
		daCorrispondereIlGiorno.setColumns(10);
		daCorrispondereIlGiorno.setBorder(titleDataCorrispondenzaRate);
		
		
		//checkbox presso domicilio
		JCheckBox pressoDomicilioCheckbox = new JCheckBox("Presso Domicilio");
		pressoDomicilioCheckbox.setBounds(1094, 14, 145, 39);
		
		//checkbox presso banca
		JCheckBox pressoBancaCheckbox = new JCheckBox("Presso Bonfifico Bancario");
		pressoBancaCheckbox.setBounds(10, 64, 145, 44);
		
		//iban
		TitledBorder titleIban;
		titleIban = BorderFactory.createTitledBorder("IBAN");
		titleIban.setTitlePosition(TitledBorder.ABOVE_TOP);
		iban = new JTextArea();
		iban.setBounds(208, 64, 285, 44);
		contenutoIncaricoContenitore.add(iban);
		iban.setColumns(10);
		iban.setBorder(titleIban);
		
		//intestatario CC
		TitledBorder titleIntestatarioCC;
		titleIntestatarioCC = BorderFactory.createTitledBorder("Intestato a");
		titleIntestatarioCC.setTitlePosition(TitledBorder.ABOVE_TOP);
		intestatarioCC = new JTextArea();
		intestatarioCC.setBounds(555, 64, 116, 44);
		intestatarioCC.setBorder(titleIntestatarioCC);
		intestatarioCC.setColumns(10);
		
		//presso l'istituto di credito
		TitledBorder titleNomeBanca;
		titleNomeBanca = BorderFactory.createTitledBorder("Presso l'Istituto");
		titleNomeBanca.setTitlePosition(TitledBorder.ABOVE_TOP);
		nomeBanca = new JTextArea();
		nomeBanca.setBounds(738, 64, 98, 44);
		nomeBanca.setColumns(10);
		nomeBanca.setBorder(titleNomeBanca);
		
		//numero CC
		TitledBorder titleCC;
		titleCC = BorderFactory.createTitledBorder("C/C");
		titleCC.setTitlePosition(TitledBorder.ABOVE_TOP);
		contoCorrente = new JTextArea();
		contoCorrente.setBounds(920, 64, 107, 44);
		contoCorrente.setColumns(10);
		contoCorrente.setBorder(titleCC);
		
		//spese a carico del conduttore
		TitledBorder titleCarCond;
		titleCarCond = BorderFactory.createTitledBorder("Spese a Car.Cond.");
		titleCarCond.setTitlePosition(TitledBorder.ABOVE_TOP);
		speseCaricoConduttore = new JTextArea();
		speseCaricoConduttore.setBounds(1094, 64, 145, 39);
		speseCaricoConduttore.setColumns(10);
		speseCaricoConduttore.setBorder(titleCarCond);
		
		//checkbox importo frazionato
		JCheckBox frazionatoCheckbox = new JCheckBox("Frazionato a fine anno");
		frazionatoCheckbox.setBounds(10, 115, 145, 39);
		
		//checkbox pagare tutto all'amministratore
		JCheckBox amministratoreCheckbox = new JCheckBox("All'amministratore");
		amministratoreCheckbox.setBounds(208, 115, 116, 39);
		
		
		
	
	
		
		
		
		//mensilità cauzione
		TitledBorder titleMensCauz;
		titleMensCauz = BorderFactory.createTitledBorder("Mensilità Cauzione");
		titleMensCauz.setTitlePosition(TitledBorder.ABOVE_TOP);	
		mensilitaCauzione = new JTextArea();
		mensilitaCauzione.setToolTipText("Mensilit\u00E0 Cauzione");
		mensilitaCauzione.setBounds(395, 115, 98, 39);
		mensilitaCauzione.setColumns(10);
		mensilitaCauzione.setBorder(titleMensCauz);
		
		//altre garanzie
		TitledBorder titleAltreGaranzie;
		titleAltreGaranzie = BorderFactory.createTitledBorder("Altre Garanzie");
		titleAltreGaranzie.setTitlePosition(TitledBorder.ABOVE_TOP);	
		altreGaranzie = new JTextArea();
		altreGaranzie.setBounds(555, 115, 281, 39);
		altreGaranzie.setColumns(10);
		altreGaranzie.setBorder(titleAltreGaranzie);
				
		
		//checkbox in data
		checkboxInData = new JCheckBox("Consegna Imm. Posticipata ");
		checkboxInData.setBounds(918, 138, 148, 16);
		
		//checkbox alla sottoscrizione del contratto
		checkboxSottoscrizioneContratto = new JCheckBox("Consegna alla sottoscr.");
		checkboxSottoscrizioneContratto.setBounds(918, 115, 148, 16);
		
		//data consegna immobile
		
		TitledBorder titleDataConsImm;
		titleDataConsImm = BorderFactory.createTitledBorder("Alla Data (se cons. posticipata)");
		titleDataConsImm.setTitlePosition(TitledBorder.ABOVE_TOP);		
		//setto nella text area il calendario per far scegliere le date
		UtilDateModel modelDataConsImm = new UtilDateModel(); 
		Properties pContConsImm = new Properties();
		pContConsImm.put("text.today", "Today");
		pContConsImm.put("text.month", "Month");
		pContConsImm.put("text.year", "Year");
		JDatePanelImpl datePanelConsImm = new JDatePanelImpl(modelDataConsImm, pContConsImm);
		datePanelConsImm.setBounds(0, 62, 60, -62);
		dataConsImm = new JDatePickerImpl(datePanelConsImm, new DateLabelFormatter());
		dataConsImm.setToolTipText("Alla data (se consegna posticipata)");
		springLayout = (SpringLayout) dataConsImm.getLayout();
		dataConsImm.setLocation(1094, 110);
		dataConsImm.setSize(145, 44);
		dataConsImm.setBorder(titleDataConsImm);
		setResizable(false);
		

		//aggiungo gli elementi al contenitore 3)
		contenutoIncaricoContenitore.add(tipoContratto);
		contenutoIncaricoContenitore.add(durataDelContratto);
		contenutoIncaricoContenitore.add(canoneLocAnnuoEuro);
		contenutoIncaricoContenitore.add(canoneLocazioneAnnuoLettere);
		contenutoIncaricoContenitore.add(numeroRate);
		contenutoIncaricoContenitore.add(daCorrispondereIlGiorno);
		contenutoIncaricoContenitore.add(pressoDomicilioCheckbox);
		contenutoIncaricoContenitore.add(pressoBancaCheckbox);
		contenutoIncaricoContenitore.add(intestatarioCC);
		contenutoIncaricoContenitore.add(nomeBanca);
		contenutoIncaricoContenitore.add(contoCorrente);
		contenutoIncaricoContenitore.add(speseCaricoConduttore);
		contenutoIncaricoContenitore.add(frazionatoCheckbox);
		contenutoIncaricoContenitore.add(amministratoreCheckbox);
		contenutoIncaricoContenitore.add(mensilitaCauzione);
		contenutoIncaricoContenitore.add(dataConsImm);
		contenutoIncaricoContenitore.add(altreGaranzie);
		contenutoIncaricoContenitore.add(checkboxSottoscrizioneContratto);
		contenutoIncaricoContenitore.add(checkboxInData);
		
		
		// 4) il contenitore che delimita la parte di visita dell'immobile
		TitledBorder titleVisImm;
		titleVisImm = BorderFactory.createTitledBorder("4) Visita Immobile");
		titleVisImm.setTitlePosition(TitledBorder.ABOVE_TOP);
		JPanel contenitoreVisImm = new JPanel();
		contenitoreVisImm.setBackground(new Color(192, 192, 192));
		contenitoreVisImm.setBounds(43, 587, 568, 141);
		getContentPane().add(contenitoreVisImm);
		contenitoreVisImm.setBorder(titleVisImm);
		contenitoreVisImm.setLayout(null);
		
		//Giorni di visita (locatore diretto)
		TitledBorder titleGiorniVisita;
		titleGiorniVisita = BorderFactory.createTitledBorder("Giorni di Visita (Agente)");
		titleGiorniVisita.setTitlePosition(TitledBorder.ABOVE_TOP);	
		giorniVisita = new JTextArea();
		giorniVisita.setBounds(10, 21, 142, 51);
		giorniVisita.setColumns(10);
		giorniVisita.setBorder(titleGiorniVisita);
		
		//Orario da Giorni di visita (locatore diretto)
		TitledBorder titleGiorniVisitaOraDa;
		titleGiorniVisitaOraDa = BorderFactory.createTitledBorder("Dalle ore:");
		titleGiorniVisitaOraDa.setTitlePosition(TitledBorder.ABOVE_TOP);	
		giorniVisitaDaOra = new JTextArea();
		giorniVisitaDaOra.setBounds(188, 21, 86, 51);
		giorniVisitaDaOra.setColumns(10);
		giorniVisitaDaOra.setBorder(titleGiorniVisitaOraDa);
		
		
		//Orario a Giorni di visita (locatore diretto)
		TitledBorder titleGiorniVisitaOraA;
		titleGiorniVisitaOraA = BorderFactory.createTitledBorder("Alle ore:");
		titleGiorniVisitaOraA.setTitlePosition(TitledBorder.ABOVE_TOP);	
		giorniVisitaAOra = new JTextArea();
		giorniVisitaAOra.setBounds(310, 21, 86, 51);
		giorniVisitaAOra.setColumns(10);
		giorniVisitaAOra.setBorder(titleGiorniVisitaOraA);
		
		
		//Giorni di visita (locatore indiretto attraverso conduttore)
		TitledBorder titleGiorniVisitaImpegnoLoc;
		titleGiorniVisitaImpegnoLoc = BorderFactory.createTitledBorder("Giorni di Visita (Conduttore)");
		titleGiorniVisitaImpegnoLoc.setTitlePosition(TitledBorder.ABOVE_TOP);	
		giorniVisitaImpegnoLocatore = new JTextArea();
		giorniVisitaImpegnoLocatore.setBounds(10, 79, 142, 51);
		giorniVisitaImpegnoLocatore.setColumns(10);
		giorniVisitaImpegnoLocatore.setBorder(titleGiorniVisitaImpegnoLoc);

	
		//orario giorni di visita da (locatore indiretto attraverso conduttore)
		TitledBorder titleGiorniVisitaImpegnoLocOraDa;
		titleGiorniVisitaImpegnoLocOraDa = BorderFactory.createTitledBorder("Dalle ore:");
		titleGiorniVisitaImpegnoLocOraDa.setTitlePosition(TitledBorder.ABOVE_TOP);	
		giorniVisitaImpegnoLocatoreDaOra = new JTextArea();
		giorniVisitaImpegnoLocatoreDaOra.setBounds(188, 79, 86, 51);
		contenitoreVisImm.add(giorniVisitaImpegnoLocatoreDaOra);
		giorniVisitaImpegnoLocatoreDaOra.setColumns(10);
		giorniVisitaImpegnoLocatoreDaOra.setBorder(titleGiorniVisitaImpegnoLocOraDa);

		//orario giorni di visita a (locatore indiretto attraverso conduttore)
		TitledBorder titleGiorniVisitaImpegnoLocOraA;
		titleGiorniVisitaImpegnoLocOraA = BorderFactory.createTitledBorder("Alle ore:");
		titleGiorniVisitaImpegnoLocOraA.setTitlePosition(TitledBorder.ABOVE_TOP);	
		giorniVisitaImpegnoLocatoreAOra = new JTextArea();
		giorniVisitaImpegnoLocatoreAOra.setBounds(310, 79, 86, 51);
		giorniVisitaImpegnoLocatoreAOra.setColumns(10);
		giorniVisitaImpegnoLocatoreAOra.setBorder(titleGiorniVisitaImpegnoLocOraA);
		
		
		//checkbox non consegna copia chiavi
		JCheckBox chckbxNonConsegnaCopia = new JCheckBox("Non consegna chiavi");
		chckbxNonConsegnaCopia.setBounds(427, 39, 128, 23);
		
		//checkbox consegna copia chiavi
		JCheckBox chckbxConsegnaCopia = new JCheckBox("Consegna chiavi");
		chckbxConsegnaCopia.setBounds(427, 97, 128, 23);
		
		
		//aggiungo tutti i campi al pannello 4
		contenitoreVisImm.add(giorniVisita);
		contenitoreVisImm.add(giorniVisitaDaOra);
		contenitoreVisImm.add(giorniVisitaImpegnoLocatoreAOra);
		contenitoreVisImm.add(giorniVisitaImpegnoLocatore);
		contenitoreVisImm.add(giorniVisitaAOra);
		contenitoreVisImm.add(chckbxNonConsegnaCopia);
		contenitoreVisImm.add(chckbxConsegnaCopia);
		
		
		
		
		// 5) il contenitore che delimita la parte di compenso dell'agente
		TitledBorder titleCompensoAgente;
		titleCompensoAgente = BorderFactory.createTitledBorder("5) Compenso dell'Agente");
		titleCompensoAgente.setTitlePosition(TitledBorder.ABOVE_TOP);
		JPanel compensoAgentePanel = new JPanel();
		compensoAgentePanel.setLayout(null);
		compensoAgentePanel.setBackground(Color.LIGHT_GRAY);
		compensoAgentePanel.setBounds(650, 587, 305, 141);
		compensoAgentePanel.setBorder(titleCompensoAgente);
		getContentPane().add(compensoAgentePanel);
		
		//checkbox compenso agente in % di canone annuale
		checkBoxCompensoPariA = new JCheckBox("Pari A");
		checkBoxCompensoPariA.setBounds(6, 25, 78, 23);
		
		//checkbox compenso agente in euro a forfait
		checkboxAForfait = new JCheckBox("A Forfait di");
		checkboxAForfait.setBounds(6, 91, 78, 23);
		
		//percentuale canone annuale per compenso agente
		TitledBorder titleCompensoAgenteConCanoneAnnuale;
		titleCompensoAgenteConCanoneAnnuale = BorderFactory.createTitledBorder("% canone annuale");
		titleCompensoAgenteConCanoneAnnuale.setTitlePosition(TitledBorder.ABOVE_TOP);
		percCanoneAnnuale = new JTextArea();
		percCanoneAnnuale.setToolTipText("% del canone annuo a compenso dell'agente");
		percCanoneAnnuale.setBounds(98, 25, 86, 39);
		percCanoneAnnuale.setColumns(10);
		percCanoneAnnuale.setBorder(titleCompensoAgenteConCanoneAnnuale);
		
		//percentuale canone annuale per compenso agente (in lettere)
		TitledBorder titleCompensoAgenteConCanoneAnnualeLettere;
		titleCompensoAgenteConCanoneAnnualeLettere = BorderFactory.createTitledBorder("% In lettere");
		titleCompensoAgenteConCanoneAnnualeLettere.setTitlePosition(TitledBorder.ABOVE_TOP);
		percCanAnnualeLettere = new JTextArea();
		percCanAnnualeLettere.setColumns(10);
		percCanAnnualeLettere.setBounds(209, 25, 86, 39);
		percCanAnnualeLettere.setBorder(titleCompensoAgenteConCanoneAnnualeLettere);
		
		
		//compenso agente a forfait di euro
		TitledBorder titleCompensoAgenteForfait;
		titleCompensoAgenteForfait = BorderFactory.createTitledBorder("€");
		titleCompensoAgenteForfait.setTitlePosition(TitledBorder.ABOVE_TOP);
		euroForfait = new JTextArea();
		euroForfait.setColumns(10);
		euroForfait.setBounds(98, 91, 86, 39);
		euroForfait.setBorder(titleCompensoAgenteForfait);
		
		//compenso agente a forfait di euro in lettere
		TitledBorder titleCompensoAgenteForfaitLettere;
		titleCompensoAgenteForfaitLettere = BorderFactory.createTitledBorder("€ In Lettere");
		titleCompensoAgenteForfaitLettere.setTitlePosition(TitledBorder.ABOVE_TOP);
		euroForfaitLettere = new JTextArea();
		euroForfaitLettere.setColumns(10);
		euroForfaitLettere.setBounds(209, 91, 86, 39);
		euroForfaitLettere.setBorder(titleCompensoAgenteForfaitLettere);

		
		
		//aggiungo tutti i componenti al panel 5
		
		compensoAgentePanel.add(checkBoxCompensoPariA);
		compensoAgentePanel.add(checkboxAForfait);
		compensoAgentePanel.add(percCanoneAnnuale);
		compensoAgentePanel.add(percCanAnnualeLettere);
		compensoAgentePanel.add(euroForfait);
		compensoAgentePanel.add(euroForfaitLettere);
		
		// Pannello dettagli Aggiuntivi
		TitledBorder titleDettAggiuntiviPanel;
		titleDettAggiuntiviPanel = BorderFactory.createTitledBorder("Dettagli Aggiuntivi");
		titleDettAggiuntiviPanel.setTitlePosition(TitledBorder.ABOVE_TOP);	
		JPanel dettagliAggiuntiviPanel = new JPanel();
		dettagliAggiuntiviPanel.setLayout(null);
		dettagliAggiuntiviPanel.setBackground(Color.LIGHT_GRAY);
		dettagliAggiuntiviPanel.setBounds(1010, 587, 305, 141);
		dettagliAggiuntiviPanel.setBorder(titleDettAggiuntiviPanel);
		getContentPane().add(dettagliAggiuntiviPanel);
		
		//Note 
		TitledBorder titleNoteAggiuntive;
		titleNoteAggiuntive = BorderFactory.createTitledBorder("Note Aggiuntive");
		titleNoteAggiuntive.setTitlePosition(TitledBorder.ABOVE_TOP);
		noteAggiuntive = new JTextArea();
		noteAggiuntive.setBounds(10, 22, 285, 55);
		noteAggiuntive.setColumns(10);
		noteAggiuntive.setLineWrap(true);
		noteAggiuntive.setBorder(titleNoteAggiuntive);
		
		
		//Contratto sottocritto presso 
		TitledBorder titleContrattoSottoscrittoPresso;
		titleContrattoSottoscrittoPresso = BorderFactory.createTitledBorder("Contratto sottoscritto presso");
		titleContrattoSottoscrittoPresso.setTitlePosition(TitledBorder.ABOVE_TOP);
		sottoscrizioneContrattoPresso = new JTextArea();
		sottoscrizioneContrattoPresso.setToolTipText("Contratto sottoscritto presso");
		sottoscrizioneContrattoPresso.setColumns(10);
		sottoscrizioneContrattoPresso.setBounds(10, 88, 130, 44);
		sottoscrizioneContrattoPresso.setBorder(titleContrattoSottoscrittoPresso);
		
		
		//data sottoscrizione contratto
		TitledBorder titleDataSottContratto;
		titleDataSottContratto = BorderFactory.createTitledBorder("Sottoscritto in data");
		titleDataSottContratto.setTitlePosition(TitledBorder.ABOVE_TOP);		
		//setto nella text area il calendario per far scegliere le date
		UtilDateModel modelDataSottContr = new UtilDateModel(); 
		Properties pSottContr = new Properties();
		pSottContr.put("text.today", "Today");
		pSottContr.put("text.month", "Month");
		pSottContr.put("text.year", "Year");
		JDatePanelImpl datePanelSottContr = new JDatePanelImpl(modelDataSottContr, pSottContr);	
		datePanelSottContr.setBounds(10, 92, 127, 38);
		setResizable(false);
		dataSottContr = new JDatePickerImpl(datePanelSottContr, new DateLabelFormatter());
		dataSottContr.setBounds(150, 88, 145, 44);
		springLayout = (SpringLayout) dataSottContr.getLayout();
		dataSottContr.setBorder(titleDataSottContratto);
		

		//aggiungo i componenti al panel dei dettagli aggiuntivi
		dettagliAggiuntiviPanel.add(noteAggiuntive);
		dettagliAggiuntiviPanel.add(sottoscrizioneContrattoPresso);
		dettagliAggiuntiviPanel.add(dataSottContr);
		
		//bottone che crea il contratto
		JButton creaIncaricoLocazione = new JButton("Crea Contratto");
		creaIncaricoLocazione.setIcon(new ImageIcon(IncaricoLocazionePanel.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		creaIncaricoLocazione.setBounds(1186, 25, 129, 40);
		getContentPane().add(creaIncaricoLocazione);
		
		
		
		
		
	
		
		
		
		
	

		
		
	}
}
