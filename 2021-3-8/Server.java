import java.net.*;
import java.io.*;

public class Server{
	public static void main(String[] args){
		try
		{
			ServerSocket ss=new ServerSocket(8888);//创建端口
			while(true){
				System.out.println("等待连接...");
				Socket socket=ss.accept();//连接
				System.out.println("已连接...");

				InputStream is=socket.getInputStream();//构建输入通道
				DataInputStream dis=new DataInputStream(is);
				String versionName=dis.readUTF();
				System.out.println("客户端版本号："+versionName);
				
				if ("v5.5.3".equals(versionName))
				{
					continue;
				}else{
					SendFileThread sft=new SendFileThread(socket);
					sft.start();
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	} 
}
class SendFileThread extends Thread{
	Socket socket;
	public SendFileThread(Socket socket){
		this.socket=socket;
	}
	public void run(){
		try
		{
			String fileName=new String("李健、王菲 - 传奇.mp3");
			OutputStream os=socket.getOutputStream();//构建输出通道

			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(fileName);

			FileInputStream fis=new FileInputStream("F:\\欧家明\\文件传输\\"+fileName);
			byte buff[]=new byte[1024];
			int a=0;
			while ((a=fis.read(buff))!=-1)
			{
				os.write(buff,0,a);
			}
			dos.close();
			os.close();
			fis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}