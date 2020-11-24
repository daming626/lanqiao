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
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int heroX,heroY,bossX,bossY,flag;
	Image currentImg,bossImg;
	Image heroImg[][]=new Image[4][3];
	/*4个方向，每个方向四张图片，0表示left，1表示right，2表示up，3表示down*/
	public MainCanvas()
	{
		try
		{
			for(int i=0;i<heroImg.length;i++)
			{
				for(int j=0;j<heroImg[i].length;j++)
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			bossImg=Image.createImage("/b0.png");
			currentImg=heroImg[3][1];

			heroX=110;
			heroY=200;

			bossX=0;
			bossY=0;

			flag=0;

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run() /*多线程，死循环实现boss追hero*/
	{
		while(true){
		try{
			Thread.sleep(200);			
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		if(bossX<heroX){
			bossX=bossX+2;
		}
			else{
				bossX=bossX-2;
			}
		if(bossY<heroY){
			bossY=bossY+2;
		}
		else{
			bossY=bossY-2;
		}
		repaint();

		}
	}
	public void paint(Graphics g)
	{
		g.setColor(0,128,255);						 
		g.fillRect(0,0,getWidth(),getHeight());		
		g.drawImage(currentImg,heroX,heroY,0);	
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void changePicAndMove(int diret) /*自定义方法，实现hero图片更新与移动*/
	{
		if (flag==0){
			currentImg=heroImg[diret][0];
			flag++;
		}
		else if (flag==1){
		currentImg=heroImg[diret][2];
		flag=0;
		}
	}
	public void keyPressed(int keyCode)   /*键盘输入指令*/
	{
		int action=getGameAction(keyCode);
		if (action==LEFT){
			changePicAndMove(0);
			heroX=heroX-5;
		}												
		if (action==RIGHT){
			changePicAndMove(1);
			heroX=heroX+5;
		}
		if (action==UP){		
			changePicAndMove(2);
			heroY=heroY-5;
		}
		if (action==DOWN){
			changePicAndMove(3);
			heroY=heroY+5;
		}
		if (heroX<0){heroX=0;}				/*限制hero活动范围*/
		if (heroX>220){heroX=220;}			
		if (heroY<0){heroY=0;}				
		if (heroY>260){heroY=260;}		
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