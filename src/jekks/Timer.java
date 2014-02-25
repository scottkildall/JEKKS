package jekks;

import processing.core.PApplet;

public class Timer {
	//-------- PUBLIC FUNCTIONS --------/
	public Timer(PApplet _p, long _duration ) { 
		p = _p;
		setTimer(_duration);
	}
	
	public void setTimer(long _duration) {
			duration = _duration;
	}
	
	public void start() { 
		startTime = p.millis();
	}
	
	public Boolean expired() {
		return ((startTime + duration) < p.millis());
	}
	
	void expire() {
		duration = 0L;
	}
	
	public float percentage() {
		if( expired() )
			return 1.0f;
		else
			return (float)(p.millis()-startTime)/(float)duration; 
	}
	
	
	//-------- PRIVATE VARIABLES --------/
	protected PApplet p;
	private long duration;
	protected long startTime = 0;
}
