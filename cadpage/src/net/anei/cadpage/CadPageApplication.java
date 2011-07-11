package net.anei.cadpage;

import net.anei.cadpage.donation.UserAcctManager;
import android.app.Application;

/**
 * Main CadPage application
 * which is where we need to do our one time initialization
 */
public class CadPageApplication extends Application {

  /* (non-Javadoc)
   * @see android.app.Application#onCreate()
   */
  @Override
  public void onCreate() {
    super.onCreate();
    try {
      ManagePreferences.setupPreferences(this);
      ManageParsers.getInstance().setupNames(this);
     
      UserAcctManager.setup(this);
      
      // Reload log buffer queue
      SmsMsgLogBuffer.setup(this);
      
      // Reload existing message queue
      SmsMessageQueue.setupInstance(this);
    } catch (Exception ex) {
      TopExceptionHandler.initializationFailure(this, ex);
    }
  
    TopExceptionHandler.enable(this);
    Log.v("Initialization complete");
  }
}
