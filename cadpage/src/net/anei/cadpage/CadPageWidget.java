package net.anei.cadpage;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class CadPageWidget extends AppWidgetProvider {
  
  public static final String ACTION_SMSPOPUP_ENABLE = "net.anei.cadpage.ManagePreferences.";
  public static final String ACTION_SMSPOPUP_DISABLE = "net.everythingandroid.smspopup.DISABLE";
  
  @Override
  public void onUpdate(Context context,AppWidgetManager appWidgetManager, int[] appWidgetIds){
    final int N = appWidgetIds.length;
    for (int i=0; i<N; i++) {
      int appWidgetId = appWidgetIds[i];
    updateEnabled(context,appWidgetManager,appWidgetIds);
    Intent intent = new Intent(context, CallHistoryActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
    RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
    views.setOnClickPendingIntent(R.id.widget_button_cadpage, pendingIntent);
    appWidgetManager.updateAppWidget(appWidgetId, views);
    }
  }
  
  public void updateEnabled(Context context,AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    boolean bEnabled = ManagePreferences.notifyEnabled();
    
    if (bEnabled){
        final int N =appWidgetIds.length;
          for (int i=0;i <N ; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget);
            appWidgetManager.updateAppWidget(appWidgetId, views);
          }
    }
    
  }
  public void updateEnabled(Context context) {
      ComponentName thisWidget = new ComponentName(context,CadPageWidget.class);
      AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
      int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
      updateEnabled(context,appWidgetManager,appWidgetIds);
  }
  
  @Override 
  public void onReceive(Context context, Intent intent){
    super.onReceive(context, intent);
      if (intent.getAction().equals(UpdateService.CADPAGE_REFRESH))
          updateEnabled(context);
  }
  
}

