package jekks;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;

import processing.video.*;



public class JEKKS extends PApplet {
	static int EMBARCADERO = 0;
	static int MONTGOMERY = 1;
	static int POWELL = 2;
	static int CIVICCENTER = 0;
	
	static int numStations = 4;
	static int numObjects = 4;
	static int [] stationX;
	static int [] stationY;
	
	Table rawTable;
	Table t;
	Timer ambientTimer;
	Timer trafficTimer;
	int numRows = 5;
	int currentRow = 0;
	Randomizer r;
	
	TrafficViz trafficViz;
	Boolean bDataViz = false;

	
	public void setup() {
		size(1280,720);
		trafficViz = new TrafficViz(this);
		r = new Randomizer();
		
		ambientTimer = new Timer(this, 1000);
		ambientTimer.start();
		trafficTimer = new Timer(this,50);
		trafficTimer.start();
		
		initStations();
		loadData();
		
		
		
		
		//loadData();
	}

	public void draw() {
		background(0);
		//this.imageMode(CORNERS);
		trafficViz.draw();		
	}
	
	public void keyPressed() {
		bDataViz = !bDataViz;
		
	}
	public void mousePressed() {
		println( "x = " + mouseX);
		println( "y = " + mouseY);
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { jekks.JEKKS.class.getName() });
	}
	
	void initStations() {
		stationX = new int[numStations];
		stationY = new int[numStations];
		
		// EMBARCADEO
		stationX[0] = 858;
		stationY[0] = 115;
		
		// MONTGOMERY
		stationX[1] = 744;
		stationY[1] = 229;
		
		// POWELL
		stationX[2] = 610;
		stationY[2] = 355;
		
		// CIVIC CENTER
		stationX[3] = 451;
		stationY[3] = 524;
	}
	
	//-- Organized by time stamp, then locations
	/*
	 * void covertData() {
		rawTable = loadTable("rawTable.csv", "header");
		println( rawTable.getRowCount() + " total rows in table");
		
		for( TableRow row : rawTable.rows()) {
			String time = row.getString("Timestamp");
			String station = row.getString("Station");
			String object = row.getString("Object");
			int count = row.getInt("Count");
			println(time + " " + station + " " + object + " " + count);
		}	
	}
	*/
	
	
	void loadData() {
		// empty table
		t = new Table();
		t.addColumn("timestamp");
		for( int i = 0; i < 16; i++ )	
			t.addColumn();
			
	
		for( int i = 1; i < 17; i++ ) {
			for( int j = 0; j < numRows; j++ )	
				t.setInt(j, i, r.nextIntRange(0, 10));
		}
	}
	
}
