package net.anei.cadpage;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;

public class HttpService extends Service {
  
  public static class HttpRequest {
    
    private URL url;
    private int connectTimeout;
    private int readTimeout;
    
    public HttpRequest(Uri uri) {
      this(convURItoURL(uri));
    }
    
    public HttpRequest(URL url) {
      this(null, 60000, 30000);
    }
    
    public HttpRequest(URL url, int connectTimeout, int readTimeout) {
      this.url = url;
      this.connectTimeout = connectTimeout;
      this.readTimeout = readTimeout;
    }

    /**
     * Convert Uri object to URL object
     * @param uri URI
     * @return equivalent URL
     */
    private static URL convURItoURL(Uri uri) {
      try {
        return new URL(uri.toString());
      } catch (MalformedURLException ex) {
        throw new RuntimeException(ex.getMessage(), ex);
      }
    }
    /**
     * @return return requested URL code
     */
    public URL getUrl() {
      return url;
    }
    
    public int getConnectionTimeout() {
      return connectTimeout;
    }
    
    public int getReadTimeout() {
      return readTimeout;
    }
    
    /**
     * This will be called when the HTTP request returns a result or failure status
     * @param status request response status
     * @param result request response result
     */
    public void processResponse(int status, String result) {}
  }
  
  private static Handler mHandler;

  // Wake lock and synchronize lock
  private static PowerManager.WakeLock mWakeLock = null;
  
  // Master request queue
  private static Queue<HttpRequest> reqQueue =new LinkedList<HttpRequest>();

  @Override
  public void onCreate() {
    
    // Create a handler which (we hope) will link to the main dispatch thread msg queue
    mHandler = new Handler();
    
    // Launch the HttpServiceThread that is going to do all of the work
    new HttpServiceThread();
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  private final class HttpServiceThread extends Thread {
    
    public HttpServiceThread() {
      super("HttpServiceThread");
      setPriority(Process.THREAD_PRIORITY_FOREGROUND);
      start();
    }

    @Override
    public void run() {
      
      try {
          
        // Get next request from request queue.  If there aren't any remaining
        // entries, it is time to kill this service
        HttpRequest req;
        synchronized(reqQueue) {
          req = reqQueue.poll();
          if (req == null) {
            if (mWakeLock != null) mWakeLock.release();
            stopSelf();
          }
        }
        
        // Build and fire off the Http request
        URL url = req.getUrl();
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(req.getConnectionTimeout());
        conn.setReadTimeout(req.getReadTimeout());
        conn.connect();
        final HttpRequest doReq = req;
        final int respCode = conn.getResponseCode();
        final String respMsg = conn.getResponseMessage();
        conn.disconnect();
        
        // And call the request process response method on the main dispatch thread
        mHandler.post(new Runnable(){
          @Override
          public void run() {
            doReq.processResponse(respCode, respMsg);
          }});
      } 
      
      // Any exceptions that get thrown should be rethrown on the dispatch thread
      catch (final Exception ex) {
        mHandler.post(new Runnable(){
          @Override
          public void run() {
            throw new RuntimeException(ex.getMessage(), ex);
          }});
      }
    }
  }

  /**
   * Initiate an HTTP request
   * @param context current context
   * @param request HTTP request to be initiated
   */
  public static void addHttpRequest(Context context, HttpRequest request) {
    
    // Everything is synchronized by the request queue
    synchronized (reqQueue) {
      
      // If we haven't established a power wake lock, do that now.
      if (mWakeLock == null) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, Log.LOGTAG+".HttpService");
        mWakeLock.setReferenceCounted(false);
      }
      if(!mWakeLock.isHeld()) mWakeLock.acquire();
      
      // Add new request to request queue and launch the HttpService
      // We don't need to pass anything, just make sure it got started
      reqQueue.add(request);
      context.startService(new Intent(context, HttpService.class));
    }
  }
}
