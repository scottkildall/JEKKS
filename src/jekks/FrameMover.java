package jekks;

import processing.core.PApplet;

public class FrameMover {
	FrameMover(PApplet _p) {
		p = _p;
		
		animTimer = new Timer(p,timerRate);
		animTimer.start();
	}
	
	void setFrameAnimation(AnimatedImage _frameAnim) {
		frameAnim = _frameAnim;
		frameNum = 0;
	}
	
	void draw(float x, float y) {
		p.image(frameAnim.frames[frameNum], x,y);
	}
	
	//-- subclass should call on every draw() command
	void advanceFrame() {
		if( frameAnim == null ) {
			System.out.println("no frame anim");
			return;
		}
		
		// Advances by frame
		if( frameRate > 0 ) {
			currentFrame++;
			if( currentFrame == frameRate ) {
				currentFrame = 0;
				frameNum++;
				if( frameNum == frameAnim.getNumFrames())
					frameNum = 0;
			}
		}
				
		// Advances by timer
		else if( animTimer.expired()) {
			frameNum++;
			if( frameNum == frameAnim.getNumFrames())
				frameNum = 0;
				animTimer.start();
		}
	}
	
	//-- if frame rate = 0, user timer
	void frameOutput( int _frameRate ) {
		frameRate = _frameRate;
		currentFrame = 0;
		frameNum = 0;
	}
		
	void timerOutput( int _timerRate ) {
		timerRate = _timerRate;
		frameRate = 0;
		animTimer.setTimer(timerRate);
		animTimer.start();	
	}
	
	int currentFrame = 0;	// how many times for each frame
	int frameRate = 0;
	int timerRate = 200;
	
	Timer animTimer;
	int frameNum = 0;
	
	AnimatedImage frameAnim = null;
	
	PApplet p;
}
