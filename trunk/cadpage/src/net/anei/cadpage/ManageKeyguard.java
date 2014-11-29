package net.anei.cadpage;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.app.KeyguardManager.OnKeyguardExitResult;
import android.content.Context;
import android.os.Build;

@SuppressWarnings("deprecation")
public class ManageKeyguard {
  private static KeyguardManager myKM = null;
  private static KeyguardLock myKL = null;

  public static synchronized void initialize(Context context) {
    if (myKM == null) {
      myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
    }
  }

  public static synchronized void disableKeyguard(Context context) {
    
    // There are better ways to do this starting at API level 13
    if (Build.VERSION.SDK_INT >= 13) return;
    
    initialize(context);

    if (myKM.inKeyguardRestrictedInputMode()) {
      myKL = myKM.newKeyguardLock(Log.LOGTAG);
      myKL.disableKeyguard();
      if (Log.DEBUG) Log.v("--Keyguard disabled");
    } else {
      myKL = null;
    }
  }

  public static synchronized boolean inKeyguardRestrictedInputMode() {
    if (myKM != null) {
      if (Log.DEBUG) Log.v("--inKeyguardRestrictedInputMode = " + myKM.inKeyguardRestrictedInputMode());
      return myKM.inKeyguardRestrictedInputMode();
    }
    return false;
  }

  public static synchronized void reenableKeyguard() {
    if (myKM != null) {
      if (myKL != null) {
        myKL.reenableKeyguard();
        myKL = null;
        if (Log.DEBUG) Log.v("--Keyguard reenabled");
      }
    }
  }

  public static synchronized void exitKeyguardSecurely(final LaunchOnKeyguardExit callback) {
    if (inKeyguardRestrictedInputMode()) {
      if (Log.DEBUG) Log.v("--Trying to exit keyguard securely");
      myKM.exitKeyguardSecurely(new OnKeyguardExitResult() {
        public void onKeyguardExitResult(boolean success) {
          reenableKeyguard();
          if (success) {
            if (Log.DEBUG) Log.v("--Keyguard exited securely");
            callback.LaunchOnKeyguardExitSuccess();
          } else {
            if (Log.DEBUG) Log.v("--Keyguard exit failed");
          }
        }
      });
    } else {
      callback.LaunchOnKeyguardExitSuccess();
    }
  }

  public interface LaunchOnKeyguardExit {
    public void LaunchOnKeyguardExitSuccess();
  }
}
