package cn.tedu.shoot;

import java.awt.image.BufferedImage;

//大飞机
public class BigAirplane extends FlyingObject{
	
	private static BufferedImage[] images;
	static {
		images=new BufferedImage[5];
		images[0]=readImage("bigairplane0.png");
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
			
		}
	}

	private int step;
	public BigAirplane() {
		super(66,89);
		step=2;
		
	}

	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度"+step);
	}
	int index=1;
	public BufferedImage getImage() {
		BufferedImage img=null;
		if(isLife()) {
			img=images[0];
		}else if(isDead()) {
			img=images[index++];
			if(index>=images.length) {
				state=REMOVE;
			}
		}
		return img;
	}
	//重写父类的抽象方法
	public void step() {
		y+=step;
	}
}








