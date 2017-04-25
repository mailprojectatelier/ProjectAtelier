package it.sdefri.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


/**
 * Classe contenente utility varie per la 
 * gestione delle importi in valuta
 * 
 * @version 0.1.0.0
 */
public class CurrencyUtils {
	 
	public static String numberToString(Double amountObj){
		
		double amount = 0.0;
		if(amountObj!=null){
			amount = amountObj.doubleValue();
		}

		DecimalFormatSymbols decimalSymbol =  new DecimalFormatSymbols();
		decimalSymbol.setDecimalSeparator(',');
		decimalSymbol.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
		df.setDecimalFormatSymbols( decimalSymbol );

		String stringAmount = "";
		
		try {
			stringAmount = df.format(amount);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new NumberFormatException();
		}
		
		df = null;
		decimalSymbol = null;
		
		return stringAmount;
	}

	
	public static String numberToString(double amount, int decimals){

		DecimalFormatSymbols decimalSymbol =  new DecimalFormatSymbols();
		decimalSymbol.setDecimalSeparator(',');
		decimalSymbol.setGroupingSeparator('.');
		
		String zeroes = "";
		for(int i=0; i<decimals; i++)
			zeroes += "0";
		
		String formatString = "###,###,###,##0." + zeroes;
		
		DecimalFormat df = new DecimalFormat(formatString);
		df.setDecimalFormatSymbols( decimalSymbol );

		String stringAmount = "";
		
		try {
			stringAmount = df.format(amount);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new NumberFormatException();
		}
		
		df = null;
		decimalSymbol = null;
		
		if(decimals == 0){ //se non voglio i decimali devo togliere anche la virgola
			stringAmount = stringAmount.substring(0, stringAmount.length()-1);
		}
		
		return stringAmount;
	}

	
	public static Double StringToNumber(String stringAmount){

		DecimalFormatSymbols decimalSymbol =  new DecimalFormatSymbols();
		decimalSymbol.setDecimalSeparator(',');
		decimalSymbol.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
		df.setDecimalFormatSymbols( decimalSymbol );
		df.setDecimalSeparatorAlwaysShown(true);

		double amount = 0.0;
		
		if(stringAmount!=null && !stringAmount.equals("") ){
			try {
				amount = df.parse(stringAmount).doubleValue();			
			} catch (Exception e) {
				//e.printStackTrace();
				throw new NumberFormatException();
			}
		}
		
		df = null;
		decimalSymbol = null;
		
		return amount;
	}
	
}
