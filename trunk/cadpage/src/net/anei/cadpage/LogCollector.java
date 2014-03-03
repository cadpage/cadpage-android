package net.anei.cadpage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import android.os.AsyncTask;

/**
 * Class to retrieve information from Android logs
 * Cloned from http://code.google.com/p/android-log-collector
 * written by sergey@xtralogic.com 
 */
public abstract class LogCollector {
  
  public static final String START_MARKER = "*** CADPAGE START LOG MARKER ***";
  public static final String END_MARKER = "*** CADPAGE END LOG MARKER ***";
  
  public LogCollector(String format, String buffer, String filterSpecs) {
    
    ArrayList<String> list = new ArrayList<String>();
    list.add("logcat");
    list.add("-d");
    
    if (format != null){
      list.add("-v");
      list.add(format);
    }
    
    if (buffer != null){
      list.add("-b");
      list.add(buffer);
    }

    if (filterSpecs != null){
      list.addAll(Arrays.asList(filterSpecs.split(";")));
      list.add("*:S");
    }
    
    new CollectLogTask().execute(list.toArray(new String[list.size()]));
  }
  
  abstract void collectLog(String logBuffer);

  private class CollectLogTask extends AsyncTask<String, Void, String> {
    
    private Exception ex;

    @Override
    protected String doInBackground(String... params) {
      final StringBuilder log = new StringBuilder();
      try {

        Process process = Runtime.getRuntime().exec(params);
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(process.getInputStream()));

        String line;
        boolean suppress = false;
        while ((line = bufferedReader.readLine()) != null) {
          if (line.contains(START_MARKER)) suppress = true;
          else if (line.contains(END_MARKER)) suppress = false;
          else if (!suppress) {
            if (log.length() > 0) log.append('\n');
            log.append(line);
          }
        }
      } catch (Exception ex) {
        this.ex = ex;
      }

      return log.toString();
    }

    @Override
    protected void onPostExecute(String log) {
      if (ex != null) throw new RuntimeException("Exception thrown in LogCollector thread", ex);
      collectLog(log);
    }
  }

}
