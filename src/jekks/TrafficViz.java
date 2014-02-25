package jekks;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class TrafficViz {
	Randomizer r;
	Timer t;
	static int numVehicles = 10;
	
	PImage backgroundImage;
	PImage legend;

	Vehicle [] vehicles;
	Boolean [] bSpawned;
	
//	Vehicle busVehicle;
//	Vehicle carVehicle;

	
	Timer spawnTimer;
	
	public TrafficViz( PApplet _p) {
		p = _p;
		
		t = new Timer(p, 100);
		r = new Randomizer();
		
		spawnTimer = new Timer(p,1L);
		spawnTimer.start();
		
		backgroundImage = p.loadImage("street_fixed.jpg");
		legend = p.loadImage("ghettoLegend.png");
		initVehicles();
	}
	
	void draw() {
		p.imageMode(PConstants.CORNERS);
		p.noTint();
		p.image(backgroundImage, 0,0);
		
		if( spawnTimer.expired() ) {
			spawnTimer.setTimer(r.nextIntRange(3000, 5000));
			spawnTimer.start();
			
			spawnVehicle();
		}
		
		//-- draw vehicles
		for( int i = 0; i < numVehicles; i++ ) {
			if( bSpawned[i] == true ) {
				if( vehicles[i].bIsPerson == false)
					vehicles[i].draw();
			}
		}
				
		//-- draw people
		for( int i = 0; i < numVehicles; i++ ) {
			if( bSpawned[i] == true ) {
				if( vehicles[i].bIsPerson)
					vehicles[i].draw();
			}
		}
		
		p.noTint();
		int lx = 200;
		int ly = 600;
		p.image(legend, lx,ly);
		
		
		
	}
	
	PApplet p;


	void initVehicles() {
		vehicles = new Vehicle[numVehicles];
		bSpawned = new Boolean[numVehicles];
		
		for( int i = 0; i < bSpawned.length; i++ )
			bSpawned[i] = false;
		
		vehicles[0] = new Vehicle(p, "busAbstract.png", "busExhaust");
		vehicles[1] = new Vehicle(p, "carAbstract.png", "carExhaust");
		vehicles[2] = new Person(p, "personAbstract.png", null);
		vehicles[3] = new Person(p, "personAbstract.png", null);
		vehicles[4] = new Person(p, "personAbstract.png", null);
		vehicles[5] = new Person(p, "personAbstract.png", null);
		vehicles[6] = new Truck(p, "truckAbstract.png", "truckExhaust");
		vehicles[7] = new Vehicle(p, "carAbstract.png", "carExhaust");
		vehicles[8] = new Person(p, "personAbstract.png", null);
		vehicles[9] = new Person(p, "personAbstract.png", null);
	}
	
	//-- go for next one in the list
	void spawnVehicle() {
		for( int i = 0; i < numVehicles; i++ ) {
			if( bSpawned[i] == false ) {
				bSpawned[i] = true;
				
				if( vehicles[i].bIsPerson == true ) {
					spawnTimer.setTimer(r.nextIntRange(1000, 2000));
					spawnTimer.start();
				}
				break;
			}
		}
		
		
		
	}

}
