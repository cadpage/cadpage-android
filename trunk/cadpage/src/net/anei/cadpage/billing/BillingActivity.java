package net.anei.cadpage.billing;

import android.content.Intent;
import net.anei.cadpage.Safe40Activity;

public abstract class BillingActivity extends Safe40Activity {

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (BillingManager.instance().handleActivityResult(requestCode, resultCode, data)) return;
    super.onActivityResult(requestCode, resultCode, data);
  }

}
