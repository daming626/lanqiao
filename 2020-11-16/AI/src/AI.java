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
	int x,y,i;
	Image currentImg,downImg,downImg1,downImg2,leftImg,leftImg1,leftUpImg,
		leftImg2,rightImg,rightImg1,rightImg2,upImg,upImg1,upImg2;
	
	public MainCanvas()
	{
		try
		{
			downImg=Image.createImage("/sayo10.png");		/* ¼��ͼƬ */
			downImg1=Image.createImage("/sayo20.png");
			downImg2=Image.createImage("/sayo00.png");
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo22.png");
			leftImg2=Image.createImage("/sayo02.png");
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo26.png");
			rightImg2=Image.createImage("/sayo06.png");
			leftUpImg=Image.createImage("/sayo15.png");
			currentImg=downImg;
			x=110;
			y=200;
			i=0;
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
			if (i==0){currentImg=leftImg;}
			if (i==1){currentImg=leftImg1;}
			if (i==2){currentImg=leftImg2;}
			x=x-5;
			i=i+1;
			
		}												
		if (action==RIGHT)							/*  ������  */
		{
			if (i==0){currentImg=rightImg;}
			if (i==1){currentImg=rightImg1;}
			if (i==2){currentImg=rightImg2;}
			x=x+5;
			i=i+1;
		}
		if (action==UP)								/*  ������  */
		{		
			if (i==0){currentImg=upImg;}
			if (i==1){currentImg=upImg1;}
			if (i==2){currentImg=upImg2;}
			y=y-5;
			i=i+1;
		}
		if (action==DOWN)							/*  ������  */
		{
			if (i==0){currentImg=downImg;}
			if (i==1){currentImg=downImg1;}
			if (i==2){currentImg=downImg2;}
			y=y+5;
			i=i+1;
		}
		if (action==RIGHT-UP)
		{
			currentImg=leftUpImg;
			x=x+5;
			y=y-5;
		}
		if (i>2){i=0;}				/* ����i */
		if (x<0){x=0;}				/* ���ƿ�� */
		if (x>220){x=220;}			/* ���ƿ�� */
		if (y<0){y=0;}				/* ���Ƹ߶� */
		if (y>260){y=260;}			/* ���Ƹ߶� */
		repaint();
	}
}