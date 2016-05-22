import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class Rectangle: A generic 90 degree quadrilatiral with arbitrary width and height.
 * @author Roman Zhang
 *
 */
public class Rectangle extends Shape{

	private int width;
	private int height;
	
	private Rectangle(int inX, int inY){super(inX,inY);}
	
	public Rectangle(int inX, int inY, int inWidth, int inHeight) {
		super(inX, inY);
		if(inWidth > 0 && inHeight > 0){
			this.width = inWidth;
			this.height = inHeight;
		}else{/*Error*/}
	}

	@Override
	public void draw(Graphics g){
		Graphics g2d = (Graphics2D) g;
		g2d.setColor( Color.BLACK ); 
		g2d.drawRect(this.getX(), this.getY(), this.width, this.height);
	}
	
	public void setWidth(int inWidth){
		if(inWidth > 0){
			this.width = inWidth;
		}else{/*Error*/}
	}
	
	public void setHeight(int inHeight){
		if(inHeight > 0){
			this.height = inHeight;
		}else{/*Error*/}
	}
	
	@Override
	public double getArea(){
		double area = this.width * this.height;
		return area;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
}
