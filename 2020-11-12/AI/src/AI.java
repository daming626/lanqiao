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
	Image currentImg,img1,img2,img3,img4,img5;
	public MainCanvas()
	{
		try
		{
			img1=Image.createImage("/sayo10.png");
			img2=Image.createImage("/sayo12.png");
			img3=Image.createImage("/sayo16.png");
			img4=Image.createImage("/sayo04.png");
			img5=Image.createImage("/sayo20.png");
			currentImg=img1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(0,128,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,110,200,0);
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);
		if (action==LEFT)
		{
			System.out.println("ss");
			currentImg=img2;
			repaint();
		}
		if (action==RIGHT)
		{
			System.out.println("ssd");
			currentImg=img3;
			repaint();
		}
		if (action==UP)
		{
			System.out.println("ssas");
			currentImg=img4;
			repaint();
		}
		if (action==DOWN)
		{
			System.out.println("ssfd");
			currentImg=img5;
			repaint();
		}
	}
}
