package net.anei.cadpage;

import android.app.Activity;
import android.content.Context;
import java.io.*;

/**
 * This class handles all uncaught exceptions and writes a stack trace to a
 * stack.trace file before rethrowing the exception
 */
public class TopExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static Thread.UncaughtExceptionHandler defaultUEH;

    private Activity app = null;
    
    public static void enable(Activity app) {
        defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new TopExceptionHandler(app));
    }

    private TopExceptionHandler(Activity app) {
        this.app = app;
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
                app.openFileOutput("stack.trace", Context.MODE_PRIVATE);
            trace.write(report.getBytes());
            trace.close();
        } catch(IOException ioe) {}

        // Finally throw the exception again
        defaultUEH.uncaughtException(t, e);
    }
}