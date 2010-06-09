package net.anei.cadpage;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import net.anei.cadpage.R;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;




public  class Maps extends MapActivity {

	/**
	 * @param args
	 */
	

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Log.DEBUG) Log.v("Starting Map Launch");
	    MapView mapView; 
	    MapController mc;
	    GeoPoint p;
	   
	    		setContentView(R.layout.mapview);
		        
		        mapView = (MapView) findViewById(R.id.mapView);  
		        mapView.setBuiltInZoomControls(true);
		        mapView.setSatellite(true);
		        mapView.setStreetView(true);
		        if (Log.DEBUG) Log.v("Reverse Geocoding Address");
		        p =MapAddress();
		        mc = mapView.getController();
		       
		        mc.setCenter(p);
		        mc.setZoom(18); 
		        mapView.invalidate();
		       
		        if (Log.DEBUG) Log.v("Mapping Completed;");
	}

	private GeoPoint MapAddress() {
		
		 GeoPoint p;
		 
		 Geocoder geoCoder = new Geocoder(this, Locale.getDefault());    
	     try {
	         List<Address> addresses = geoCoder.getFromLocationName(
	             "24247 Gum Spring Rd, Sterling, VA ", 1);
	         if (addresses.size() > 0) {
	             p = new GeoPoint(
	                     (int) (addresses.get(0).getLatitude() * 1E6), 
	                     (int) (addresses.get(0).getLongitude() * 1E6));
	             return p;
	         }    
	     } catch (IOException e) {
	         Log.v("Error in GeoCode function E:"  + e.getMessage());
	         MapAddress();
	     }
		return null;
	     
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


	}

