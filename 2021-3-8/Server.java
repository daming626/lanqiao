import java.net.*;
import java.io.*;

public class Server{
	public static void main(String[] args){
		try
		{
			ServerSocket ss=new ServerSocket(8888);//�����˿�
			while(true){
				System.out.println("�ȴ�����...");
				Socket socket=ss.accept();//����
				System.out.println("������...");

				InputStream is=socket.getInputStream();//��������ͨ��
				DataInputStream dis=new DataInputStream(is);
				String versionName=dis.readUTF();
				System.out.println("�ͻ��˰汾�ţ�"+versionName);
				
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
			String fileName=new String("������� - ����.mp3");
			OutputStream os=socket.getOutputStream();//�������ͨ��

			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(fileName);

			FileInputStream fis=new FileInputStream("F:\\ŷ����\\�ļ�����\\"+fileName);
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