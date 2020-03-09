import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRW {
	private String filePath;
	
	private Scanner scanner;

	private File file;
	private FileWriter fileWriter;
	private BufferedWriter buffWriter;

	private ArrayList<String> list = new ArrayList<String>();

	//!!!!!!!!!!!!!!!!		line counting starts at 0		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	FileRW(String pFilePath) throws IOException {
		filePath = pFilePath;
		file = new File(filePath);
		scanner = new Scanner(file);
		fillList();
	}
	
	//adds a string (content) to the file in the line (lineNumber) and position from the beginning of the line (position)
	void add(String content, int lineNumber, int position) {
		try {
			String line = list.get(lineNumber);
			line = line.substring(0, position) + content + line.substring(position);
			list.remove(lineNumber);
			list.add(lineNumber, line);
			
			fileWriter = new FileWriter(filePath);// file, false);
			buffWriter = new BufferedWriter(fileWriter);
			
			String str = "";
			for(int i=0;i<list.size();i++) {
				str += list.get(i) + '\r';
			}
			buffWriter.write(str);
			buffWriter.close();
		} catch (Exception e) {
			System.err.println("line "+lineNumber+" does not exist yet");
		}
	}
	
	//replaces the line (lineNumber) with the string (content)
	//the line lineNumber has to exist already
	void set(String content, int lineNumber) {
		try {
			list.remove(lineNumber);
			list.add(lineNumber, content);
			
			fileWriter = new FileWriter(filePath);// file, false);
			buffWriter = new BufferedWriter(fileWriter);
			
			String str = "";
			for(int i=0;i<list.size();i++) {
				str += list.get(i) + '\r';
			}
			buffWriter.write(str);
			buffWriter.close();
		} catch (Exception e) {
			System.err.println("line "+lineNumber+" does not exist yet");
		}
	}
	
	//adds a string to the end of the file
	void add(String content) {
		try {
			list.add(content);
			
			fileWriter = new FileWriter(filePath);// file, false);
			buffWriter = new BufferedWriter(fileWriter);
			
			String str = "";
			for(int i=0;i<list.size();i++) {
				str += list.get(i) + '\r';
			}
			buffWriter.write(str);
			buffWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	String get(int lineNumber) {
		try {
			String s = list.get(lineNumber);
			return s;
		} catch (Exception e) {
			System.err.println("Entered number('"+ lineNumber+") is longer than number of lines there are ("+list.size()+")");
		}
		
		return null;
	}
	
	int length() {
		return list.size();
	}
	
	private void fillList() throws IOException {
		while (scanner.hasNextLine()) {
			String data = scanner.nextLine();
			list.add(data);
		}
		scanner.close();
	}
}
