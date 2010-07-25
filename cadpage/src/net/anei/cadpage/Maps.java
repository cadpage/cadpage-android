package net.anei.cadpage;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import net.anei.cadpage.R;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;


public  class Maps extends MapActivity {
	protected boolean isRouteDisplayed() {
		return false;
	}
	private GeoPoint p;
	private String Call;
	private Button BShowSat;
	private Button BClose;
	
	MapOverlay positionOverlay;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Log.DEBUG) Log.v("Starting Map Launch");
		 final ProgressDialog pd;
		    pd = ProgressDialog.show(Maps.this, "Working..", "Searching for address", true, false);
		    
	    Bundle bun = getIntent().getExtras();
	    final String callData[] = bun.getStringArray("CallData");
	    Call = callData[0].substring(callData[0].indexOf("Call:",0)+5);
	    // This spawns a new thread to do the map lookup so that it doesn't break the interface.
	    Thread searchAdress = new Thread() {
	      public void run(){
	    	  Boolean res ;
	    	  res = MapAddress(callData);
	    	  if (res = true){
	    	  showAdressResults.sendEmptyMessage(0);
	    	  pd.dismiss();
	    	  } else {
	    		  Dialog locationError = new AlertDialog.Builder(
	    				 Maps.this).setIcon(0).setTitle("Error").setPositiveButton("Ok", null)
	    				.setMessage("Sorry, the address can not be found.")
	    				.create();
	    		  		locationError.show();
	    	  }
	    	  
	      }
	      
	    };
	    
	    searchAdress.start();
	    
	    if (Log.DEBUG) Log.v("Mapping Completed;");
	 
	 }
	 private Handler showAdressResults = new Handler() {
			@Override
			   public void handleMessage(Message msg) {
				   	drawMap();
			   }
		    };
		    

	 
	 public boolean MapAddress(String callData[]) {
		    
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
	             return true;
	         }    
	     } catch (IOException e) {
	         Log.v("Error in GeoCode function E:"  + e.getMessage());
	         //MapAddress();
	         return false;
	     }
		return false;
	     
	     
	}
		 

public void drawMap(){	 
    MapView mapView;
    MapController mc;
    Bundle bun = getIntent().getExtras();
    final String callData[] = bun.getStringArray("CallData");
    
	    		 setContentView(R.layout.mapview);
	    		// Put exception catch here
		        mapView = (MapView) findViewById(R.id.mapView);
		        TextView mapText = (TextView) findViewById(R.id.MapText);
		        BShowSat = (Button)this.findViewById(R.id.BShowSat);
		        BClose = (Button)this.findViewById(R.id.BMapClose);
		        BShowSat.setOnClickListener(ShowSat());
		        BClose.setOnClickListener(MapClose());
		        mapText.setText(callData[1]);
		        mapView.setBuiltInZoomControls(true);
		        mapView.setSatellite(false);
		        mapView.setStreetView(true);
		        
		        if (Log.DEBUG) Log.v("Reverse Geocoding Address");
		        
		        
		        positionOverlay = new MapOverlay();
		        List<Overlay> overlays = mapView.getOverlays();
		        overlays.add(positionOverlay);
		        mc = mapView.getController();
		       
		        mc.setCenter(p);
		        mc.setZoom(19); 
		        mapView.invalidate();
}
		
private OnClickListener ShowSat() {
	// TODO Auto-generated method stub
	MapView mapView = (MapView) findViewById(R.id.mapView);
	if (mapView.isSatellite()){ mapView.setSatellite(false); }
	else { mapView.setSatellite(true);
	}
	return null;
}


private OnClickListener MapClose() {
	// TODO Auto-generated method stub
	this.finish();
	return null;
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
			int rad =9;
			RectF oval = new RectF(myPoint.x-rad,myPoint.y-rad,myPoint.x+rad,myPoint.y+rad);
			canvas.drawOval(oval, paint);
			canvas.drawText(Call, myPoint.x+rad, myPoint.y, paint);
		}
		else {
			//draw on shadow		
		}
	}
}
}