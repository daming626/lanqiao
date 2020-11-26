import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;
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
	Random rd=new Random();
	int heroX,heroY,bossX,bossY,flag;
	Image currentImg,bossImg;
	Image heroImg[][]=new Image[4][3];
	public MainCanvas(){
		try{
			for(int i=0;i<heroImg.length;i++)
				for(int j=0;j<heroImg[i].length;j++)
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");

			bossImg=Image.createImage("/1.png");
			currentImg=heroImg[3][1];

			heroX=120;
			heroY=100;
			bossX=0;
			bossY=0;

			flag=0;

			thread=new Thread(this);
			thread.start();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void changePic(int direct){
		if (flag==0){
				currentImg=heroImg[direct][0];
				flag++;
			}
			else{
				currentImg=heroImg[direct][2];
				flag=0;
			}
			repaint();
	}
	public void run() 
	{
		int rdNumber=rd.nextInt(10);
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
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if (action==LEFT){
			changePic(0);
			heroX=heroX-3;
		}
		if (action==RIGHT){
			changePic(1);
			heroX=heroX+3;
		}
		if (action==UP){
			changePic(2);
			heroY=heroY-3;
		}
		if (action==DOWN){
			changePic(3);
			heroY=heroY+3;
		}
	}
}