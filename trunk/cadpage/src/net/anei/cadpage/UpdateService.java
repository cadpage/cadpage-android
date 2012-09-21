package net.anei.cadpage;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import java.util.Random;

public class UpdateService extends Service {

    public static final String CADPAGE_REFRESH = "update";
    
    @Override
    public void onStart(Intent intent, int startId){
      
      String fakeUpdate = null;
      Random random = new Random();
      AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this
          .getApplicationContext());

      int[] appWidgetIds = intent
          .getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
      if (appWidgetIds.length > 0) {
        for (int widgetId : appWidgetIds) {
          int nextInt = random.nextInt(100);
          fakeUpdate = "Random: " + String.valueOf(nextInt);
          RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.widget);
          //remoteViews.setTextViewText(R.id.TextView01, fakeUpdate);
          appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
        stopSelf();
      }
      super.onStart(intent, startId);

    }
    @Override
    public IBinder onBind(Intent arg0) {
            return null;
    }
    
    public static PendingIntent makeControlPendingIntent(Context context, String command, int appWidgetId) {
      Intent active = new Intent(context,UpdateService.class);
      active.setAction(command);
      active.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
      //this Uri data is to make the PendingIntent unique, so it wont be updated by FLAG_UPDATE_CURRENT
      //so if there are multiple widget instances they wont override each other
      Uri data = Uri.withAppendedPath(Uri.parse("UpdateService://widget/id/#"+command+appWidgetId), String.valueOf(appWidgetId));
      active.setData(data);
      return(PendingIntent.getService(context, 0, active, PendingIntent.FLAG_UPDATE_CURRENT));
  }


     
}
