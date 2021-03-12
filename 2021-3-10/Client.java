import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		try
		{
			Socket socket=new Socket("LocalHost",9999);
			InputStream is=socket.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			String fileName=dis.readUTF();
			//System.out.println(fileName);
			FileOutputStream fos=new FileOutputStream("F:\\"+fileName);
			System.out.println(fileName);
			byte[] buff=new byte[1024];
			int message=0;
			while ((message=is.read(buff))!=-1)
			{
				fos.write(buff,0,message);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
}
/*class GetFileThread extends Thread{
	Socket socket;

	public GetFileThread(Socket socket){
		this.socket=socket;
	}

	public void run(){
		try
		{
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}*/