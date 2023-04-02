package step11Network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket socket = new Socket();
		try {
			System.out.println("연결 시도 중");
			socket.connect(new InetSocketAddress("localhost", 9999));
			System.out.println("연결 성공.");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
