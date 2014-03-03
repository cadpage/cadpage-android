package net.anei.cadpage;

import android.content.Context;
import android.os.Handler;

import java.io.*;

/**
 * This class handles all uncaught exceptions and writes a stack trace to a
 * stack.trace file before rethrowing the exception
 */
public class TopExceptionHandler implements Thread.UncaughtExceptionHandler {
  
  private static final String STACKTRACE_FILE = "stack.trace";
  
  // Limit in seconds on exception thrashing.  We will not try to handle a
  // exception thrown within this time limit of the previous exception.
  private static int THRASHING_LIMIT = 60; 
  
  private static Thread.UncaughtExceptionHandler defaultUEH;
  
  // Handler used to transfer exceptions occuring in other threads to the main therad
  // where all of this exception handling logic will kick in
  private static Handler mainHandler;

  private Context context = null;

  public static void enable(Context context) {
    mainHandler = new Handler();
    defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(new TopExceptionHandler(context));
  }

  private TopExceptionHandler(Context context) {
    this.context = context;
  }

  public void uncaughtException(Thread t, Throwable e) {
    
    // Safety check, get the last modified date on the trace file.  It was 
    // too recent, we don't do any process to avoid a initialization failure 
    // loop.  Just pass the exception to the default handler and bail out
    if (checkFailureLoop(context)) {
      Log.e(e);
      defaultUEH.uncaughtException(t, e);
      return;
    }

    reportException(context, e);
    
    // Start an intent that will restart CADPage and bring up a crash report
    // screen, after this exception knocks us out
    EmailDeveloperActivity.sendCrashEmail(context);

    // Kill JVM (throwing an exception knocks out the scheduled intent call
    System.exit(2);
  }
  
 
  /**
   * Check to see if another exception has been recorded within the thrash limit
   * in which case this exception should be passed back to the regular system
   * exception processing
   * @param context current context
   * @return true if it has
   */
  static private boolean checkFailureLoop(Context context) {
    File file = new File(context.getFilesDir().getAbsolutePath() + "/" + STACKTRACE_FILE);
    if (! file.exists()) return false;
    long limit = System.currentTimeMillis() - file.lastModified();
    return (limit <= THRASHING_LIMIT*1000);
  }

  /**
   * Log exception to system log and to stack trace file
   * @param e
   */
  static private void reportException(Context context, Throwable e) {

    // Start by logging this exception
    Log.e(e);
    
    // Format throwable stack trace to string
    StringWriter sw = new StringWriter();
    e.printStackTrace(new PrintWriter(sw));
    String report = sw.toString();

    // And write it to stack.trace
    FileOutputStream trace = null; 
    try {
      trace = context.openFileOutput(STACKTRACE_FILE, Context.MODE_PRIVATE);
      trace.write(report.getBytes());
      trace.close();
    } catch(IOException ioe) {}
    finally {
      if (trace != null) try { trace.close(); } catch (IOException ex) {}
    }
  }

  /**
   * Append most recent stack trace to message body being constructed
   * @param context current context
   * @param body StringBuilder containing message body under construction
   */
  public static void addCrashReport(Context context, StringBuilder body) {
    BufferedInputStream trace = null;
    try {
      trace = new BufferedInputStream(context.openFileInput(STACKTRACE_FILE));
      body.append("\n\n");
      int chr;
      while ((chr = trace.read()) >= 0) {
        body.append((char)chr);
      }
    } catch (IOException ex) {}
    finally {
      if (trace != null) try { trace.close(); } catch (IOException ex) {}
    }
  }
  
  // Flag indicating an exception was thrown during initialization.  This
  // puts us in an awkward position, we want to process the the EmailDeveloper 
  // dialog and shut down, but techniques that perform immediate shutdown
  // abort the send email intent that the email developer dialog generates.
  
  // While this flag is set, Activities that might be launched from outside
  // will shut down immediately.  When the EmailDeveloperActivity dialog
  // completes, it will call forceShutdown() to complete the app termination.
  private static boolean initFailure = false;
  
  /**
   * @return true if initialization failure is being processed.
   */
  public static boolean isInitFailure() {
    return initFailure;
  }
  
  /**
   * Report initialization failure
   * @param context current context
   * @param e exception thrown during initialization
   */
  static public void initializationFailure(Context context, Exception e) {
    if (checkFailureLoop(context)) {
      Log.e(e);
      throw new RuntimeException(e);
    }
    initFailure = true;
    reportException(context, e);
    EmailDeveloperActivity.sendInitEmail(context);
  }
  
  /**
   * Force app shutdown as final step during initialization failure processing
   * @param context
   */
  static public void forceShutdown(Context context) {
    Handler handler = new Handler();
    handler.postDelayed(new Runnable(){
      @Override
      public void run() {
        System.exit(2);
      }}, 5000L);
  }
  
  /**
   * Report outside thread exception
   */
  public static void reportException(final Exception ex) {
    mainHandler.post(new Runnable(){
      @Override
      public void run() {
        throw new RuntimeException(ex.getMessage(), ex);
      }});
   
  }
}
