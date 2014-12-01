package net.anei.cadpage;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Dummy service launch for no other reason than to keep the JVM alive 
 * while some important status information is kept in volatile memory.  A
 * registered callback function is called if the system shuts down while this
 * process is active, which will only happen if there is really serious 
 * memory pressure.  Callback should be unregistered when the need to keep
 * the app running is finished. 
 */
public class KeepAliveService extends Service {
  
  private static final int NOTIFICATION_ALERT = 2999;
  
  /**
   * Register new shutdown listener
   * @param context current context
   * @param id identifying object
   * @param icon - resource number notification icon
   * @param title - resource number of notification title
   * @param text - resource number of notification text
   */
  public static void register(Context context, Object id, int icon, int title, int text) {
    synchronized (listenerEntryQueue) {
      ListenerEntry entry = new ListenerEntry();
      entry.context = context;
      entry.id = id;
      listenerEntryQueue.add(entry);
      
      Intent intent = new Intent(context, KeepAliveService.class);
      intent.putExtra("STOP", false);
      intent.putExtra("ICON", icon);
      intent.putExtra("TITLE", title);
      intent.putExtra("TEXT", text);
      context.startService(intent);
    }
  }
  
  /**
   * unregister shutdown listener
   * @param context current context
   * @param listener shutdown listener
   */
  public static void unregister(Context context, Object id) {
    synchronized (listenerEntryQueue) {
      ListenerEntry entry = null;
      for (ListenerEntry tmp : listenerEntryQueue) {
        if (tmp.context == context && tmp.id == id) {
          entry = tmp;
          break;
        }
      }
      if (entry == null) throw new RuntimeException("KeepAlive listener not registered");
      listenerEntryQueue.remove(entry);
      
      Intent intent = new Intent(context, KeepAliveService.class);
      context.stopService(intent);
    }
  }
  
  private static class ListenerEntry {
    Context context;
    Object id;
  }
  
  private static List<ListenerEntry> listenerEntryQueue = new ArrayList<ListenerEntry>();

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @SuppressLint("NewApi")
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    if (intent != null) {
      
      // If a service shutdown was requested, do it
      if (intent.getBooleanExtra("STOP", false)) {
        stopSelf();
      } 
      
      // Otherwise build a notfication and put ourselves in foreground mode with
      // it.  That should be sufficient to keep Cadpage alive until we are finished
      // doing whatever we are doing
      else {
        PendingIntent pint = PendingIntent.getActivity(this, 0, CallHistoryActivity.getLaunchIntent(this), 0);
        Notification nf = new Notification();
        nf.icon = intent.getIntExtra("ICON", 0);
        nf.when = System.currentTimeMillis();
        String title = getString(intent.getIntExtra("TITLE", 0));
        String text = getString(intent.getIntExtra("TEXT", 0));
        nf.setLatestEventInfo(this, title, text, pint);
        startForeground(NOTIFICATION_ALERT, nf);
      }
    }
    return Service.START_NOT_STICKY;
  }
}
