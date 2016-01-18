package net.anei.cadpage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * This class handles permissions requests that must be handled
 * differently below SDK level 23
 */
public class Permissions {
  
  public interface Worker {
    public boolean isGranted(Context context, String permissioin);
    public boolean shouldShowRequestPermissionRationale(Activity activity, String permission);
    public void requestPermissions(Activity activity, String[] permissions, int requestId);
  }
  
  static final Worker worker;
  static {
    if (Build.VERSION.SDK_INT < 23) {
      worker = new Regular();
    } else {
      try {
        worker = (Worker)Class.forName("net.anei.cadpage.Permissions$Api23").newInstance();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }
  }
  
  @TargetApi(23)
  static class Api23 implements Worker {
    
    public boolean isGranted(Context context, String permission) {
      return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
      return activity.shouldShowRequestPermissionRationale(permission);
    }

    public void requestPermissions(Activity activity, String[] permissions, int requestId) {
      activity.requestPermissions(permissions, requestId);
    }
  }

  private static class Regular implements Worker {
  
    @Override
    public boolean isGranted(Context context, String permissioin) {
      return true;
    }
  
    @Override
    public boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
      return false;
    }
  
    @Override
    public void requestPermissions(Activity activity, String[] permissions, int requestId) {
    }
  }

  
  public static boolean isGranted(Context context, String permission) {
    return worker.isGranted(context,  permission);
  }

  public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
    return worker.shouldShowRequestPermissionRationale(activity, permission);
  }
  
  public static void requestPermissions(Activity activity, String[] permissions, int requestId) {
    worker.requestPermissions(activity, permissions, requestId);
  }

}
