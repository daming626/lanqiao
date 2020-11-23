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
	int x,y,flag;
	Image currentImg;
	Image heroImg[][]=new Image[4][3];
	/*0向左，1向右，2向上，3向下*/
	public MainCanvas()
	{
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++)
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			currentImg=heroImg[3][1];

			x=110;
			y=200;
			flag=0;
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
		g.drawImage(currentImg,x,y,0);			 
	}
	public void changePic(int diret){
		if (flag==0){
				currentImg=heroImg[diret][0];
				flag++;
			}
		else if (flag==1){
			currentImg=heroImg[diret][2];
			flag=0;
		}
		repaint();
	}
	public void keyPressed(int keyCode)				 
	{
		int action=getGameAction(keyCode);
		if (action==LEFT)							
		{
			changePic(0);
			x=x-5;
		}												
		if (action==RIGHT)							
		{
			changePic(1);
			x=x+5;
		}
		if (action==UP)								
		{		
			changePic(2);
			y=y-5;
		}
		if (action==DOWN)							
		{
			changePic(3);
			y=y+5;
		}
		if (x<0){x=0;}				
		if (x>220){x=220;}			
		if (y<0){y=0;}				
		if (y>260){y=260;}			
	}
}
		/*if (action==LEFT){
			if (leftFlag==0){
				currentImg=heroImg[0][0];leftFlag++;
			}
			else if (leftFlag==1){
				currentImg=heroImg[0][2];leftFlag=0;
			}
		}*/