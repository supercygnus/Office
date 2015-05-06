<%@ page contentType="image/jpeg;"%>
<%@ page import="java.awt.*,java.io.*,java.util.Random,javax.imageio.*,java.awt.image.*"%>

<%!
	public Color getRandomColor(int r1,int r2){
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

%>


<%

OutputStream os=response.getOutputStream();
int width=100;
int height=35;

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
	g.drawString(temp, 20*i+15, 25);
}

	session.setAttribute("code", verifycode);
	g.dispose();
	ImageIO.write(image, "jpeg", os);
	os.flush();
	os.close();
	os=null;
	response.flushBuffer();
	out.clear();
	out = pageContext.pushBody();

%>