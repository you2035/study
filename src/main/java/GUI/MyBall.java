package GUI;

import java.awt.*;
public class MyBall {
	public static void main(String args[]){
		Frame w=new Frame();
		w.setSize(800,500);
		
		MyPanel mp=new MyPanel();
		w.add(mp);
		
		Thread t=new Thread(mp);
		t.start();
		w.show();
	}
}
class MyPanel extends Panel implements Runnable{
	int x=20;
	int y=30;
	int att;//0就是右下角方向飞行，1就是左下，2就是左上，3就是右上；
	public void paint(Graphics g){
		if(att==0)
			g.setColor(Color.black);
		if(att==1)
			g.setColor(Color.blue);
		if(att==2)
			g.setColor(Color.yellow);
		if(att==3)
			g.setColor(Color.red);
		g.fillOval(x, y, 50, 50);
		
	}
	public void run(){
	while(true){
		//定义飞行姿态
			if(att==0){
				x++;
				y++;
			}
			if(att==1){
				x--;
				y++;
			}
			if(att==2){
				x--;
				y--;
			}
			if(att==3){
				x++;
				y--;
			}
			//改变飞行姿态；
			if(x>734){//小球撞击右边墙
				if(att==0)
					att=1;
				else{
					att=2;
				}
			}
			if(y>414){//小球撞击下边墙
				if(att==1){
					att=2;
					
				}
				else{
					att=3;
				}
			}
			if(x<0){//小球撞击左边墙
				if(att==2){
					att=3;
				}
				else{
					att=0;
				}
			}
			if(y<0){//小球撞击上边墙
				if(att==3){
					att=0;
				}
				else{
					att=1;
				}
			}
			
			try{
				Thread.sleep(10);
			}catch(Exception e){}
			repaint();
		}
	}
}
