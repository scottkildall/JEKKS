package jekks;

import java.util.Random;

// Accessor class for random number generator
// link for Random class is here:
// http://docs.oracle.com/javase/1.4.2/docs/api/java/util/Random.html
// no error-checking, assumes caller isn't stupid

public class Randomizer {
	Random random;
	
	Randomizer() {
		random = new Random();
	}
	
	int nextIntRange( int lower, int upper) {
		int range = upper-lower;
		
		return lower + random.nextInt(range);
	}
	
	public boolean headsOrTails() {
		return random.nextBoolean();
	}
	
	// pct is between 0.0 and 1.0 � this returns TRUE if less than or EQUAL to that percentage, e.g. 1.0 is always true & 0.0 is always false
	public boolean percentChance( float pct ) {
		return( pct >= random.nextFloat() );
	}
	
	// not implmented
	// e.g. -500.0,to 100;
	float nextFloatRange( float lower, float upper ) {
		int range = (int)(upper-lower);
		
		return lower + random.nextInt(range) + random.nextFloat();
	}
}
