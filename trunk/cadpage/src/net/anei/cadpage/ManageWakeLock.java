package net.anei.cadpage;

import android.content.Context;
import android.os.PowerManager;


public class ManageWakeLock {
  private static PowerManager.WakeLock mWakeLock = null;

  @SuppressWarnings("deprecation")
  public static synchronized void acquireFull(Context mContext) {
    
    int timeout = ManagePreferences.timeout();
    if (timeout <= 0) return;
    
    if (mWakeLock != null) {
      if (Log.DEBUG) Log.v("**Wakelock already held");
    }
    
    else {
  
      PowerManager mPm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
  
      int flags;
  
      // Check dim screen preference
      if (ManagePreferences.dimScreen()) {
        flags = PowerManager.SCREEN_DIM_WAKE_LOCK;
      } else {
        flags = PowerManager.SCREEN_BRIGHT_WAKE_LOCK;
      }
  
      // Check if screen should turn on, if so, set flags and unlock keyguard
      if (ManagePreferences.screenOn()) {
        flags |= PowerManager.ACQUIRE_CAUSES_WAKEUP;
        ManageKeyguard.disableKeyguard(mContext);
      }
  
      mWakeLock = mPm.newWakeLock(flags, Log.LOGTAG+".full");
      mWakeLock.setReferenceCounted(false);
      mWakeLock.acquire();
      if (Log.DEBUG) Log.v("**Wakelock acquired");
    }
    
    ClearAllReceiver.setCancel(mContext, timeout, ClearAllReceiver.ClearType.SCREEN);
  }

  public static synchronized void releaseFull() {
    if (mWakeLock != null) {
      if (Log.DEBUG) Log.v("**Wakelock released");
      mWakeLock.release();
      mWakeLock = null;
      ManageKeyguard.reenableKeyguard();
    }
  }
}