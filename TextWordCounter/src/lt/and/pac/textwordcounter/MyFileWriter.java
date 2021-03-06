package lt.and.pac.textwordcounter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileWriter {

		private String fileName;
		private String pathOfProject;
		
		public MyFileWriter (String pathOfProject, String fileName){
			this.pathOfProject = pathOfProject;
			this.fileName = fileName;
		}
	 
	    public void writeOneFile(ArrayList<Row> countedListOfRows) {
	        try {
	        	String fullFileName = pathOfProject + "CountedFile_" + fileName + ".out";
	        	System.out.println("Full output file name: " + fullFileName);
	            FileWriter writer = new FileWriter(fullFileName, true);
	            
	            for (Row row : countedListOfRows){
	            	writer.write(row.getWord() + "\t" + row.getCount());
	            	writer.write("\r\n");   							// write new line
	            }
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

