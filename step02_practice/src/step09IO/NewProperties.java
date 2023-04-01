package step09IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class NewProperties {

	public static void main(String[] args) {
		Properties properties = new Properties();
			try {
				properties.load(new FileInputStream("database.property"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(properties.getProperty("chicken")); //file로 만들어서 들고와줌

	}

}

