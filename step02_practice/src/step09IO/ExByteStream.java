package step09IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExByteStream {
	
	public static void fileSave() throws IOException {
		FileWriter fos = new FileWriter("WaitingChicken.txt");
		
		fos.write("내 치킨은 언제와\n 내 친킨.. = chicken");
		fos.close();
	}
	
	public static void fileOpen() throws IOException {
		FileReader fis = new FileReader("WaitingChicken.txt");
		
		int data;
		while((data = fis.read()) != -1) { //-1인 이유는 -1이 마지막 부분이므로
			System.out.println((char)data);
		}
		
		fis.close();
		
	}

	public static void main(String[] args) {
		try {
			fileSave();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
