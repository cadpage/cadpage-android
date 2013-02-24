package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Handles parsing for a vendor identified as VisionCAD
*/
public class DispatchA3Parser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*[\n ]+");
  
  private String prefix;
  
  public DispatchA3Parser(int version, String prefix, String defCity, String defState) {
    super(defCity, defState,
           version == 0 ?
             "ID? ADDR/SXP APT CH CITY! X X MAP INFO1 CALL INFO ( UNIT! | NAME UNIT! | NAME PHONE UNIT ) INFO+"
           : version == 1 ?
               "ID? ADDR/SXP APT CH CITY! EMPTY+? CALL CALL ( UNIT! | NAME UNIT! | NAME PHONE UNIT ) INFO+"
           : null);
    this.prefix = prefix;
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith(prefix)) return false;
    body = body.substring(prefix.length()).trim();
    if (body.endsWith("*")) body = body + " ";
    return parseFields(DELIM.split(body), data);
  }
  
  private class BaseAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "/");
      super.parse(field, data);
      if (data.strPlace.startsWith("/")) data.strPlace = data.strPlace.substring(1).trim();
    }
  }
  
  private class BaseChannelField extends ChannelField {
    @Override
    public void parse(String field, Data data) {
      
      // If nothing entered, see if the apt looks like a channel
      if (field.length() == 0 && data.strApt.startsWith("TAC")) {
        data.strChannel = data.strApt;
        data.strApt = "";
      } else {
        super.parse(field, data);
      }
    }
  }
  
  private class BaseCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("_")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      
      // Override previous call field
      if (field.length() > 0) data.strCall = field;
    }
  }
  
  private class BaseInfo1Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("NBH:");
      if (pt >= 0) {
        data.strPlace = append(data.strPlace, " - ", field.substring(pt+4).trim());
        field = field.substring(0,pt).trim();
      } 
      super.parse(field, data);
    }
  }
  
  private static final Pattern LINE_PTN = Pattern.compile("Line\\d+=");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) : \\w+ : \\w+\\b");
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.toUpperCase().startsWith(data.strCall.toUpperCase())) {
        data.strCall = field;
        return;
      }
      Matcher match = LINE_PTN.matcher(field);
      if (match.find()) {
        field = field.substring(match.end()).trim();
        match = DATE_TIME_PTN.matcher(field);
        if (match.find()) {
          data.strDate = match.group(1);
          data.strTime = match.group(2);
          field = match.replaceAll("");
          
          // Strip redundant place
          int pt = field.indexOf(" NBH:");
          if (pt >= 0) {
            int pt2 = field.indexOf(data.strPlace, pt);
            if (pt2 >= 0) {
              pt2 += data.strPlace.length();
              field = field.substring(0,pt) + field.substring(pt2);
            }
          }
          
          // Strip redundant cross street info
          pt = field.indexOf(" Cross streets:");
          if (pt >= 0) {
            String cross = data.strCross;
            int pt2 = cross.lastIndexOf('&');
            if (pt2 >= 0) cross = cross.substring(pt2+1).trim();
            pt2 = field.lastIndexOf(cross);
            if (pt2 >= pt) {
              pt2 += cross.length();
              while (pt2 < field.length() && field.charAt(pt2)=='/') pt2++;
              field = field.substring(0,pt) + field.substring(pt2);
            }
          }
          field = field.trim();
        }
      }
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO DATE TIME";
    }
  }
  
  private class BaseNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("*");
      if (pt >= 0) {
        data.strPhone = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{2,4}-\\d{4,}|", true);
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("CH")) return new BaseChannelField();
    if (name.equals("X")) return new BaseCrossField();
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("INFO1")) return new BaseInfo1Field();
    if (name.equals("INFO")) return new BaseInfoField();
    if (name.equals("NAME")) return new BaseNameField();
    if (name.equals("UNIT")) return new UnitField("(?:[A-Z0-9]{1,4}[0-9]|CSRS)(?:,(?:[A-Z]{0,3}[0-9]+[A-Z]{0,3}|[A-Z]{1,4}))*");
    return super.getField(name);
  }
}
