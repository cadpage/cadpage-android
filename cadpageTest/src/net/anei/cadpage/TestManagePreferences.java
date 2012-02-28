package net.anei.cadpage;

import java.util.HashMap;
import java.util.Map;

public class TestManagePreferences extends ManagePreferences {
  
  private Map<Integer, Object> prefMap = new HashMap<Integer, Object>();
  
  public TestManagePreferences() {
    setTestPreference(this);
  }
  
  public void setTestLocation(String newLocation) {
    putString(R.string.pref_location_key, newLocation);
  }
  
  public void setTestOverrideDefault(boolean newVal) {
    putBoolean(R.string.pref_override_default_key, newVal);
  }
  
  public void setTestOverrideFilter(boolean newVal) {
    prefMap.put(R.string.pref_override_filter_key, newVal);
  }
  
  public void setTestFilter(String filter) {
    prefMap.put(R.string.pref_filter_key, filter);
  }
  
  public void setTestGenAlert(boolean newVal) {
    prefMap.put(R.string.pref_gen_alert_key, newVal);
  }

  public void putBoolean(int resPrefId, boolean newVal) {
    prefMap.put(resPrefId, newVal);
  }

  @Override
  public void putInt(int resPrefId, int newVal) {
    prefMap.put(resPrefId, newVal);
  }

  @Override
  public void putString(int resPrefId, String newVal) {
    prefMap.put(resPrefId, newVal);
  }

  @Override
  protected boolean getBoolean(int resPrefId) {
    return (Boolean)getPreference(resPrefId);
  }

  @Override
  protected int getInt(int resPrefId, int defValue) {
    return (Integer)getPreference(resPrefId);
  }

  @Override
  protected int getInt(int resPrefId) {
    return (Integer)getPreference(resPrefId);
  }

  @Override
  protected String getString(int resPrefId, String defaultVal) {
    return (String)getPreference(resPrefId, defaultVal);
  }

  @Override
  protected String getString(int resPrefId) {
    return (String)getPreference(resPrefId);
  }
  
  private Object getPreference(int resPrefId) {
    return getPreference(resPrefId, null);
  }
  
  private Object getPreference(int resPrefId, Object defValue) {
  
    Object result = prefMap.get(resPrefId);
    if (result == null) {
      if (defValue == null) {
        throw new RuntimeException("Test preference has not been set");
      }
      result = defValue;
    }
    return result;
  }
  
  
}
