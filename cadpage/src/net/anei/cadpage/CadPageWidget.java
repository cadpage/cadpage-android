package net.anei.cadpage;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RemoteViews;
import net.anei.cadpage.HistoryMsgTextView;

public class CadPageWidget extends AppWidgetProvider {
  

  public static final String UPDATE_ACTION = "update";
  public static String ACTION_CADPAGE_ENABLED = "CadPageEnabled";
  public static String ACTION_NOTIFICATION = "CadPageNotification";
  public static String ACTION_POPUP = "CadPageAlerts";
  public static String ACTION_CALLS = "CadPageCalls";

  @Override
  public void onUpdate(Context context,AppWidgetManager appWidgetManager, int[] appWidgetIds){
    
    final int N = appWidgetIds.length;
    for (int i=0; i<N; i++) {
      int appWidgetId = appWidgetIds[i];
      updateEnabled(context,appWidgetManager,appWidgetIds);
      
      
      //First Button (Enable/Disable Cadpage)
      Intent aEnabledIntent = new Intent(context, CadPageWidget.class);
      aEnabledIntent.setAction(ACTION_CADPAGE_ENABLED);
      PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, 0, aEnabledIntent, 0);
  
      
      //Second Button (Enable/Disable Alerts)
      Intent bEnabledIntent = new Intent(context, CadPageWidget.class);
      bEnabledIntent.setAction(ACTION_NOTIFICATION);
      PendingIntent notificationPendingIntent = PendingIntent.getBroadcast(context, 0, bEnabledIntent, 0);
      
      //Third Button (Enable/Disable PopUps)
      Intent cEnabledIntent = new Intent(context, CadPageWidget.class);
      cEnabledIntent.setAction(ACTION_POPUP);
      PendingIntent popupPendingIntent = PendingIntent.getBroadcast(context, 0, cEnabledIntent, 0);
      
    //Fourth Button (Show Unread Calls. Click to go into History)
      Intent dEnabledIntent = new Intent(context, CallHistoryActivity.class);
     // dEnabledIntent.setAction(ACTION_CALLS);
      PendingIntent callsPendingIntent = PendingIntent.getActivity(context, 0, dEnabledIntent, 0);
  
      
      RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
      views.setOnClickPendingIntent(R.id.widget_button_cadpage, actionPendingIntent);
      views.setOnClickPendingIntent(R.id.widget_button_notification, notificationPendingIntent);
      views.setOnClickPendingIntent(R.id.widget_button_popup, popupPendingIntent);
      views.setOnClickPendingIntent(R.id.widget_text_newcalls, callsPendingIntent);
  
      CharSequence MessageCnt = HistoryMsgTextView.NewMessageCount();
      views.setTextViewText(R.id.widget_text_newcalls, MessageCnt);
      appWidgetManager.updateAppWidget(appWidgetId, views);
      //updateEnabled(context);
      //context.startService(intent);
      appWidgetManager.updateAppWidget(appWidgetIds, views);
    }
   
  }
  
    
  private void updateEnabled(Context context,AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    boolean aEnabled = ManagePreferences.enabled();
    boolean bEnabled = ManagePreferences.notifyEnabled();
    boolean cEnabled = ManagePreferences.popupEnabled();
    RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget);
    for (int appWidgetId : appWidgetIds) {
      if (aEnabled){
        views.setImageViewResource(R.id.widget_button_cadpage, R.drawable.cadpage_widget_logo);
      } else {
        views.setImageViewResource(R.id.widget_button_cadpage, R.drawable.cadpage_widget_logo_disable);  
      }
      if (bEnabled){
        views.setImageViewResource(R.id.widget_button_notification, R.drawable.cadpage_widget_bell);
      } else {
        views.setImageViewResource(R.id.widget_button_notification, R.drawable.cadpage_widget_bell_disable);
      }
      if (cEnabled){
        views.setImageViewResource(R.id.widget_button_popup, R.drawable.cadpage_widget_talk);
      } else {
        views.setImageViewResource(R.id.widget_button_popup, R.drawable.cadpage_widget_talk_disable);
      }
      
      if (aEnabled){
        views.setViewVisibility(R.id.widget_button_notification,View.VISIBLE);
        views.setViewVisibility(R.id.widget_button_popup,View.VISIBLE );
        views.setViewVisibility(R.id.widget_text_newcalls, View.VISIBLE);
      } else {
        views.setViewVisibility(R.id.widget_button_notification,View.INVISIBLE);
        views.setViewVisibility(R.id.widget_button_popup,View.INVISIBLE );
        views.setViewVisibility(R.id.widget_text_newcalls, View.INVISIBLE);
      }
      CharSequence MessageCnt = HistoryMsgTextView.NewMessageCount();
      views.setTextViewText(R.id.widget_text_newcalls, MessageCnt);
      appWidgetManager.updateAppWidget(appWidgetId, views);
    }
  }
  
  private void updateEnabled(Context context) {
      ComponentName thisWidget = new ComponentName(context,CadPageWidget.class);
      AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
      int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
      updateEnabled(context,appWidgetManager,appWidgetIds);
  }
  
  
  @Override 
  public void onReceive(Context context, Intent intent){
    super.onReceive(context, intent);
      if( intent.getAction().equals(ACTION_CADPAGE_ENABLED)){
        boolean aEnabled = ManagePreferences.enabled();
        ManagePreferences.setEnabled(!aEnabled);
      }
      else if (intent.getAction().equals(ACTION_NOTIFICATION)){
        boolean bEnabled = ManagePreferences.notifyEnabled();
        ManagePreferences.setNotifyEnabled(!bEnabled);
      }
      else if (intent.getAction().equals(ACTION_POPUP)){
        boolean cEnabled = ManagePreferences.popupEnabled();
        ManagePreferences.setPopupEnabled(!cEnabled);
      }
      updateEnabled(context);
  }
  
  public void onDisabled(Context context) {
    context.stopService(new Intent(context,CadPageWidget.class));
    super.onDisabled(context);
}
  
 

}

