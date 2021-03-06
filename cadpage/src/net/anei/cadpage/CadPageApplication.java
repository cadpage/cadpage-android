package net.anei.cadpage;

import net.anei.cadpage.billing.BillingManager;
import net.anei.cadpage.donation.UserAcctManager;
import net.anei.cadpage.vendors.VendorManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;

/**
 * Main CadPage application
 * which is where we need to do our one time initialization
 */
public class CadPageApplication extends Application {
  
  private static Context context = null;
  private static Thread mainThread = null;
  private static Handler mainHandler = null;

  /* (non-Javadoc)
   * @see android.app.Application#onCreate()
   */
  @Override
  public void onCreate() {
    super.onCreate();
    context = this;
    mainThread = Thread.currentThread();
    mainHandler = new Handler();
    Log.v("Intialization startup");
    getVersionInfo(this);
    try {

      UserAcctManager.setup(this);
      BillingManager.instance().initialize(this);
      ManagePreferences.setupPreferences(this);
      VendorManager.instance().setup(this);
      UserAcctManager.instance().reset();
      
      // Reload log buffer queue
      SmsMsgLogBuffer.setup(this);
      
      // Reload existing message queue
      SmsMessageQueue.setupInstance(this);
      
      // See if a new version of Cadpage has been installed
      if (ManagePreferences.newVersion(versionCode)) {
        
        // Reset vendor status
        VendorManager.instance().newReleaseReset(this);
        
        // The rules keep changing here
        // Currently we always ask for a registration ID at every new release load
        // regardless of whether or not the user is actually using direct paging.  It
        // is going to mean a big increase for Google serer workload.  But it is what
        // there regular GCM library does.  So that is what we are going to do
        C2DMService.register(this, true);
      }
      
    } catch (Exception ex) {
      TopExceptionHandler.initializationFailure(this, ex);
    }
    
    // Reinitialize any Widget triggers.  This shouldn't be necessary, but it
    // seems to help avoid sporadic problems with unresponsive Widgets.
    CadPageWidget.reinit(this);
  
    TopExceptionHandler.enable(this);
    Log.v("Initialization complete");
    
  }

  private static String version = null;
  private static String nameVersion = null;
  private static int versionCode = -1;
  
  private void getVersionInfo(Context context) {

    if (nameVersion == null) {
      //Try and find app version name and code
      PackageManager pm = context.getPackageManager();
      try {
        //Get version number, not sure if there is a better way to do this
        PackageInfo info = pm.getPackageInfo(SmsPopupConfigActivity.class.getPackage().getName(), 0);
        version = info.versionName;
        nameVersion = " v" + info.versionName;
        versionCode = info.versionCode;
      } catch (NameNotFoundException e) {
        version = "";
        nameVersion = "";
        versionCode = 0;
      }
      nameVersion = context.getString(R.string.app_name) + nameVersion;
    }
  }
  
  public static String getVersion() {
    return version;
  }
  
  public static String getNameVersion() {
    return nameVersion;
  }
  
  public static int getVersionCode() {
    return versionCode;
  }
  
  public static boolean isBetaRelease() {
    return versionCode % 10 > 0;
  }
  
  public static void runOnMainThread(Runnable runnable) {
    if (mainThread == Thread.currentThread()) {
      runnable.run();
    } else {
      mainHandler.post(runnable);
    }
  }

  
  public static Context getContext() {
    return context;
  }
}
