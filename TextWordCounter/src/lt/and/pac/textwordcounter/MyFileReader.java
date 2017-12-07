package lt.and.pac.textwordcounter;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

	public class MyFileReader {
	    
		String pathOfProjectParent;
		String[] allFileList;
		String fileExtention = "";
		ArrayList<File> fileList = new ArrayList<File>();
		
		public MyFileReader (String pathOfProjectParentIn){
			this.pathOfProjectParent = pathOfProjectParentIn;
			allFileList = new File(pathOfProjectParent).list();
		}
		
		public void buildFileList(){
			
			for (int i=0; i < allFileList.length; i++){
				fileExtention = allFileList[i].substring(allFileList[i].length()-3, allFileList[i].length());
				if (Objects.equals(fileExtention.toString(), "txt".toString())){
					File file = new File(pathOfProjectParent + allFileList[i]);
					this.fileList.add(file);
				}
			}
		}
	
		public String readAllTxtFiles(){
			String fileText = new String();
			
			for (File file : fileList){
					//System.out.println(file.getName());
				try{
					File fileIns = new File(pathOfProjectParent + file.getName());
			        Scanner sc = new Scanner(fileIns);
			        while(sc.hasNextLine()){
			        	fileText = fileText  + "\n" + sc.nextLine();
			        }
					sc.close();
				} catch(Exception e) {
			         System.out.println("Exception thrown  :" + e);
				}
			}	
			return fileText;	
	}
}		

	

