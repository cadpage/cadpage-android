package net.anei.cadpage;

import android.app.IntentService;
import android.content.Intent;

public class SmsMsgAccumulatorService extends IntentService {

  public SmsMsgAccumulatorService() {
    super("SmsMsgAccumlatorService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    
    SmsMsgAccumulator.instance().handleIntent(this, intent);
  }
}
