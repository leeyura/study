package wsTest;

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
	            fos = new FileOutputStream("StreamFile.out");
	            dos = new DataOutputStream(fos);
	            
	            dos.writeBoolean(false);
	            dos.writeByte(Byte.MAX_VALUE);
	            dos.writeDouble(Double.MAX_VALUE);
	            dos.writeFloat(Float.MIN_VALUE);
	            dos.writeLong(Long.MAX_VALUE);
	            dos.writeShort(Short.MAX_VALUE);
	            
	            fis = new FileInputStream("StreamFile.out");
	            dis = new DataInputStream(fis);
	            
	            System.out.println(dis.readBoolean());
	            System.out.println(dis.readByte());
	            System.out.println(dis.readDouble());
	            System.out.println(dis.readFloat());
	            System.out.println(dis.readLong());
	            System.out.println(dis.readShort());
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
