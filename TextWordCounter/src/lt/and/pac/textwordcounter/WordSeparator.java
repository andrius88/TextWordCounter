package lt.and.pac.textwordcounter;

public class WordSeparator {
	
	public static String[] separateWords(String fileTextIn){
		
		String[] arrayOfWords = fileTextIn.split("\\.|\\,|'|;|\\s+"); 	// splits words by whitespace and others
		return arrayOfWords;
	}

}
