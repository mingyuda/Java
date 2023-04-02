package step11Network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket sc = new ServerSocket();
			//bind(): 서버의 IP주소와 port 설정, 통신을 시작
			sc.bind(new InetSocketAddress("localhost", 9999));
			
			while(0<1) {
				//step01 : 연결
				Socket socket = sc.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("클라이언트와 연결");
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
