import java.io.IOException;

//just stuff i tested the FileRW with
public class FileRW_Main {
	public static void main(String[] args) {
		try {
			FileRW file = new FileRW("src/test.txt");
//			file.set("Hallo-><-Hallo", 0);
//			file.add("test", 0, 7);
//			System.out.println("----");
//			file.set("moin", 1);
//			System.out.println("----");
//			file.add("asdf");
//			System.out.println("----");
//			file.set("moin",1);
//			System.out.println("");
//			System.out.println("");
//			System.out.println(file.get(100));
		
			String s = "Hallo ich bin der Niklas";
			
			System.out.println(s.hashCode());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
