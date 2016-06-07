import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Class Circle: A generic Circle shape with arbitrary Radius.
 * @author Roman Zhang
 *
 */
public class Circle extends Shape{

	private int radius;
	
	private Circle(int inX, int inY) {super(inX,inY);}
	
	public Circle(int inX,int inY, int inRadius){
		super(inX, inY);
		if (inRadius > 0){this.radius = inRadius;}
		else{/* Error */}
	}
	
	public Circle(int inRadius){
		super(0,0);
		this.radius = inRadius;
	}
	
	@Override
	public double getArea(){
		return Math.PI * Math.pow(this.radius,2);
	}

	@Override
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		final int x = this.getX();
		final int y = this.getY();
		final int rad = this.getRadius()*2; //getRadius/2 because drawOval() takes the width DIAMETER 
		g2d.setColor( Color.BLACK );        //and the height DIAMETER as arguments, not a radius. 
		//g2d.setPaint( new GradientPaint( x, y, Color.GREEN, x + RADIUS/4, y + RADIUS/4, Color.BLACK, true) );
		g2d.drawOval(x, y, rad,rad);
	}
	
	public int getRadius(){
		return this.radius;
	}
	
	public void setRadius(int inRad){
		if(inRad > 0){this.radius = inRad;}
		else{/* Error */}
	}

	@Override
	public Object clone() {
		return new Circle(this.radius);
	}
	
	public String toString(){
		return "Circular";
	}
}
