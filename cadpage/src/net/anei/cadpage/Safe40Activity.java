package net.anei.cadpage;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;

/**
 * Subclass of standard android.app.Activity class with some workaround that
 * are supposed to avoid the dreaded 
 * java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
 * problem at Android 4.0 and up
 */
public class Safe40Activity extends Activity {
  
  @Override
  protected void onSaveInstanceState(Bundle outState) {

    outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
    super.onSaveInstanceState(outState);

    int orientation = this.getDisplayOrientation();
    
    //Lock the screen orientation to the current display orientation : Landscape or Portrait
    this.setRequestedOrientation(orientation);

  }


  //A method found in stackOverflow, don't remember the author, to determine the right screen
  //orientation independently of the phone or tablet device 
  private int getDisplayOrientation(){
    Display getOrient = getWindowManager().getDefaultDisplay();

    int orientation = getOrient.getOrientation();

    // Sometimes you may get undefined orientation Value is 0
    // simple logic solves the problem compare the screen
    // X,Y Co-ordinates and determine the Orientation in such cases
    if(orientation==Configuration.ORIENTATION_UNDEFINED){

      Configuration config = getResources().getConfiguration();
      orientation = config.orientation;

      if(orientation==Configuration.ORIENTATION_UNDEFINED){
        //if height and width of screen are equal then
        // it is square orientation
        if(getOrient.getWidth()==getOrient.getHeight()){
          orientation = Configuration.ORIENTATION_SQUARE;
        }
        else{ //if width is less than height than it is portrait
          if(getOrient.getWidth() < getOrient.getHeight()){
            orientation = Configuration.ORIENTATION_PORTRAIT;
          }else{ // if it is not any of the above it will definitely be landscape
            orientation = Configuration.ORIENTATION_LANDSCAPE;
          }
        }
      }
    }
    return orientation; // return value 1 is portrait and 2 is Landscape Mode
  }

  @Override
  protected void onResume() {
    super.onResume();
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
  } 
}
