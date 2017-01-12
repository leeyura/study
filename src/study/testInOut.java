package study;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class testInOut {
	  public static void main(String[] args) {
	        
	        FileInputStream fis = null;
	        DataInputStream dis = null;
	        
	        FileOutputStream fos = null;
	        DataOutputStream dos = null;
	        
	        try{
	            
	            // "StreamFile.out" ������ ����ϴ� ��ü�� �����Ѵ�.
	            // DataOutputStream Filter�� �����Ѵ�.
	            fos = new FileOutputStream("StreamFile.out");
	            dos = new DataOutputStream(fos);
	            
	            // "StreamFile.out" ���Ͽ� �� �⺻�� �����͸� ����Ѵ�.
	            dos.writeBoolean(false);
	            dos.writeByte(Byte.MAX_VALUE);
	            dos.writeChar('��');
	            dos.writeDouble(Double.MAX_VALUE);
	            dos.writeFloat(Float.MIN_VALUE);
	            dos.writeLong(Long.MAX_VALUE);
	            dos.writeShort(Short.MAX_VALUE);
	            dos.writeUTF("�ȳ��ϼ���");
	            
	            // "StreamFile.out" ������ �д� ��ü�� �����Ѵ�.
	            // DataInputStream Filter�� �����Ѵ�.
	            fis = new FileInputStream("StreamFile.out");
	            dis = new DataInputStream(fis);
	            
	            // "StreamFile.out" ���Ͽ��� �� �⺻�� �����͸� �о�´�.
	            System.out.println(dis.readBoolean());
	            System.out.println(dis.readByte());
	            System.out.println(dis.readChar());
	            System.out.println(dis.readDouble());
	            System.out.println(dis.readFloat());
	            System.out.println(dis.readLong());
	            System.out.println(dis.readShort());
	            System.out.println(dis.readUTF());
	        
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            
	            if(dis != null) try{dis.close();}catch(IOException e){}
	            if(fis != null) try{fis.close();}catch(IOException e){}
	                        
	            if(dos != null) try{dos.close();}catch(IOException e){}
	            if(fos != null) try{fos.close();}catch(IOException e){}
	                      
	        }
	        

	    }
}
