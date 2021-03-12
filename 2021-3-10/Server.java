import java.io.*;
import java.net.*;
import java.util.*;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;

public class Server{
	public static void main(String[] args){
		try
		{
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("等待连接中...");
			while (true)
			{
				Socket socket=ss.accept();
				System.out.println("已连接...");
				SendFileThread sft=new SendFileThread(socket);
				sft.start();
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
			/*
			InputStream in=Class.forName("Server").getResourceAsStream("/config.xml");
			SAXReader saxReader=new SAXReader();
			Document document=saxReader.read(in);
			Element element=(Element)document.selectObject("\\files\\fileName");
			*/

			File file=new File(ParseXml.getFileName());
			OutputStream os=socket.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			//dos.writeUTF(element.getStringValues());
			dos.writeUTF(file.getName());
			dos.flush();

			//FileInputStream fis=new FileInputStream("F:\\新建文件夹\\"+element.getStringValues());
			FileInputStream fis=new FileInputStream("F:\\新建文件夹\\"+file.getName());
			byte[] buff=new byte[1024];
			int message=0;
			while ((message=fis.read(buff))!=-1)
			{
				os.write(buff,0,message);
			}
			os.close();
			fis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}