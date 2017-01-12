package WS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("start server");

		try {
			while (true) {
				// 프로그램은 멈추고 외부의 소켓 접속 요청 대기				
				// 소켓 접속 요청이 오면 클라이언트와 통신을 할 서버 측 소켓을 만들고 외부 소켓과 연결한 후 레퍼런스가 반환
				Socket socket = serverSocket.accept();
				BufferedReader bufferedReader = null;
				FileInputStream fInputStream = null;
				OutputStream outputStream = null;
				try {
					bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

					String inputStreamText = null;
					String reqUrlText = null;

					int lineCnt = 0;

					while ((inputStreamText = bufferedReader.readLine()) != null) {

						if (inputStreamText.equals("")) {
							break;
						}
						
						if (lineCnt == 0) {
							reqUrlText = inputStreamText;
							lineCnt++;
						}
					}
					String reqUrl = reqUrlText.split(" ")[1];

					File file = new File("D:/workspace/study/src/view" + reqUrl);

					byte[] fisCnt = new byte[1024];

					// FileInputStream에 file넣어주기.
					outputStream = socket.getOutputStream();
	                  // 파일 없을 경우 404 NotFound  전송
	                  if(!file.exists()){
	                	  outputStream.write("HTTP/1.1 404 Not Found \r\n".getBytes());
	                	  outputStream.write("Content-Type: text/html;charset=utf-8 \r\n".getBytes());
	                	  outputStream.write("Connection: keep-alive \r\n".getBytes());
	                  }else{
	                	  // 파일이 있을 경우 정상 처리일때
	                	  fInputStream = new FileInputStream(file);
	                	  outputStream.write("HTTP/1.1 200 OK \r\n".getBytes());
	                	  outputStream.write("Content-Type: text/html;charset=utf-8\r\n".getBytes());
	                	  outputStream.write("Connection: keep-alive \r\n".getBytes());
	                	  outputStream.write("\r\n".getBytes());
	                	  
	                	  // FileInputStream에서 읽어들인 바이트배열을 Socket의 OutputStream에 write 
	                	  while(fInputStream.read(fisCnt) >= 0) {
	                		  outputStream.write(fisCnt);
	                	  }
	                	  outputStream.write("\r\n".getBytes());
	                  }
	                    
	                    // 마지막 stream에 남은 데이터가 전송안됐을때 강제로 전송
	                  outputStream.flush();
	                } catch (Throwable e) {
	                	e.printStackTrace();
	                } finally {
	                	try { bufferedReader.close(); } catch (IOException e) { e.printStackTrace(); }
	                	if(fInputStream != null){
	                		try { fInputStream.close(); } catch (IOException e) { e.printStackTrace(); }
	                	}
	                	try { outputStream.close(); } catch (IOException e) { e.printStackTrace(); }
	                    try { socket.close(); } catch (IOException e) { e.printStackTrace(); }
	                }                
	        	}
	    	} finally {
	    		serverSocket.close();
	    	}
	            
	    }
	}