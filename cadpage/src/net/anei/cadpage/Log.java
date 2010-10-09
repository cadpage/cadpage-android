package net.anei.cadpage;

public class Log {
  public final static String LOGTAG = "CadPage";

  public static final boolean DEBUG = false;

  public static void v(String msg) {
    android.util.Log.v(LOGTAG, msg);
  }

  public static void e(String msg) {
    android.util.Log.e(LOGTAG, msg);
  }

  public static void e(Throwable ex) {
    android.util.Log.e(LOGTAG, ex.getMessage(), ex);
  }
}
