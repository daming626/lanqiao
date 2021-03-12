import java.net.*;
import java.io.*;

public class Client{
	public static void main(String[] args){
		try
		{
			Socket socket=new Socket("LocalHost",8888);//连接
			OutputStream os=socket.getOutputStream();//构建输出通道
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF("v5.5.1");
			dos.flush();
			
			GetFileThread gft=new GetFileThread(socket);
			gft.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
class GetFileThread extends Thread{
	Socket socket;
	public GetFileThread(Socket socket){
		this.socket=socket;
	} 
	public void run(){
		try
		{
			InputStream is=socket.getInputStream();

			DataInputStream dis=new DataInputStream(is);
			String fileName=dis.readUTF();

			FileOutputStream fos=new FileOutputStream("F:\\"+fileName);
			byte buff[]=new byte[1024];
			int a=0;
			while ((a=is.read(buff))!=-1)
			{
				fos.write(buff,0,a);
			}
			dis.close();
			fos.close();
			is.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}