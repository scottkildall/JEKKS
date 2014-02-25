package jekks;

import processing.core.PApplet;

public class Car extends Vehicle {
	public Car( PApplet _p, String imageFilename, String exhastFilename ) {
		super(_p, imageFilename, exhastFilename);
		
		advanceY =  r.nextFloatRange(2f,4f);
		advanceX = r.nextFloatRange(-9f,-6f);
		
		
		startY = 350;
		y = startY;
		
	}
	
	void drawCloud() {
		if( cloudMover != null ) {
			cloudMover.advanceFrame();
			cloudMover.draw(x-(img.width/4) -5, y + 20);
		}
	}
}
