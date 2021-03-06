package lt.and.pac.textwordcounter;

import java.util.ArrayList;
import java.util.Objects;

public class WordCounter extends Thread{
	
	private Thread threadIns;
	private String thredName;
	
	private String pathOfProject;
	private Character sratChar;
	private Character endChar;
	private ArrayList<Row> listOfRows;
	private ArrayList<Row> countedListOfRows;
	private String[] arrayOfWords;
	
	public WordCounter(String pathOfProject, char sratChar, char endChar, String[] arrayOfWords){
		this.pathOfProject = pathOfProject;
		this.sratChar = sratChar;
		this.endChar = endChar;
		this.listOfRows = new ArrayList<>();
		this.thredName = sratChar + "-" + endChar;
		this.countedListOfRows = new ArrayList<>();
		this.arrayOfWords = arrayOfWords;
		this.setName("Thred:" + this.thredName);
	}

	public void run() {
		this.buildRowsArrayList();
		this.countWords();
		
		MyFileWriter fileWriterIns = new MyFileWriter(pathOfProject, thredName);
		fileWriterIns.writeOneFile(countedListOfRows);
		
			// control of each list
		for(Row row : countedListOfRows){
		System.out.println(this.getName() + " " + row.getWord() + " " + row.getCount());
		}
	}

	public void start () {
	      if (threadIns == null) {
	    	  threadIns = new Thread (this);
	    	  threadIns.start ();
	      }
		}
	
		// builds ArrayList of Rows having predefined first letters only
	public void buildRowsArrayList(){
		
		String currentWord = new String();
		
		for (int i=0; i<arrayOfWords.length; i++){
			currentWord = arrayOfWords[i];
			if (!currentWord.isEmpty()){
				if (currentWord.charAt(0) >= sratChar && currentWord.charAt(0) <= endChar
					|| currentWord.charAt(0) >= Character.toLowerCase(sratChar)  
					&& currentWord.charAt(0) <= Character.toLowerCase(endChar)){
					Row newRow = new Row (currentWord, 1);
					listOfRows.add(newRow);
				}
			}
		}
	}
	
		// builds ArrayList of Rows with counted words
	public ArrayList<Row> countWords(){
		
		String currentWord = new String();
		int currentCount = 0;
		
		for (int i=0; i<listOfRows.size(); i++){
			if (!listOfRows.get(i).getWord().isEmpty()){
				currentWord = listOfRows.get(i).getWord();
				currentCount = 1;
				Row newRow = new Row(currentWord, currentCount);
			
				for (int j=i+1; j<listOfRows.size(); j++){
					if (!currentWord.toString().isEmpty() 
						&& Objects.equals(currentWord.toString(), listOfRows.get(j).getWord().toString())){
						
						newRow.increment();
						listOfRows.get(j).deleteWord();
						listOfRows.get(j).deleteCount();
					}
				}
				countedListOfRows.add(newRow);
			}
		}	
		return countedListOfRows;
	}
}
