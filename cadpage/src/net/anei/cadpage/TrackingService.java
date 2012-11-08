package net.anei.cadpage;

import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;

public class TrackingService extends Service implements LocationListener {
  
  // Age limits for location reports.  Report older than these limits are discarded
  // A longer initial limit is allowed on the assumption that people have not been 
  // moving all that much until the call came in.
  private static final long MAX_INITIAL_RPT_AGE = 300000;  // 5 minutes
  private static final long MAX_REPEAT_RPT_AGE = 30000;    // 30 seconds

  private static final String ACTION_SHUTDOWN = "ACTION_SHUTDOWN";
  private static final String ACTION_REPORT = "ACTION_REPORT";
  private static final String EXTRA_URL = "EXTRA_URL";
  private static final String EXTRA_END_TIME = "EXTRA_END_TIME";
  private static final String EXTRA_MIN_TIME = "EXTRA_MIN_TIME";
  private static final String EXTRA_MIN_DIST = "EXTRA_MIN_DIST";
  
  private static final int TRACKING_NOTIFICATION = 298;
  
  /**
   * Internal class defining a location report request
   */
  private class LocationRequest {
    String URL;
    long endTime;
    
    // Runnable that we will post to run at the time we want this request to go away
    Runnable terminator = new Runnable(){
      @Override
      public void run() {
        requestQueue.remove(LocationRequest.this);
        if (requestQueue.size() == 0) stopSelf();
      }
    };
    
    LocationRequest(String URL, long endTime) {
      this.URL = URL;
      this.endTime = endTime;
      mHandler.postAtTime(terminator, endTime);
    }
    
    boolean mergeRequest(String URL, long endTime) {
      if (!URL.equals(this.URL)) return false;
      if (endTime > this.endTime) {
        this.endTime = endTime;
        mHandler.removeCallbacks(terminator);
        mHandler.postAtTime(terminator, endTime);
      }
      return true;
    }
    
    void report(Context context, Location loc) {
      Uri.Builder bld = Uri.parse(URL).buildUpon().appendQueryParameter("type", "LOCATION");
      bld.appendQueryParameter("lat", Location.convert(loc.getLatitude(), Location.FORMAT_DEGREES));
      bld.appendQueryParameter("long", Location.convert(loc.getLongitude(), Location.FORMAT_DEGREES));
      if (loc.hasAccuracy()) bld.appendQueryParameter("acc", Float.toString(loc.getAccuracy()));
      if (loc.hasAltitude()) bld.appendQueryParameter("alt", Double.toString(loc.getAltitude()));
      if (loc.hasBearing()) bld.appendQueryParameter("bearing", Float.toString(loc.getBearing()));
      if (loc.hasSpeed()) bld.appendQueryParameter("speed", Float.toString(loc.getSpeed()));
      bld.appendQueryParameter("time", Long.toString(loc.getTime()));
      
      HttpService.addHttpRequest(context, new HttpService.HttpRequest(bld.build()));
    }
  }
  
  private Handler mHandler = null;
  
  // Queue of outstanding location requests
  private List<LocationRequest> requestQueue = null;

  // Wake lock and synchronize lock
  private PowerManager.WakeLock mWakeLock = null;

  @SuppressLint("NewApi")
  @Override
  public void onCreate() {
    Log.v("LocationService starting up");
    
    // Set up a handler to manage location tracking termination
    mHandler = new Handler();
    
    // Put ourselves in foreground mode, also notifying user that tracking has been activated
    Intent intent = new Intent(ACTION_SHUTDOWN, null, this, TrackingService.class);
    PendingIntent pint = PendingIntent.getService(this, 0, intent, 0);
    Notification nf = new Notification();
    nf.icon = R.drawable.ic_stat_notify;
    nf.when = System.currentTimeMillis();
    String title = getString(R.string.tracking_title);
    String text = getString(R.string.tracking_text);
    nf.setLatestEventInfo(this, title, text, pint);
    startForeground(TRACKING_NOTIFICATION, nf);
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    
    if (ACTION_SHUTDOWN.equals(intent.getAction())) {
      stopSelf();
      return 0;
    }
    String url = intent.getStringExtra(EXTRA_URL);
    long endTime = intent.getLongExtra(EXTRA_END_TIME, 0L);
    int minDist = intent.getIntExtra(EXTRA_MIN_DIST, 10);
    int minTime = intent.getIntExtra(EXTRA_MIN_TIME, 10);
    
    // If we haven't established a power wake lock, do that now.
    if (mWakeLock == null) {
      PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
      mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, Log.LOGTAG+".LocationService");
      mWakeLock.setReferenceCounted(false);
    }
    if(!mWakeLock.isHeld()) mWakeLock.acquire();
    
    // If we do not have a request queue, flag this as our first call and create one
    boolean firstTime = (requestQueue == null);
    if (firstTime) requestQueue = new LinkedList<LocationRequest>();

    // See if we can merge this request into an existing one. 
    boolean found = false;
    for (LocationRequest tReq : requestQueue) {
      if (tReq.mergeRequest(url, endTime)) {
        found = true;
        break;
      }
    }
    
    // If not, create a new entry and add it to the queue
    if (!found) requestQueue.add(new LocationRequest(url, endTime));
    
    // If this is the first request, register ourselves for location updates
    LocationManager locMgr = (LocationManager)this.getSystemService(LOCATION_SERVICE);
    if (firstTime) {
      locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, minDist, minTime, this);
    }          
    
    // Use the cached last known position to prime things
    onLocationChanged(locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER), MAX_INITIAL_RPT_AGE);

    return Service.START_REDELIVER_INTENT;
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onLocationChanged(Location location) {
    onLocationChanged(location, MAX_REPEAT_RPT_AGE);
  }
  
  private void onLocationChanged(Location location, long maxAge) {
    
    if (location == null) return;
    for (LocationRequest req : requestQueue) req.report(this, location);
  }
  
  @Override
  public void onDestroy() {
    Log.v("Shutting down LocationService");
    LocationManager locMgr = (LocationManager)this.getSystemService(LOCATION_SERVICE);
    locMgr.removeUpdates(this);
    if (mWakeLock != null) mWakeLock.release();
  }

  @Override
  public void onProviderDisabled(String provider) {
    Log.v("LocationService - provider disabled:" + provider);
  }

  @Override
  public void onProviderEnabled(String provider) {
    Log.v("LocationService - provider enabled:" + provider);
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {
    Log.v("LocationService - status change:" + provider + ":" + status);
  }

  /**
   * Initiate location report request
   * @param context current context
   * @param URL URL where location reports will be sent
   * @param duration requested reporting period in msecs
   * @param minDist minimum delta reporting distance in meters
   * @param minTime minimum delta reporting time in seconds
   */
  public static void addLocationRequest(Context context, String URL, int duration, int minDist, int minTime) {
    
    Intent intent = new Intent(ACTION_REPORT, null, context, TrackingService.class);
    intent.putExtra(EXTRA_URL, URL);
    intent.putExtra(EXTRA_END_TIME, SystemClock.uptimeMillis() + duration);
    intent.putExtra(EXTRA_MIN_DIST, minDist);
    intent.putExtra(EXTRA_MIN_TIME, minTime);
    context.startService(intent);
  }
}
