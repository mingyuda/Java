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
			
			// OutputStream으로 메세지를 보내고 InputStream으로 메세지를 받을 수 있다.
			// OutputStream - getOutputStream, InputStream - getInputStream 연결
			// 보낼때 write, flush
			// 받을 때는 객체 생성후 read(변수명)
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
