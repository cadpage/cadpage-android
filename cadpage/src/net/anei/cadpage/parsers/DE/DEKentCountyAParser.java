package net.anei.cadpage.parsers.DE;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Kent County, DE (Variant A)
 */

public class DEKentCountyAParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("[A-Z]+:| :", Pattern.CASE_INSENSITIVE);
  
  public DEKentCountyAParser() {
    super(CITY_LIST, "KENT COUNTY", "DE",
           "( CALL ADDR/ZS PLACECITY | ADDR/SCXP ) Xsts:X CALLER:NAME");
  }
  
  @Override
  public String getFilter() {
    return "rc.187@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Rule out Variant B pages
    if (body.startsWith("-")) return false;
    
    boolean good = subject.equals("!|K") || subject.equals("K") || subject.equals("CAD");
    body = body.replace("Xst's:", "Xsts:");
    if (!parseFields(splitMsg(body), data)) return false;
    if (good) return true;
    if (getStatus() <= 1) return false;
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
    String tail = body.substring(pt);
    if (tail.length() > 0) list.add(tail);
    return list.toArray(new String[list.size()]);
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACECITY")) return new MyPlaceCityField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "CAMDEN WYOMING",
    "DOVER",
    "HARRINGTON",
    "MILFORD",
    "BOWERS",
    "CAMDEN",
    "CHESWOLD",
    "CLAYTON",
    "FARMINGTON",
    "FELTON",
    "FREDERICA",
    "HARTLY",
    "HOUSTON",
    "KENTON",
    "LEIPSIC",
    "LITTLE CREEK",
    "MAGNOLIA",
    "SMYRNA",
    "VIOLA",
    "WOODSIDE",
    "WYOMING"
  };
}


