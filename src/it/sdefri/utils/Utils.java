package it.sdefri.utils;

public class Utils {
	
	public static String getDocumentPathByOs(){
		String os = System.getProperty("os.name").toLowerCase();
		String documentPath = Constants.DOCUMENT_PATH_LINUX;
		if(os.indexOf("win") >= 0){
			documentPath =  Constants.DOCUMENT_PATH_WIN;
		}
		if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0){
			documentPath =  Constants.DOCUMENT_PATH_LINUX;
		}
		return documentPath;
	}
}
