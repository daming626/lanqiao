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
	Image heroImg[][]=new Image[4][3];
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
		g.setColor(0,128,255);						 
		g.fillRect(0,0,getWidth(),getHeight());		
		g.drawImage(currentImg,x,y,0);			 
	}
	public void keyPressed(int keyCode)				 
	{
		int action=getGameAction(keyCode);
		if (action==LEFT)							
		{
			if (leftFlag==0){
				currentImg=heroImg[0][0];leftFlag++;
			}
			else if (leftFlag==1){
				currentImg=heroImg[0][2];leftFlag=0;
			}
			x=x-5;
			
		}												
		if (action==RIGHT)							
		{
			if (rightFlag==0){
				currentImg=heroImg[1][0];
				rightFlag++;
			}
			else if (rightFlag==1){
				currentImg=heroImg[1][2];
				rightFlag=0;
			}
			x=x+5;
		}
		if (action==UP)								
		{		
			if (upFlag==0){
				currentImg=heroImg[2][0];
				upFlag++;
			}
			else if (upFlag==1){
				currentImg=heroImg[2][2];
				upFlag=0;
			}
			y=y-5;
		}
		if (action==DOWN)							
		{
			if (downFlag==0){
				currentImg=heroImg[3][0];
				downFlag++;
			}
			else if (downFlag==1){
				currentImg=heroImg[3][2];
				downFlag=0;
			}
			y=y+5;
		}
		if (x<0){x=0;}				
		if (x>220){x=220;}			
		if (y<0){y=0;}				
		if (y>260){y=260;}			
		repaint();
	}
}