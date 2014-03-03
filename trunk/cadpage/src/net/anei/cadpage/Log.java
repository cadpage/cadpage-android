package net.anei.cadpage;

public class Log {
  public final static String LOGTAG = "CadPage";

  public static final boolean DEBUG = true;
  
  public static void trace(String msg) {
    android.util.Log.v(LOGTAG, msg, new Exception());
  }

  public static void v(String msg) {
    android.util.Log.v(LOGTAG, msg);
  }
  
  public static void i(String msg) {
    android.util.Log.i(LOGTAG, msg);
  }
  
  public static void w(String msg) {
    android.util.Log.w(LOGTAG, msg);
  }

  public static void e(String msg) {
    android.util.Log.e(LOGTAG, msg);
  }

  public static void e(Throwable ex) {
    android.util.Log.e(LOGTAG, ex.getMessage(), ex);
  }
}
