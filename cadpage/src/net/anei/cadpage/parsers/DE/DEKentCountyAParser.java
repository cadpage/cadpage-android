package net.anei.cadpage.parsers.DE;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Kent County, DE (Variant A)
 */

public class DEKentCountyAParser extends DEKentCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile("[A-Z']+:| :", Pattern.CASE_INSENSITIVE);
  
  public DEKentCountyAParser() {
    super("( CALL ADDR/ZS PLACECITY | ADDR/SCXP ) Xst's:X CALLER:NAME? Lat:GPS1 Long:GPS2");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Rule out Variant B pages
    if (body.startsWith("-")) return false;
    if (body.contains(" -- ")) return false;
    
    boolean good = subject.equals("!|K") || subject.equals("K") || subject.equals("CAD");
    if (!parseFields(splitMsg(body), data)) return false;
    setState(data);
    if (data.strCross.equals("No Cross Streets Found")) data.strCross = "";
    if (good) return true;
    if (getStatus() <= STATUS_STREET_NAME) return false;
    return good || data.strAddress.length() > 0 || data.strCross.length() > 0 || data.strName.length() > 0;
  }
  
  private String[] splitMsg(String body) {
    List<String> list = new ArrayList<String>();
    Matcher match = DELIM.matcher(body);
    int pt = 0;
    String key = "";
    while (match.find()) {
      list.add((key + body.substring(pt,match.start())).trim());
      pt = match.end();
      key = match.group();
      if (key.equals(" :")) key = "";
    }
    String tail = key + body.substring(pt);
    if (tail.length() > 0) list.add(tail);
    return list.toArray(new String[list.size()]);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACECITY")) return new MyPlaceCityField();
    return super.getField(name);
  }
  
  private class MyPlaceCityField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Result res = parseAddress(StartType.START_PLACE, FLAG_ONLY_CITY | FLAG_ANCHOR_END, field);
      if (res.getStatus() == 0) return false;
      res.getData(data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
}
