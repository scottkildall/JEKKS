package jekks;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Vehicle {
	int updateTimerSpeed = 50;
	float advanceY = 1.5f;
	float advanceX = 10;
	public int startX = -100;
	public int startY = 350;
	
	static int minSpeed = 30;
	static int maxSpeed = 100;
	
	Timer updateTimer;
	Randomizer r;
	AnimatedImage cloud = null;
	FrameMover cloudMover = null;
	int maxBusX = 2500;
	public Boolean bIsPerson = false;
	
	public Vehicle( PApplet _p, String imageFilename, String exhastFilename ) {
		p = _p;
		r = new Randomizer();
		updateTimer = new Timer(p, updateTimerSpeed);
		img = p.loadImage(imageFilename);
		
		if( exhastFilename != null ) {
			cloud = new AnimatedImage(p, exhastFilename );
			cloudMover = new FrameMover(p);
			cloudMover.setFrameAnimation(cloud);
		}
		
		
		x = startX;
		y = startY;
		
		reset();
	}
	
	void setSpeed( long speed ) {
		updateTimer.setTimer(speed);
	}
	
	void draw() {
		if( updateTimer.expired() ) {
			update();
			updateTimer.start();
		}
		
		p.imageMode(PConstants.CENTER);
		p.tint(255, 240);  // Apply transparency without changing color
		p.image(img,  x,  y );
		
		drawCloud();
		
		
	}
	
	void drawCloud() {
		if( cloudMover != null ) {
			cloudMover.advanceFrame();
			cloudMover.draw(x-(img.width/4), y );
		}
	}

	void update() {
		x += advanceX;
		y += advanceY;
		if( x > maxBusX ) {
			reset();
			x = startX;
			y = startY;
		}
	}
	
	void reset() {
		setSpeed(r.nextIntRange(minSpeed, maxSpeed));
	}
	
	float x;
	float y;
	PImage img;
	PApplet p;
}
