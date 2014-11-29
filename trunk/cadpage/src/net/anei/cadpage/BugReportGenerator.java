package net.anei.cadpage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;

/**
 * This class generates and Android bug report to be collected latter
 */
@TargetApi(Build.VERSION_CODES.FROYO)
public class BugReportGenerator {
  
  private static final String BUG_REPORT_FILENAME = "bugreport.cadpage.gz";
  
  public static void generate() {
    
    Log.v("BugReportGenerator: Generating bug report");
    
    // We don't go through the minimal trouble needed to support API 7 and below
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO) {
      Log.v("BugReportGenerator: Not supported for API: " + Build.VERSION.SDK_INT);
      return;
    }
    
    //  Check that external card is mounted for write access
    String state = Environment.getExternalStorageState();
    if (!Environment.MEDIA_MOUNTED.equals(state)) {
      Log.e("BugReportGenerator: External card is not writeable");
      return;
    }
    new BugReportTask().execute();
  }

  private static class BugReportTask extends AsyncTask<Void, String, Void> {
    
    private Exception ex;

    @Override
    protected Void doInBackground(Void ... args) {
      
      OutputStream osFile = null;
      OutputStream osGzip = null;
      InputStream isGzip = null;
      try {
        
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), BUG_REPORT_FILENAME);
        publishProgress("Bugreport file:" + file.getAbsolutePath());
        osFile = new BufferedOutputStream(new FileOutputStream(file));
        
        // Start async process running the gzip program to compress all output
        Process gzipProc = Runtime.getRuntime().exec("gzip");
        osGzip = new BufferedOutputStream(gzipProc.getOutputStream());
        isGzip = new BufferedInputStream(gzipProc.getInputStream());
        Thread pipeThread = new PipeThread("gzip", isGzip, osFile);
        
        // Now run the three components of a bugReport, piping their output to the gzip process
        runCommand("dumpstate", osGzip);
        runCommand("dumpsys", osGzip);
        runCommand("logcat -d -v time", osGzip);
        
        // Wait for gzip input and wait for output pipe to to complete
        osGzip.close();
        osGzip = null;
        pipeThread.join();
      } catch (Exception ex) {
        this.ex = ex;
      }
      
      finally {
        if (osFile != null) try { osFile.close(); } catch (IOException ex) {};
        if (isGzip != null) try { isGzip.close(); } catch (IOException ex) {};
        if (osGzip != null) try { osGzip.close(); } catch (IOException ex) {};
      }

      return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
      for (String value : values) {
        Log.w(value);
      }
    }

    @Override
    protected void onPostExecute(Void arg) {
      if (ex != null) Log.e(ex);
      Log.v("BugReportGenerator: Bug Report completed");
    }
    
    /**
     * Run external command piping output to output stream
     * @param cmd command to run
     * @param os output stream
     * @param log output log file builder
     * @throws IOException if there is an IO error of some kind
     */
    private void runCommand(String cmd, OutputStream os) throws IOException {
      
      publishProgress("Running " + cmd);
      
      BufferedInputStream is = null;
      BufferedReader reader = null;
      try {
        Process process = Runtime.getRuntime().exec(cmd);
        is = new BufferedInputStream(process.getInputStream());
        Thread pipeThread = new PipeThread(cmd, is, os);
        
        reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = reader.readLine()) != null) {
          publishProgress(line);
        }
        
        try { pipeThread.join(); } catch (InterruptedException ex) {}
      }
      finally {
        if (is != null) try {is.close(); } catch (IOException ex) {};
        if (reader != null) try { reader.close(); } catch (IOException ex) {};
      }
    }
    
    /**
     * Pipe thread that does nothing except copy bytes from one file to another
     */
    private static class PipeThread extends Thread {
      
      private InputStream is;
      private OutputStream os;
      
      public PipeThread(String name, InputStream is, OutputStream os) {
        super(name);
        this.is = is;
        this.os = os;
        start();
      }
      
      @Override
      public void run() {
        try {
          while (true) {
            int chr = is.read();
            if (chr < 0) return;
            os.write(chr);
          }
        }
        catch (IOException ex) {
          Log.e("Exception in pipe " + getName());
          Log.e(ex);
        }
      }
    }
  }
}
