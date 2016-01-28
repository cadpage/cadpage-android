package net.anei.cadpage;

import java.util.ArrayList;
import java.util.List;

import net.anei.cadpage.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PermissionManager {

  // "Dangerous" permissions that must be granted at run time
  public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
  public static final String READ_SMS = "android.permission.READ_SMS";
  public static final String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
  public static final String BILLING = "android.vending.BILLING";
  public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
  public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
  public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
  public static final String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
  public static final String RECEIVE_MMS = "android.permission.RECEIVE_MMS";
  public static final String CALL_PHONE = "android.permission.CALL_PHONE";
  public static final String SEND_SMS = "android.permission.SEND_SMS";
  
  // Permissions considered Dangerous, but Cadpage seems to function just fine
  // even when they have not been granted?
  public static final String READ_LOGS = "android.permission.READ_LOGS";
  
  // "Safe" permissions are autoamtically granted
  private static final String WRITE_SMS = "android.permission.WRITE_SMS";
  private static final String WAKE_LOCK = "android.permission.WAKE_LOCK";
  private static final String DISABLE_KEYGUARD = "android.permission.DISABLE_KEYGUARD";
  private static final String VIBRATE = "android.permission.VIBRATE";
  private static final String INTERNET = "android.permission.INTERNET";
  private static final String ACCESS_NETWORK_STATE = "android.permission.ACCESS_NETWORK_STATE";
  private static final String RECEIVE_C2DM = "com.google.android.c2dm.permission.RECEIVE";

  private static final String ID_KEY = "PERM_ID";
  private static final String MSG_KEY = "PERM_MSG";
  
  
  private Context context;
  private Activity activity;
  
  public PermissionManager(Context context) {
    this.context = context;
    this.activity = null;
  }
  
  public PermissionManager(Activity activity) {
    this.context = this.activity = activity;
  }
  
  /**
   * Determine if specific permission has been granted
   * @param permission requested permission
   * @return true if permission has been granted
   */
  public boolean isGranted(String permission) {
    return isGranted(context, permission);
  }
  
  /**
   * Check if specific permission has been granted
   * and prompt user to grant permission if it is not
   * @param requestId request ID
   * @param permission requested permission
   * @return true if all permissions area already granted
   */
  public boolean request(int requestId, String permission) {
    return request(requestId, new String[]{permission}, null);
  }
  
  /**
   * Check if specific permission has been granted
   * and prompt user to grant permission if it is not
   * @param requestId request ID
   * @param permission requested permission
   * @param explainId single resource defining text to be used to explain
   * why all permissions are needed
   * @return true if all permissions area already granted
   */
  public boolean request(int requestId, String permission, int explainId) {
    return request(requestId, new String[]{permission}, new int[]{explainId});
  }
  
  /**
   * Check if specific permission has been granted
   * and prompt user to grant permission if it is not
   * @param requestId request ID
   * @param permissions list of requested permissions
   * @return true if all permissions area already granted
   */
  public boolean request(int requestId, String[] permissions) {
    return request(requestId, permissions, null);
  }
  
  /**
   * Check if specific permission has been granted
   * and prompt user to grant permission if it is not
   * @param requestId request ID
   * @param permissions list of requested permissions
   * @param explainId single resource defining text to be used to explain
   * why all permissions are needed
   * @return true if all permissions area already granted
   */
  public boolean request(int requestId, String[] permissions, int explainId) {
    return request(requestId, permissions, new int[]{explainId});
  }
  
  /**
   * Check if specific permission has been granted
   * and prompt user to grant permission if it is not
   * @param requestId request ID
   * @param permissions list of requested permissions
   * @param explainIds list of resource ID's explaining why permision
   * is needed.  Can be null if no explanation should be generated.  Can be
   * a single element if one explanation covers all permissions.  Or can
   * contains a explanation resource for each permission
   * @return true if all permissions area already granted
   */
  public boolean request(int requestId, String[] permissions, int[] explainIds) {
    
    // Not allowed for context based managers
    if (activity == null) throw new RuntimeException("Request permission not allowed with context based managers");
    
    List<String> missingPerms = new ArrayList<String>();
    StringBuilder sb = null;
    
    // Loop through the requested permissions
    for (int ndx = 0; ndx < permissions.length; ndx++) {
      
      // If permission has already been granted, nothing more needs to be done
      String permission = permissions[ndx];
      if (!isGranted(activity, permission)) {
        
        // Otherwise add to the list of missing permissions
        missingPerms.add(permission);
        
        // If appropriate, construct a quick explanation of just why we need this permission
        if (explainIds != null && Permissions.shouldShowRequestPermissionRationale(activity, permission)) {
          if (sb == null) {
            sb = new StringBuilder(activity.getString(R.string.need_permission_title));
            sb.append('\n');
            int tmp = explainIds.length > 1 ? ndx : 0;
            sb.append(activity.getString(tmp));
          } else if (explainIds.length > 1) {
            sb.append('\n');
            sb.append(activity.getString(explainIds[ndx]));
          }
        }
      }
    }
    
    // If there are no missing permissions, everything is hunky dory
    if (missingPerms.isEmpty()) return true;
    
    // Ask user for any missing permissions 
    Permissions.requestPermissions(activity, missingPerms.toArray(new String[missingPerms.size()]), requestId);
    
    // If we constructed a text explanation of why we need the permission values
    // fire off a showDialog request to display it
    if (sb != null) {
      Bundle b = new Bundle();
      b.putInt(ID_KEY, requestId);
      b.putString(MSG_KEY, sb.toString());
      activity.showDialog(requestId, b);
    }
    
    // Always return false.  Activity will have to monitor callback 
    // to determine when and if permissions have been granted
    return false;
  }
  
  /**
   * Create dialog message explaining why permissions are needed.  This
   * should be called from the Activity.onCreateDialog() method
   * @param requestId request ID
   * @param bundle Bundled information
   * @return Dialog if appropriate, null otherwise
   */
  public Dialog onCreateDialog(int requestId, Bundle bundle) {
    if (bundle == null) return null;
    int tmp = bundle.getInt(ID_KEY, -1);
    if (tmp != requestId) return null;
    String message = bundle.getString(MSG_KEY);
    if (message == null) return null;

    Dialog dlg = new AlertDialog.Builder(activity)
        .setIcon(R.drawable.ic_launcher)
        .setTitle(R.string.need_permission_title)
        .setMessage(message)
        .setPositiveButton(android.R.string.ok, null)
        .create();
    return dlg;
  }
  
  /**
   * @param granted Array of permission status passed to onPermissionsResult
   * @return true if status array exists and all permissions have been granted
   */
  public static boolean isGranted(int[] granted) {
    if (granted == null) return false;
    for (int g : granted) {
      if (g != PackageManager.PERMISSION_GRANTED) return false;
    }
    return true;
  }
  
  /**
   * Determine if specific permission has been granted
   * @param context current context
   * @param permission requested permission
   * @return true if permission has been granted
   */
  public static boolean isGranted(Context context, String permission) {
    return Permissions.isGranted(context, permission);
  }
    

  /**
   * Add permission information to status message
   * @param context current context
   * @param sb StringBuilder used to construct status message
   */
  public static void addPermissionInfo(Context context, StringBuilder sb) {
    
    // Display any permissions that have not yet be granted
    boolean first = true;
    for (String permission : PERMISSIONS) {
      if (!isGranted(context, permission)) {
        if (first) {
          sb.append('\n');
          first = false;
        }
        sb.append("perm:" + permission + " denied\n");
      }
    }
  }
  
  // Array of permissions Cadpage requires for various things
  private static final String[] PERMISSIONS = new String[]{
    READ_SMS,
    SEND_SMS,
    RECEIVE_SMS,
    RECEIVE_MMS,
    WRITE_SMS,
    WAKE_LOCK,
    DISABLE_KEYGUARD,
    VIBRATE,
    READ_PHONE_STATE,
    GET_ACCOUNTS,
    BILLING,
    RECEIVE_C2DM,
    INTERNET,
    ACCESS_NETWORK_STATE,
    CALL_PHONE,
    READ_LOGS,
    ACCESS_FINE_LOCATION,
    READ_EXTERNAL_STORAGE,
    WRITE_EXTERNAL_STORAGE
  };

}
