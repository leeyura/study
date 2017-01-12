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
	               // ���α׷��� ���߰� �ܺ��� ���� ���� ��û�� ��ٸ���.
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

	                    	// HTTP �������ݿ��� ��û�� �������� ���鹮�ڿ��� 
	                    	if (str.equals("")) {
	                    		break;
	                    	}
	                    	
	                    	// �̰� ���������� �ּҸ� �Է������� ������ � �������� ���޵Ǵ��� Ȯ�ο�
	                        System.out.println(str);
	                        
	                        // ������ó�� URL�� �´� ������ �������� �����ֱ� ���ؼ��� HTTP ��û���ڿ��� ù��° �ٸ� �ʿ���
	                        // ex) GET /index.html HTTP/1.1
	                        if (requestHeaderTextLineNumber == 0) {
	                        	requestUrlText = str;
	                        	requestHeaderTextLineNumber++;
	                        }
	                        
	                    }
	                    
	                    String[] splitRequestUrlText = requestUrlText.split(" ");
	                    // requestURL�� ��û�ϴ� ���ϸ� (��� + ���ϸ�)
	                    String requestURL = splitRequestUrlText[1];
	                    
	                    System.out.println("requestURL : " + requestURL);

	                  File file = new File("/Users/leeyura/workspace/study/src/study/index.html");                	
	                	
	                	//TODO ���� ���� ��� 404 NotFound ���ڿ��� �����ؾ���
	                	// �� �Ʒ������� ������ ���� ��� ���� ó���϶�
	                	
	                	byte[] buffer = new byte[1024];
	                	
	                    fis = new FileInputStream(file);
	                    os = socket.getOutputStream();
	                    
	                    // �������信 ���� ������ HTTP �������� ������ ��.
	                    os.write("HTTP/1.1 200 OK \r\n".getBytes());
	                    os.write("Content-Type: text/html;charset=utf-8\r\n".getBytes());
	                    os.write(("Content-Length: " + file.length() + "\r\n").getBytes());
	                    os.write("\r\n".getBytes());
	                    
	                    // FileInputStream���� �о���� ����Ʈ�迭�� Socket�� OutputStream�� write �Ѵ�.
	                    while(fis.read(buffer) >= 0) {
	                    	System.out.println(new String(buffer));
	                    	os.write(buffer);
	                    }

	                    os.write("\r\n".getBytes());
	                    
	                    // ������ stream�� ���� �����Ͱ� ���۾ȵ����� ������ ����
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
