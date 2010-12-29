package net.anei.cadpage;

import java.util.HashMap;
import java.util.Map;

public class TestManagePreferences extends ManagePreferences {
  
  private Map<Integer, Object> prefMap = new HashMap<Integer, Object>();
  
  public TestManagePreferences() {
    setTestPreference(this);
  }
  
  public void setOverrideDefault(boolean newVal) {
    putBoolean(R.string.pref_override_default_key, newVal);
  }
  
  public void setFilter(String filter) {
    prefMap.put(R.string.pref_filter_key, filter);
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
  protected String getString(int resPrefId) {
    return (String)getPreference(resPrefId);
  }
  
  private Object getPreference(int resPrefId) {
    Object result = prefMap.get(resPrefId);
    if (result == null) throw new RuntimeException("Test preference has not been set");
    return result;
  }
  
  
}
