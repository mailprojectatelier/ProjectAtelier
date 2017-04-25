package it.sdefri.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author Silvia Giusti
 *
 */
public class IbanUtils {

	private static final Logger logger = LogManager.getLogger(IbanUtils.class.getName());
	
	private enum NumberAlphabet{
		A(10), B(11), C(12), D(13), E(14), F(15), G(16), H(17), I(18), J(19), K(20), L(21), M(22), 
		N(23), O(24), P(25), Q(26), R(27), S(28), T(29), U(30), V(31), W(32), X(33), Y(34), Z(35);
		
		private int intValue;
		
		private NumberAlphabet(int intValue){
			this.intValue = intValue;
		}

		public int getIntValue() {
			return intValue;
		}

		public static NumberAlphabet contains(String aName) {
			NumberAlphabet[] alphabet = NumberAlphabet.values();
		       for (NumberAlphabet letter : alphabet)
		           if (letter.name().equals(aName))
		               return letter;
		       return null;
		   }
		
	}
	
	/**
	 * 
	 * @param iban
	 * @return 
	 * @exception NullPointerException in case IBAN is NULL
	 */
	public static boolean validateIban(String iban) throws Exception{
		iban = iban.trim().toUpperCase();
		if(iban.length() > 34){
			logger.info("IBAN troppo lungo, sono accettati al massimo 34 caratteri (trovati: " + iban.length() + ")");
			return false;
		}
		String countryAndCheckDigits = iban.substring(0, 4);
		String bbanCode = iban.substring(4);
		
		iban = bbanCode + countryAndCheckDigits;
		String numericIban = "";
		NumberAlphabet letter;

		for(char c : iban.toCharArray()){
			if((letter =  NumberAlphabet.contains("" + c)) != null){
				numericIban = numericIban + letter.getIntValue();
			} else {
				numericIban = numericIban + c;
			}
		}
		
		if(Integer.parseInt(numericIban) % 97 == 1){
			return true;
		}
		return false;
	}
	
	
	
		public static boolean validateIbanASCII(String iban) throws Exception{
		iban = iban.trim().toUpperCase();
		if(iban.length() > 34){
			logger.info("IBAN troppo lungo, sono accettati al massimo 34 caratteri (trovati: " + iban.length() + ")");
			return false;
		}
		String countryAndCheckDigits = iban.substring(0, 4);
		String bbanCode = iban.substring(4);
		
		iban = bbanCode + countryAndCheckDigits;
		String numericIban = "";
		int ascii;

		for(char c : iban.toCharArray()){
			if( (ascii = (int) c) > 64 ){
				numericIban = numericIban + (ascii - 55);
			} else {
				numericIban = numericIban + c;
			}
		}
		
		if(Integer.parseInt(numericIban) % 97 == 1){
			return true;
		}
		return false;
	}
	
	
	
}
