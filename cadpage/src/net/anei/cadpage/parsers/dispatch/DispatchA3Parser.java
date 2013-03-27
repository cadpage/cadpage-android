package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Handles parsing for a vendor identified as VisionCAD
*/
public class DispatchA3Parser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("(?<!\\*)\\*[\n ]+");
  
  private String prefix;
  
  public DispatchA3Parser(int version, String prefix, String defCity, String defState) {
    super(defCity, defState,
           version == 0 ?
             "ID? ADDR/SXP APT CH CITY! X X MAP INFO1 CALL INFO ( UNIT! | NAME UNIT! | NAME PHONE UNIT ) INFO+"
           : version == 1 ?
               "ID? ADDR/SXP APT CH CITY! EMPTY+? CALL CALL ( UNIT! | NAME UNIT! | NAME PHONE UNIT ) INFO+"
           : version == 2 ?
               "ID ADDR APT CH CITY X X MAP INFO1 SKIP CALL! PLACENAME PHONE UNIT INFO+"
           : version == 3 ?
               "ID Address:ADDR! APT CH! City:CITY! INFO+ Type:CALL CALL NAME PH#:PHONE Units:UNIT IRA:SKIP? INFO+ NARR:INFO INFO+"   // Not currently used
           : version == 4 ?
               "ID Address:ADDR! APT CH! City:CITY! X+ Type:X! X INFO+ PH#:CODE! Units:CALL! IRA:NAME PHONE UNIT% INFO+ NARR:INFO INFO+"   // Davie County, NC variant of 3
           : version == 5 ?
               "ID Address:ADDR! APT APT! City:CITY! X X MAP LocCmmt:INFO1! Comp:CODE! Desc:CALL! Caller:NAME! Ph#:PHONE! Units:UNIT! SKIP INFO+"
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
  
  private static final Pattern COMMENT_LABEL = Pattern.compile("^(?:Landmark|Geo) Comment:");
  private class BaseInfo1Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("NBH:");
      if (pt >= 0) {
        data.strPlace = append(data.strPlace, " - ", field.substring(pt+4).trim());
        field = field.substring(0,pt).trim();
      } 
      Matcher match = COMMENT_LABEL.matcher(field);
      if (match.find()) {
        field = field.substring(match.end()).trim();
        if (field.startsWith("UPDATE")) return;
      }
      super.parse(field, data);
    }
  }
  
  private static final Pattern LINE_PTN = Pattern.compile("Line\\d+=");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d?\\d/\\d?\\d/\\d{4}) (\\d?\\d:\\d?\\d:\\d?\\d(?: [AP]M)?) : \\w+ : \\w+\\b");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private static final Pattern EXTRA_DELIM = Pattern.compile("\\*\\* EMD (?:Case Entry Finished|Case Complete|Recommended Dispatch) \\*\\*|\\bResponse Text:|\\bKey Questions:|\\bGeo Comment:|\\bLandmark Comment:|Narrative ?:|\\b(?=Cross Streets:|Landmark:|NBH:|[XY] Coordinate:|Uncertainty Factor:|Confidence Factor:|\\**Nearest Address:)|Place Comment:|  +|\n| \\.\\. |\bALI\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern SKIP_PTN = Pattern.compile("^UPDATED? +\\d\\d?(?:[-/]\\d\\d?){1,2}\\b.*");
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.toUpperCase().startsWith(data.strCall.toUpperCase())) {
        data.strCall = field;
        return;
      }
      
      Matcher match = LINE_PTN.matcher(field);
      if (match.find()) field = field.substring(match.end()).trim();
      
      match = DATE_TIME_PTN.matcher(field);
      if (!match.find()) {
        super.parse(field, data);
        return;
      }
      
      data.strDate = match.group(1);
      String time = match.group(2);
      if (time.endsWith("M")) {
        setTime(TIME_FMT, time, data);
      } else {
        data.strTime = time;
      }
     
      for (String fld1 : DATE_TIME_PTN.split(field)) {
        String connect = "\n";
        for (String fld2 : EXTRA_DELIM.split(fld1)) {
          fld2 = fld2.trim();
          if (fld2.length() == 0) continue;
          
          if (SKIP_PTN.matcher(fld2).matches()) continue;
          
          String upshift = fld2.toUpperCase();
          if (upshift.startsWith("LANDMARK:")) {
            if (data.strPlace.length() == 0) data.strPlace = fld2.substring(9).trim();
            continue;
          }
          
          // Strip redundant place
          if (upshift.startsWith("NBH:")) {
            int pt2 = fld2.indexOf(data.strPlace);
            if (pt2 >= 0) {
              pt2 += data.strPlace.length();
              fld2 = fld2.substring(pt2).trim();
            }
          }
          
          if (upshift.startsWith("CROSS STREETS:")) {
            fld2 = fld2.substring(14).trim();
            String saveCross = data.strCross;
            int pt = fld2.indexOf("//");
            if (pt < 0) {
              data.strCross = fld2;
              fld2 = "";
            } else {
              String prefix = fld2.substring(0,pt).trim();
              fld2 = fld2.substring(pt+2);
              if (fld2.startsWith(" ")) {
                fld2 = fld2.trim();
              } else {
                Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, fld2);
                if (res.getStatus() > 0) {
                  res.getData(data);
                  fld2 = res.getLeft();
                } else {
                  data.strCross = fld2;
                  fld2 = "";
                }
              }
              data.strCross = append(prefix, " / ", data.strCross);
            }
            if (saveCross.length() > 0) data.strCross = saveCross;
          }
         
          if (fld2.length() > 0 && !fld2.equals(":") && !data.strSupp.contains(fld2)) {
            data.strSupp = append(data.strSupp, connect, fld2);
            connect = " / ";
          }
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME X PLACE INFO";
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
    if (name.equals("ID")) return new IdField("\\d{2,6}-\\d{4,}|", true);
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
