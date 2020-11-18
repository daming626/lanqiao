import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y,leftFlag,rightFlag,upFlag,downFlag;
	Image currentImg;
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	public MainCanvas()
	{
		try
		{
			for(int i=0;i<heroLeftImg.length;i++)					/* �� */
			heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");

			for(int i=0;i<heroRightImg.length;i++)					/* �� */
			heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");

			for(int i=0;i<heroUpImg.length;i++)						/* �� */
			heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");

			for(int i=0;i<heroDownImg.length;i++)					/* �� */ 
			heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");

			/*	��
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo22.png");
			leftImg2=Image.createImage("/sayo02.png");
			*/

			/*  ��
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo26.png");
			rightImg2=Image.createImage("/sayo06.png");
			*/

			/*  ��
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			*/

			/*  ��
			downImg=Image.createImage("/sayo10.png");		
			downImg1=Image.createImage("/sayo20.png");
			downImg2=Image.createImage("/sayo00.png");
			*/


			/*leftUpImg=Image.createImage("/sayo15.png");*/

			currentImg=heroDownImg[1];

			x=110;
			y=200;

			leftFlag=0;
			rightFlag=0;
			upFlag=0;
			downFlag=0;

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)					
	{
		g.setColor(0,128,255);						 /*������ɫ*/
		g.fillRect(0,0,getWidth(),getHeight());		
		g.drawImage(currentImg,x,y,0);			 /*��ȡͼƬ*/
	}
	public void keyPressed(int keyCode)				 /*��������ָ��*/
	{
		int action=getGameAction(keyCode);
		if (action==LEFT)							/*  ������  */
		{
			if (leftFlag==0){currentImg=heroLeftImg[2];leftFlag++;}
			else if (leftFlag==1){currentImg=heroLeftImg[0];leftFlag=0;}
			x=x-5;
			
		}												
		if (action==RIGHT)							/*  ������  */
		{
			if (rightFlag==0){currentImg=heroRightImg[2];rightFlag++;}
			else if (rightFlag==1){currentImg=heroRightImg[0];rightFlag=0;}
			x=x+5;
		}
		if (action==UP)								/*  ������  */
		{		
			if (upFlag==0){currentImg=heroUpImg[0];upFlag++;}
			else if (upFlag==1){currentImg=heroUpImg[2];upFlag=0;}
			y=y-5;
		}
		if (action==DOWN)							/*  ������  */
		{
			if (downFlag==0){currentImg=heroDownImg[2];downFlag++;}
			else if (downFlag==1){currentImg=heroDownImg[0];downFlag=0;}
			y=y+5;
		}
		if (x<0){x=0;}				/* ���ƿ�� */
		if (x>220){x=220;}			
		if (y<0){y=0;}				/* ���Ƹ߶� */
		if (y>260){y=260;}			
		repaint();
	}
}