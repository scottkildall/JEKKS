package jekks;

import processing.core.PApplet;

public class Truck extends Vehicle {
	public Truck( PApplet _p, String imageFilename, String exhastFilename ) {
		super(_p, imageFilename, exhastFilename);
	}
	
	void drawCloud() {
		if( cloudMover != null ) {
			cloudMover.advanceFrame();
			cloudMover.draw(x-(img.width/4) + 20, y );
		}
	}
}
