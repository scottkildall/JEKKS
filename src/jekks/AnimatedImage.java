package jekks;

import processing.core.PApplet;
import processing.core.PImage;

public class AnimatedImage
{
      PApplet p;
      
	  int numFrames;
	  PImage [] frames = null;
	  
	  AnimatedImage(PApplet _p, String fileBaseName ) {    
	    p = _p;
	    
	    PImage tempImage;
	    
	    Boolean loop = true;
	    int i = 0;
	    frames = new PImage[1];  // have to allocate at least one in the array, otherwise no compile
	      
	    String s = p.sketchPath("xxx"); 
	      while( loop ) {
	         tempImage = p.loadImage(fileBaseName + (i+1) + ".png");  // note: this will give you an error in the debug window
	         if( tempImage == null )  {
	            numFrames = i;     
	            loop = false;  
	         }
	         else {
	           frames = (PImage[])PApplet.expand(frames, i+1);
	           frames[i] = tempImage;
	           i++;
	         }          
	      } 
	  }
	  
	  
	  int getNumFrames() {
	    return numFrames;
	  }
	}