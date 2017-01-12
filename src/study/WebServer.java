package study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	  public static void main(String[] args) throws IOException {
	        ServerSocket listener = new ServerSocket(8080);
	        System.out.println("Http Server started at 8080 port");
	    	try {
	    		while (true) {
	               // 프로그램은 멈추고 외부의 소켓 접속 요청을 기다린다.
	                Socket socket = listener.accept();
	                
	                BufferedReader br = null;
	                FileInputStream fis = null;
	                OutputStream os = null;
	                try {
	                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                    String str = null;
	                    
	                    String requestUrlText = null;
	                                
	                    int requestHeaderTextLineNumber = 0;
	                    while((str = br.readLine()) != null) {

	                    	// HTTP 프로토콜에서 요청의 마지막은 공백문자열임 
	                    	if (str.equals("")) {
	                    		break;
	                    	}
	                    	
	                    	// 이건 브라우저에서 주소를 입력했을때 서버로 어떤 정보들이 전달되는지 확인용
	                        System.out.println(str);
	                        
	                        // 웹서버처럼 URL에 맞는 파일을 응답으로 던져주기 위해서는 HTTP 요청문자열의 첫번째 줄만 필요함
	                        // ex) GET /index.html HTTP/1.1
	                        if (requestHeaderTextLineNumber == 0) {
	                        	requestUrlText = str;
	                        	requestHeaderTextLineNumber++;
	                        }
	                        
	                    }
	                    
	                    String[] splitRequestUrlText = requestUrlText.split(" ");
	                    // requestURL이 요청하는 파일명 (경로 + 파일명)
	                    String requestURL = splitRequestUrlText[1];
	                    
	                    System.out.println("requestURL : " + requestURL);

	                  File file = new File("/Users/leeyura/workspace/study/src/study/index.html");                	
	                	
	                	//TODO 파일 없을 경우 404 NotFound 문자열을 전송해야함
	                	// 이 아래구문은 파일이 있을 경우 정상 처리일때
	                	
	                	byte[] buffer = new byte[1024];
	                	
	                    fis = new FileInputStream(file);
	                    os = socket.getOutputStream();
	                    
	                    // 정상응답에 대한 내용은 HTTP 프로토콜 참조할 것.
	                    os.write("HTTP/1.1 200 OK \r\n".getBytes());
	                    os.write("Content-Type: text/html;charset=utf-8\r\n".getBytes());
	                    os.write(("Content-Length: " + file.length() + "\r\n").getBytes());
	                    os.write("\r\n".getBytes());
	                    
	                    // FileInputStream에서 읽어들인 바이트배열을 Socket의 OutputStream에 write 한다.
	                    while(fis.read(buffer) >= 0) {
	                    	System.out.println(new String(buffer));
	                    	os.write(buffer);
	                    }

	                    os.write("\r\n".getBytes());
	                    
	                    // 마지막 stream에 남은 데이터가 전송안됐을때 강제로 전송
	                    os.flush();
	                    
	                } catch (Throwable e) {
	                	e.printStackTrace();
	                } finally {
	                	try { br.close(); } catch (IOException e) { e.printStackTrace(); }
	                	try { fis.close(); } catch (IOException e) { e.printStackTrace(); }
	                	try { os.close(); } catch (IOException e) { e.printStackTrace(); }
	                    try { socket.close(); } catch (IOException e) { e.printStackTrace(); }
	                }                
	                
	        	}
	    	} finally {
	    		listener.close();
	    	}
	            
	    }
}
