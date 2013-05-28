package net.anei.cadpage;

import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
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
  
  // Expected accuracy degradation in m/msec
  private static final double LOC_ACC_ADJUSTMENT = .002;  // About 2 m/sec

  private static final String ACTION_SHUTDOWN = "ACTION_SHUTDOWN";
  private static final String ACTION_REPORT = "ACTION_REPORT";
  private static final String EXTRA_URL = "EXTRA_URL";
  private static final String EXTRA_END_TIME = "EXTRA_END_TIME";
  private static final String EXTRA_MIN_TIME = "EXTRA_MIN_TIME";
  private static final String EXTRA_MIN_DIST = "EXTRA_MIN_DIST";
  
  private static final int TRACKING_NOTIFICATION = 298;

  // Wake lock and synchronize lock
  static private PowerManager.WakeLock mWakeLock = null;
  
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
  private List<LocationRequest> requestQueue = new LinkedList<LocationRequest>();
  
  // Best location service
  private String bestProvider = null;

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
    
    if (!mWakeLock.isHeld()) mWakeLock.acquire(); 
    String url = intent.getStringExtra(EXTRA_URL);
    long endTime = intent.getLongExtra(EXTRA_END_TIME, 0L);
    int minDist = intent.getIntExtra(EXTRA_MIN_DIST, 10);
    int minTime = intent.getIntExtra(EXTRA_MIN_TIME, 10);

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
    
    // If we don't have an active best provider, set one up and
    LocationManager locMgr = (LocationManager)this.getSystemService(LOCATION_SERVICE);
    if (bestProvider == null) {
      Criteria criteria = new Criteria();
      criteria.setAccuracy(Criteria.ACCURACY_FINE);
      bestProvider = locMgr.getBestProvider(criteria, true);
      if (bestProvider != null) locMgr.requestLocationUpdates(bestProvider, minDist, minTime, this);
    }

    // Get a list of all enabled location providers see which one 
    // provides the best last known location
    Location bestLoc = null;
    for (String name : locMgr.getProviders(true)) {
      Location loc = locMgr.getLastKnownLocation(name);
      if (loc == null) continue;
      Log.v("lastKnownLocation:" + loc.toString());
      if (bestLoc != null) {
        float deltaAcc = loc.getAccuracy() - bestLoc.getAccuracy();
        long deltaTime = loc.getTime() - bestLoc.getTime();
        deltaAcc -= deltaTime * LOC_ACC_ADJUSTMENT;
        if (deltaAcc < 0) continue;
      }
      bestLoc = loc;
    }
    
    // Use the that best last known position to prime things
    onLocationChanged(bestLoc, MAX_INITIAL_RPT_AGE);

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
    
    // If no location, skip it
    if (location == null) return;
    
    Log.v("Location:" + location.toString());
    
    // Do not allow location reports closer that .5 sec apart
    // unless accuracy is significantly improved
    long locTime = location.getTime();
    float locAcc = location.getAccuracy();
    long lastTime = ManagePreferences.lastLocTime();
    if (locTime - lastTime <= 500) {
      float lastAcc = ManagePreferences.lastLocAcc();
      if (lastAcc - locAcc < .5) return;
    }
    
    // Save current location time and accuracy for future adjustments
    ManagePreferences.setLastLocTime(locTime);
    ManagePreferences.setLastLocAcc(locAcc);
    
    // REport location to all requesters
    for (LocationRequest req : requestQueue) req.report(this, location);
  }
  
  @Override
  public void onDestroy() {
    Log.v("Shutting down LocationService");
    LocationManager locMgr = (LocationManager)this.getSystemService(LOCATION_SERVICE);
    locMgr.removeUpdates(this);
    bestProvider = null;
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
    
    // If we haven't established a power wake lock, do that now.
    synchronized (TrackingService.class) {
      if (mWakeLock == null) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, Log.LOGTAG+".LocationService");
        mWakeLock.setReferenceCounted(false);
      }
      if(!mWakeLock.isHeld()) mWakeLock.acquire();
    }
    
    Intent intent = new Intent(ACTION_REPORT, null, context, TrackingService.class);
    intent.putExtra(EXTRA_URL, URL);
    intent.putExtra(EXTRA_END_TIME, SystemClock.uptimeMillis() + duration);
    intent.putExtra(EXTRA_MIN_DIST, minDist);
    intent.putExtra(EXTRA_MIN_TIME, minTime);
    context.startService(intent);
  }
}
