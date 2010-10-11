package net.anei.cadpage;

import android.content.Context;
import java.io.*;

/**
 * This class handles all uncaught exceptions and writes a stack trace to a
 * stack.trace file before rethrowing the exception
 */
public class TopExceptionHandler implements Thread.UncaughtExceptionHandler {
  
  private static final String STACKTRACE_FILE = "stack.trace";

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
    FileOutputStream trace = null; 
    try {
      trace = context.openFileOutput(STACKTRACE_FILE, Context.MODE_PRIVATE);
      trace.write(report.getBytes());
      trace.close();
    } catch(IOException ioe) {}
    finally {
      if (trace != null) try { trace.close(); } catch (IOException ex) {}
    }

    // Finally throw the exception again
    defaultUEH.uncaughtException(t, e);
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
        body.append(chr);
      }
    } catch (IOException ex) {}
    finally {
      if (trace != null) try { trace.close(); } catch (IOException ex) {}
    }
  }
}