package net.anei.cadpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DummyReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    Log.v("Incomming broadcast");
    ContentQuery.dumpIntent(intent);
  }

}
