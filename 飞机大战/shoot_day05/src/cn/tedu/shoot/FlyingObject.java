package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class FlyingObject {
	//每个飞行物有三种状态
	//活着，死了和移除
	public static final int LIFE=0;
	public static final int DEAD=1;
	public static final int REMOVE=2;
	//保存当前飞行物的属性
	protected int state=LIFE;//初始状态活着
	
	//所有子类共用的属性
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	//小敌机，大敌机，奖励机的构成
	public FlyingObject(int width, int height) {
		Random ran=new Random();
		this.width = width;
		this.height = height;
		x=ran.nextInt(400-width);
		y=height;
	}
	//sky ,hero,bullet
	public FlyingObject(int width, int height, int x, int y) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
	}
	;
	//这个方法用于读取图片到java程序
	public static BufferedImage readImage(String fileName) {
		try {
			//读取硬盘上的图片到img对象
			BufferedImage img=ImageIO.read(FlyingObject.class.getResource(fileName));
		    return img;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//判断飞行物是否活着
	public boolean isLife() {
		return state==LIFE;
	}//判断飞行物是否死了
	public boolean isDead() {
		return state==DEAD;
	}
	//判断飞行物是否移除
	public boolean isRemove() {
		return state==REMOVE;
	}
	
	//编写抽象方法
	//获得图片(从数组中获得)
	public abstract BufferedImage getImage();
	
	//绘制获得的图片
	public void paintObject(Graphics g) {//面板
		//将获得的图片绘制到画板(g)
		g.drawImage(getImage(),x,y,null);
	}

}











