package net.anei.cadpage;

import android.content.Context;
import java.io.*;

/**
 * This class handles all uncaught exceptions and writes a stack trace to a
 * stack.trace file before rethrowing the exception
 */
public class TopExceptionHandler implements Thread.UncaughtExceptionHandler {

  private static Thread.UncaughtExceptionHandler defaultUEH;

  private Context context = null;

  public static void enable(Context context) {
    defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(new TopExceptionHandler(context));
  }

  private TopExceptionHandler(Context context) {
    this.context = context;
  }

  public void uncaughtException(Thread t, Throwable e) {

    // Start by logging this exception
    Log.e(e);

    // Format throwable stack trace to string
    StringWriter sw = new StringWriter();
    e.printStackTrace(new PrintWriter(sw));
    String report = sw.toString();

    // And write it to stack.trace
    try {
      FileOutputStream trace = 
        context.openFileOutput("stack.trace", Context.MODE_PRIVATE);
      trace.write(report.getBytes());
      trace.close();
    } catch(IOException ioe) {}

    // Finally throw the exception again
    defaultUEH.uncaughtException(t, e);
  }
}