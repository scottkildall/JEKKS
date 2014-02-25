package jekks;

import processing.core.PApplet;

public class Person extends Vehicle {
	public Person( PApplet _p, String imageFilename, String exhastFilename ) {
		super(_p, imageFilename, exhastFilename);
		
		advanceY =  r.nextFloatRange(2f,4f);
		advanceX = r.nextFloatRange(-9f,-6f);
		
		startX = r.nextIntRange(1200,1280);
		startY = 480;
		bIsPerson = true;
		x = startX;
		y = startY;
	}
	
	void update() {
		x += advanceX;
		y += advanceY;
		if( y > 1000 ) {
			reset();
			x = startX;
			y = startY;
		}
	}
}
