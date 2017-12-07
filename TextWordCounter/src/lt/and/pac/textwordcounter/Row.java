package lt.and.pac.textwordcounter;

public class Row {

	    private String word;
	    private int count;

	    public Row(String word, int count) {
	        this.word = word;
	        this.count = count;
	    }

	    public String getWord() {
	        return word;
	    }

	    public int getCount() {
	        return count;
	    }
	    
	    public void increment(){
	    	count++;
	    }
	    
	    public void deleteWord(){
	    	this.word = "";
	    }
	    
	    public void deleteCount(){
	    	this.count = 0;
	    }
}
