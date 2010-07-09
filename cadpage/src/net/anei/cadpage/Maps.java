package net.anei.cadpage;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import net.anei.cadpage.R;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.widget.TextView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;






public  class Maps extends MapActivity {
	private GeoPoint p;
	MapOverlay positionOverlay;
	/**
	 * @param args
	 */
	

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Log.DEBUG) Log.v("Starting Map Launch");
	    MapView mapView;
	    MapController mc;
	    Bundle bun = getIntent().getExtras();
	    String callData[] = bun.getStringArray("CallData");
	    
	   
	   
	    		 setContentView(R.layout.mapview);
	    		// Put exception catch here
		        mapView = (MapView) findViewById(R.id.mapView);
		        TextView mapText = (TextView) findViewById(R.id.MapText);
		        mapText.setText(callData[1]);
		        mapView.setBuiltInZoomControls(true);
		        mapView.setSatellite(true);
		        mapView.setStreetView(true);
		        
		        if (Log.DEBUG) Log.v("Reverse Geocoding Address");
		        
		        p =MapAddress(callData);
		        positionOverlay = new MapOverlay();
		        List<Overlay> overlays = mapView.getOverlays();
		        overlays.add(positionOverlay);
		        mc = mapView.getController();
		       
		        mc.setCenter(p);
		        mc.setZoom(18); 
		        mapView.invalidate();
		       
		        if (Log.DEBUG) Log.v("Mapping Completed;");
	}
	 
public class MapOverlay extends Overlay {
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow){
		Projection projection = mapView.getProjection();
		
		
		if (shadow ==false) {
			//draw on main map)
			Point myPoint = new Point();
			projection.toPixels(p, myPoint);
			//create brush
			Paint paint = new Paint();
			paint.setARGB(250,255,0,0);
			paint.setAntiAlias(true);
			paint.setFakeBoldText(true);
			int rad =5;
			RectF oval = new RectF(myPoint.x-rad,myPoint.y-rad,myPoint.x+rad,myPoint.y+rad);
			canvas.drawOval(oval, paint);
			canvas.drawText("Alert", myPoint.x+rad, myPoint.y, paint);
		}
		else {
			//draw on shadow
			
		}
	}
	


@Override
public boolean onTap(GeoPoint point, MapView mapView){
	return false;
	
	}
}
	private GeoPoint MapAddress(String callData[]) {
		
		 GeoPoint p;
		 String strAddress = callData[1];
		 String strCity = callData[2];
		 String Address = strAddress + ", " + strCity;
		 Geocoder geoCoder = new Geocoder(this, Locale.getDefault());    
	     try {
	         List<Address> addresses = geoCoder.getFromLocationName(Address , 1);
	         if (addresses.size() > 0) {
	             p = new GeoPoint(
	                     (int) (addresses.get(0).getLatitude() * 1E6), 
	                     (int) (addresses.get(0).getLongitude() * 1E6));
	             return p;
	         }    
	     } catch (IOException e) {
	         Log.v("Error in GeoCode function E:"  + e.getMessage());
	         //MapAddress();
	     }
		return null;
	     
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


	}

