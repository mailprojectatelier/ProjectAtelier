package it.sdefri.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Classe contenente utility varie per la 
 * gestione delle date
 * 
 * @version 0.1.0.0
 */
public class DateUtils {
	
	/**
	 * dd/MM/yyyy
	 */
	private final static SimpleDateFormat STANDARD_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * dd/MM/yyyy HH:mm:ss
	 */
	private final static SimpleDateFormat EXTENDED_STANDARD_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	/**
	 * yyyyMMdd
	 */
	private final static SimpleDateFormat INVERTED_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	
	/**
	 * HH:mm
	 */
	private final static SimpleDateFormat HHMM_HOUR_FORMAT = new SimpleDateFormat("HH:mm");
	
	/**
	 * yyyyMMdd_HHmmss
	 */
	private final static SimpleDateFormat EXTENDED_INVERTED_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss");
	
	
	
//	public static final Date dataDefault1948=parseDateEvolution("01/01/1948");
	

	public static boolean compareOnlyDateTo(Date date1, Date date2) {
		boolean compareOk = true;
		if (!INVERTED_DATE_FORMAT.format(date1).equals(INVERTED_DATE_FORMAT.format(date2)))
			compareOk = false;
		return compareOk;
	}

	/**
	 * aggiunge o sottrae giorni alla data: 
	 * interi positivi aggiunge, 
	 * interi negativi sottrae
	 * @param date
	 * @param value to add
	 */
	public static Date addOrSubstractDaysToDate(Date dateInit, int days){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInit);
		cal.add( Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}
	
	/**
	 * aggiunge o sottrae ore alla data: 
	 * interi positivi aggiunge, 
	 * interi negativi sottrae
	 * @param date
	 * @param value to add
	 */
	public static Date addHoursToDate(Date dateInit, int hours){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInit);
		cal.add( Calendar.HOUR, hours);
		return cal.getTime();
	}
	
	/**
	 * aggiunge o sottrae mesi alla data: 
	 * interi positivi aggiunge, 
	 * interi negativi sottrae
	 * @param date
	 * @param value to add
	 */
	public static Date addMonthsToDate(Date date, Integer monthsToAdd){
		if(monthsToAdd==null  ||  monthsToAdd==0){
			return date;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, monthsToAdd);
		
		return c.getTime();
	}

	/**
	 * azzera le ore della data
	 * @param date
	 * @return
	 */
	public static Date clearHours(Date date) {
		if(date == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		resetTime(c);
		return c.getTime();
	}
	
	/**
	 * ritorna la data di oggi senza orario
	 * @return
	 */
	public static Date getCurrentDate() {
		Calendar c = Calendar.getInstance();
		resetTime(c);
		return c.getTime();
	}
	
	private static void resetTime(Calendar c){
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
	}
	
	/**
	 * converte in date una stringa nel formato yyyyMMdd
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String strDate) throws ParseException{
		return strDate != null ? INVERTED_DATE_FORMAT.parse(strDate) : null;
	}
	
	
	/**
	 * converte in date una stringa nel formato yyyyMMdd_HHmmss
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTimestamp(String strTimestamp) throws ParseException{
		return strTimestamp != null ? EXTENDED_INVERTED_DATE_FORMAT.parse(strTimestamp) : null;
	}
	
	
	/**
	 * converte in stringa nel formato dd/MM/yyyy
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static String parseString(Date dateDate){
		return dateDate != null ? STANDARD_DATE_FORMAT.format(dateDate) : "";
	}
	
	
	/**
	 * converte in stringa nel formato dd/MM/yyyy HH:mm:ss
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static String parseStringTS(Date dateDate){
		return dateDate != null ? EXTENDED_STANDARD_DATE_FORMAT.format(dateDate) : "";
	}
	
	
	/**
	 * converte in stringa nel formato HH:mm 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static String getDateFormatAnnoMeseGiorno(Date dateDate){
		return dateDate != null ? HHMM_HOUR_FORMAT.format(dateDate):null;
	}
	
	
	//*******************************
	// verifico la data in formato gg/mm/aaaa
	public static boolean isValidDate( String strDate ) {
		
		boolean isValid=false;
		// Data nel formato gg/mm/aaaa
		Pattern pattern = Pattern.compile( "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((?:19|20)\\d\\d)$" );
		Matcher matcher = pattern.matcher(strDate);
 
		if(matcher.matches()) {
 
			matcher.reset();
 
			isValid=true;
			if(matcher.find()) {
		        int gg = Integer.parseInt(matcher.group(1));	// giorno
			    int mm = Integer.parseInt(matcher.group(2));	// mese
			    int aa = Integer.parseInt(matcher.group(3));	// anno
				if (gg == 31  &&  (mm == 4 || mm == 6 || mm == 9 || mm == 11)) {
					isValid = false;	// 31 giorni per un mese di 30 giorni
				} else if (gg >= 30  &&  mm == 2) {
					isValid = false;	// febbraio di 30 o 31 giorni
				} else if (mm == 2  &&  gg == 29 &&  !(aa % 4 == 0  &&  (aa % 100 != 0 || aa % 400 == 0))) {
					isValid = false;	// 29 febbraio di un anno non bisestile
				}
			}
		}
		return isValid;
	}
	
	
	// verifico l'ora in formato hh:mm
	public static boolean isValidTime( String strTime ) {
		
		boolean isValid=false;
		// Ora nel formato hh_mm
		Pattern pattern = Pattern.compile( "^((\\d|0\\d|1[01])([:.][0-5]\\d)(\\ [AP]M))$|^(\\d|0\\d|[01]\\d|2[0-3])([:.][0-5]\\d){0,2}$" );
		Matcher matcher = pattern.matcher(strTime);
 
		if(matcher.matches()) {
			isValid=true;
		}

		return isValid;
	}
	
	// verifico l'ora in formato hh:mm senza il limite delle 24 ore
		public static boolean isValidTimeInterval( String strTime ) {
			
			boolean isValid=false;
			// Ora nel formato hh_mm
			Pattern pattern = Pattern.compile( "^(\\d{1,3})([:.][0-5]\\d)$" );	// da 0:00 a 999:59
			Matcher matcher = pattern.matcher(strTime);
	 
			if(matcher.matches()) {
				isValid=true;
			}

			return isValid;
		}
	
	
	//ritorna un tipo datatime da una stringa secondo il formato prestabilito
	public static Date parseTime(String strTime) throws ParseException{
		// sostituisco eventuale '.' con ':'
		String strTimeStandard = strTime != null ? strTime.replace('.', ':') : null;
		return strTimeStandard != null ? defaultSimpleTimeFormat.parse(strTimeStandard) : null;
	}
	
	
	//ritorna un tipo datetime da una stringa secondo il formato prestabilito
	public static double getDecimalTimeFromString(String strTime) throws ParseException{
		double decimalTime = 0.0;
		if(isValidTimeInterval(strTime)){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime( parseTime(strTime) );
			int days = calendar.get(Calendar.DAY_OF_MONTH);
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			decimalTime = (days-1)*24 + hours + minutes / 60.0;
		}
		return decimalTime;
	}
	
	
	public static String getHourMinuteFromDate(Date date){
		String hhmm = "";
		
		if(date!=null){
			Calendar cDate = Calendar.getInstance();
			cDate.setTime(date);
			hhmm = String.format("%02d:%02d", cDate.get(Calendar.HOUR_OF_DAY), cDate.get(Calendar.MINUTE));
		}
		
		return hhmm;
	}
	
	
	// === restituisce una stringa nel formato hh:mm a partire da un double che esprime un'ora in formato decimale ===
	// es. input: 2,5  output: 02:30
	public static String getHourMinuteFromDecimalTime(Double decimalTime){
		String hhmm = "";
		
		if(decimalTime!=null){
			int hour = decimalTime.intValue();
			Double dMinute = Math.rint((decimalTime - hour) * 60);
			dMinute = dMinute * Math.signum(dMinute);
			hhmm = String.format("%02d:%02d", hour, dMinute.intValue());
		}
		
		return hhmm;
	}
	
	
	// === mette insieme due campi Date uno dei quali contiene una data e l'altro un'ora ===
	public static Date getDateFromDateAndTime(Date fromDate, Date fromTime){
		
		Calendar cDate = Calendar.getInstance();
		cDate.setTime(fromDate);
		Calendar cHour = Calendar.getInstance();
		cHour.setTime(fromTime);
		Calendar newDate = Calendar.getInstance();
		newDate.set(cDate.get(Calendar.YEAR), cDate.get(Calendar.MONTH), cDate.get(Calendar.DAY_OF_MONTH), cHour.get(Calendar.HOUR_OF_DAY), cHour.get(Calendar.MINUTE), 0);
		
		return newDate.getTime();
	}
	//*******************************

	public static Integer getMonthNumberFromMonthName(String monthName){
		Integer monthNumber = 0;
		if(monthName != null && (monthName.trim().equals("gennaio") || monthName.trim().equals("Gennaio"))){
			monthNumber=1;
		} else if(monthName != null && (monthName.trim().equals("febbraio") || monthName.trim().equals("Febbraio"))){
			monthNumber=2;
		} else if(monthName != null && (monthName.trim().equals("marzo") || monthName.trim().equals("Marzo"))){
			monthNumber=3;
		} else if(monthName != null && (monthName.trim().equals("aprile") || monthName.trim().equals("Aprile"))){
			monthNumber=4;
		} else if(monthName != null && (monthName.trim().equals("maggio") || monthName.trim().equals("Maggio"))){
			monthNumber=5;
		} else if(monthName != null && (monthName.trim().equals("giugno") || monthName.trim().equals("Giugno"))){
			monthNumber=6;
		} else if(monthName != null && (monthName.trim().equals("luglio") || monthName.trim().equals("Luglio"))){
			monthNumber=7;
		} else if(monthName != null && (monthName.trim().equals("agosto") || monthName.trim().equals("Agosto"))){
			monthNumber=8;
		} else if(monthName != null && (monthName.trim().equals("settembre") || monthName.trim().equals("Settembre"))){
			monthNumber=9;
		} else if(monthName != null && (monthName.trim().equals("ottobre") || monthName.trim().equals("Ottobre"))){
			monthNumber=10;
		} else if(monthName != null && (monthName.trim().equals("novembre") || monthName.trim().equals("Novembre"))){
			monthNumber=11;
		} else if(monthName != null && (monthName.trim().equals("dicembre") || monthName.trim().equals("Dicembre"))){
			monthNumber=12;
		}
		return monthNumber;
	}
	
	public static Date getEasterDayByYear(int year) {
		
		int remain = year % 19;
		int firstDigits = year / 100;
		int temp = (firstDigits - 15) / 2 + 202 - 11 * remain;

		switch (firstDigits) {
		case 21:
		case 24:
		case 25:
		case 27:
		case 28:
		case 29:
		case 30:
		case 31:
		case 32:
		case 34:
		case 35:
		case 38:
			temp--;
			break;
		case 33:
		case 36:
		case 37:
		case 39:
		case 40:
			temp--;
			temp--;
			break;
		}
		
		temp %= 30;
		int tA = temp + 21;

		if (temp == 29) {
			tA--;
		}

		if (temp == 28 && remain > 10) {
			tA--;
		}

		int tB = (tA - 19) % 7;
		int tC = (40 - firstDigits) % 4;

		if (tC == 3) {
			tC++;
		}

		if (tC > 1) {
			tC++;
		}

		temp = year % 100;

		int tD = (temp + temp / 4) % 7;
		int tE = ((20 - tB - tC - tD) % 7) + 1;
		int day = tA + tE;
		int month = Calendar.MARCH;

		if (day > 31) {
			day -= 31;
			month = Calendar.APRIL;
		}

		Calendar easterDate = Calendar.getInstance();
		easterDate.set(year, month, day);
		
		return easterDate.getTime();
	}
	
	public static Date getEasterMondayByYear(int year) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(getEasterDayByYear(year));
		calendar.add(Calendar.DATE, 1);	
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	
	public static String getISODateTime(Calendar calendarDay){
		// esempio di valore ritornato: 2015-04-08T13:55:00+01:00
		Double decimalHourMinute = calendarDay.getTimeZone().getRawOffset()/3600000.0;
		String stringHourMinute = decimalHourMinute >= 0 ? 
									"+" + getHourMinuteFromDecimalTime(decimalHourMinute) :
									"-" + getHourMinuteFromDecimalTime(-decimalHourMinute);
		String isoDateTime = String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS%2$s", calendarDay, stringHourMinute);
		return isoDateTime;
	}
	
	
	public static String getISODate(Date inputDate){
		// esempio di valore ritornato: 2015-04-08
		String isoDate = String.format("%1$tY-%1$tm-%1$td", inputDate);
		return isoDate;
	}
	
	
	// === restituisce la data del primo del mese della data passata ===
	public static Date getMonthFirstDate(Date localDate){
		Calendar cal = Calendar.getInstance();
		cal.setTime(localDate);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		return cal.getTime();
	}
	
	// === restituisce la data di fine mese della data passata ===
	public static Date getMonthLastDate(Date localDate){
		Calendar cal = Calendar.getInstance();
		cal.setTime(localDate);
		int maxDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, maxDayOfMonth);
		
		return cal.getTime();
	}
	
	
	public static HashMap<String, String> getDiffBetweenDates(Date date1, Date date2){
 
		HashMap<String, String> timeMap = new HashMap<String,String>();
		
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.setTime(date1);
		calendar2.setTime(date2);
		long diff = (calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / 1000;
		
		long ddays = diff / (24 * 60 * 60);
		diff = diff % (24 * 60 * 60);
		
		long dhours = diff / (60 * 60);
		diff = diff % (60 * 60);
		
		long dminutes = diff / 60;
		
		long dsecs = diff % 60;
		
		timeMap.put("GG", String.format("%02d", ddays));
		timeMap.put("HH", String.format("%02d", dhours));
		timeMap.put("MM", String.format("%02d", dminutes));
		timeMap.put("SS", String.format("%02d", dsecs));
		
		return timeMap;
	}

	
	public static HashMap<String, String> getSplittedTimestamp(Date timestamp){
		HashMap<String, String> splittedMap = new HashMap<String,String>();
		
		// restituisce il timestamp in formato "dd/MM/yyyy HH:mm:ss"
		String stringTimeStamp = parseStringTS(timestamp);
		
		splittedMap.put("DATE", stringTimeStamp.substring(0, 10) );
		splittedMap.put("HH", stringTimeStamp.substring(11, 13) );
		splittedMap.put("MM", stringTimeStamp.substring(14, 16) );
		splittedMap.put("SS", stringTimeStamp.substring(17, 19) );
		
		return splittedMap;
	}
	
	
	public static Date getTimestamp(Date date, int hh, int mm, int ss){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hh);
		calendar.set(Calendar.MINUTE, mm);
		calendar.set(Calendar.SECOND, ss);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}
	
	public static String parseStringTimestamp(Date dateDate){
		return dateDate != null ? timestampFormat24H.format(dateDate) : "";
	}
}
