package net.anei.cadpage;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

public class CadPageWidget extends AppWidgetProvider {
  @Override
  public void onUpdate(Context context,AppWidgetManager appWidgetManager, int[] appWidgetIds){
    updateEnabled(context,appWidgetManager,appWidgetIds);
  }
  
  public void updateEnabled(Context context,AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    boolean bEnabled = ManagePreferences.notifyEnabled();
    
    if (bEnabled){
        final int N =appWidgetIds.length;
          for (int i=0;i <N ; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget);
            views.setTextViewText(R.id.TextView02, "ON");
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

