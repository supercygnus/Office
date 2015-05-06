package office.yueyiqiu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.cometd.bayeux.Bayeux;

import com.opensymphony.xwork2.ActionContext;

public class ValidationPic{
	public static void main(String[] args){
		
		int width=100;
		int height=50;
		
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		Random random=new Random();
		
		g.setColor(getRandomColor(200,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.PLAIN,25));
		g.setColor(getRandomColor(160,200));
		
		for(int i=0;i<155;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(15);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x+x1, y+y1);
		}
		
		String verifycode="";
		
		for(int i=0;i<4;i++){
			int ptr=random.nextInt(64);
			String temp="";
			
			if(ptr<10){
				temp=String.valueOf(random.nextInt(10));
			}
			else if(ptr<36){
				temp=((char)(97+random.nextInt(26)))+"";
			}
			else{
				temp=((char)(65+random.nextInt(26)))+"";
			}
			verifycode=verifycode+temp;
			g.setColor(new Color(25+random.nextInt(110),25+random.nextInt(110),25+random.nextInt(110)));
			g.drawString(temp, 20*i+15, 40);
		}
		
		try {
			ImageIO.write(image, "jpg", new File("d:\\aaa.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ContinuationCometdServlet oo=new ContinuationCometdServlet();
		//ContinuationCometdServlet.
		
		//Bayeux b=(Bayeux)ActionContext.getContext().getApplication().get(Bayeux.DOJOX_COMETD_BAYEUX);
		
		
	}
	
	public static Color getRandomColor(int r1,int r2){
		Random random=new Random();
		if(r1>255)
			r1=255;
		if(r2>255)
			r2=255;
		
		int r=r1+random.nextInt(r2-r1);
		int g=r1+random.nextInt(r2-r1);
		int b=r1+random.nextInt(r2-r1);
		
		return new Color(r,g,b);
	}
}
