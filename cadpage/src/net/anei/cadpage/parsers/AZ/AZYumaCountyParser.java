package net.anei.cadpage.parsers.AZ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

public class AZYumaCountyParser extends MsgParser {
  
  public AZYumaCountyParser() {
    super("YUMA COUNTY", "AZ");
  }
  
  @Override
  public String getFilter() {
    return "yumacomm@rmetro.com";
  }
  
  private static final Pattern MASTER1 = Pattern.compile("(CH *\\d+) ([A-Z]+) ASSIGN: *([A-Z0-9, ]+) - (.*?) (?i)FOR (?:REPORT OF )?(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern MASTER2 = Pattern.compile("(CH *\\d+) ([A-Z]+) ASSIGN FOR ([A-Z0-9,. ]+?)(?: AREA OF | - )(.*?) [-/] (.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern MASTER3 = Pattern.compile("(CH *\\d+) ([A-Z]+) (.*?) FOR (.*?),? REPORTED AS (.*)", Pattern.CASE_INSENSITIVE);
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf("\n***");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = MASTER1.matcher(body);
    if (match.matches()) {
      setFieldList("CH CALL UNIT ADDR APT PLACE");
      data.strChannel = match.group(1).toUpperCase().replace(" ", "");
      data.strCall = match.group(2).toUpperCase();
      data.strUnit = match.group(3).trim().toUpperCase();
      parseAddressField(match.group(4), data);
      data.strCall = append(data.strCall, " - ", match.group(5).trim());
      return true;
    }
    
    if ((match = MASTER2.matcher(body)).matches()) {
      setFieldList("CH CALL UNIT ADDR APT PLACE");
      data.strChannel = match.group(1).toUpperCase().replace(" ", "");
      data.strCall = match.group(2).toUpperCase();
      data.strUnit = match.group(3).trim().toUpperCase();
      parseAddressField(match.group(4), data);
      data.strCall = append(data.strCall, " - ", match.group(5).trim());
      return true;
    }
    
    if ((match = MASTER3.matcher(body)).matches()) {
      setFieldList("CH CALL ADDR APT PLACE UNIT");
      data.strChannel = match.group(1).toUpperCase().replace(" ",  "");
      data.strCall = match.group(2).toUpperCase();
      parseAddressField(match.group(3), data);
      data.strUnit = match.group(4).trim().toUpperCase();
      data.strCall = append(data.strCall, " - ", match.group(5).trim());
      return true;
    }
    
    return false;
  }
  
  private void parseAddressField(String field, Data data) {
    field = field.trim();
    if (field.endsWith(")")) {
      int pt = field.indexOf('(');
      data.strPlace = field.substring(pt+1, field.length()-1).trim();
      field = field.substring(0,pt).trim();
    }
    else {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
    }
    
    parseAddress(field, data);
  }
}
