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
			downImg=Image.createImage("/sayo10.png");		/* 录入图片 */
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
		g.setColor(0,128,255);						 /*背景颜色*/
		g.fillRect(0,0,getWidth(),getHeight());		
		g.drawImage(currentImg,x,y,0);			 /*读取图片*/
	}
	public void keyPressed(int keyCode)				 /*键盘输入指令*/
	{
		int action=getGameAction(keyCode);
		if (action==LEFT)							/*  向左走  */
		{
			if (i==0){currentImg=leftImg;}
			if (i==1){currentImg=leftImg1;}
			if (i==2){currentImg=leftImg2;}
			x=x-5;
			i=i+1;
			
		}												
		if (action==RIGHT)							/*  向右走  */
		{
			if (i==0){currentImg=rightImg;}
			if (i==1){currentImg=rightImg1;}
			if (i==2){currentImg=rightImg2;}
			x=x+5;
			i=i+1;
		}
		if (action==UP)								/*  向上走  */
		{		
			if (i==0){currentImg=upImg;}
			if (i==1){currentImg=upImg1;}
			if (i==2){currentImg=upImg2;}
			y=y-5;
			i=i+1;
		}
		if (action==DOWN)							/*  向下走  */
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
		if (i>2){i=0;}				/* 重置i */
		if (x<0){x=0;}				/* 限制宽度 */
		if (x>220){x=220;}			/* 限制宽度 */
		if (y<0){y=0;}				/* 限制高度 */
		if (y>260){y=260;}			/* 限制高度 */
		repaint();
	}
}