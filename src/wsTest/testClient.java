package wsTest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class testClient {
	public static void main(String []args) throws EOFException{
			
		try {
			String serverIP = "127.0.0.1";
			System.out.println("server : "+ serverIP);
			Socket socket = new Socket(serverIP, 8080);
			
			InputStream is = socket.getInputStream();
			BufferedInputStream bs = new BufferedInputStream(is);
//			BufferedInputStream bis = (BufferedInputStream) socket.getInputStream();
//			DataInputStream dis = new DataInputStream(bis);
			DataInputStream dis = new DataInputStream(bs);
			
			while(true){
				System.out.println(dis.readUTF());
				System.out.println("연결 종료");
			}
			
			
			
			
			//dis.close();
//			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
