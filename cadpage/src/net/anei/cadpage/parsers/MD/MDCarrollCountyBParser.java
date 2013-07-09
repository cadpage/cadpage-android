package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Carroll County, MD
 */
public class MDCarrollCountyBParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Station (\\d\\d) ALERT!! \\((F?\\d+)\\)");
  
  public MDCarrollCountyBParser() {
    super("CARROLL COUNTY", "MD",
           "CALL ( BOX UNIT | UNIT BOX ) ADDR! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "FASTalert System,.fastalerting.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    data.strCallId = match.group(2);
    body = body.replaceAll("  +", " ");
    return parseFields(body.split("\n"), 4, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC ID " + super.getProgram();
  }
  
  // Box field behaves normally unless this is a mutual aid call
  // in which case it becomes a county code
  private static final Pattern BOX_PTN = Pattern.compile("\\d{3,}");
  private class MyBoxField extends BoxField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strCall.startsWith("MUTUAL AID")) {
        String[] tmp = convertCodes(field, COUNTY_CODES).split(",");
        data.strCity = tmp[0];
        if (tmp.length > 1) data.strState = tmp[1];
      }
      else {
        if (!BOX_PTN.matcher(field).matches()) return false;
        super.parse(field, data);
      }
      return true;
    }
    
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private static final Pattern ADDR_BOX_PTN = Pattern.compile("\\d{2}-\\d{1,2}");
  private static final Pattern APT_PTN = Pattern.compile("(?:\\bAPT\\b|\\bROOM\\b|\\bRM\\b|#) *([^ ]+)$");
  private static final Pattern APT_PTN2 = Pattern.compile("(?:\\bAPT|\\bROOM|\\bRM|#) *([^ ]+) *");
  private static final Pattern CHANNEL_PTN = Pattern.compile(" TG *(.*)$");
  private static final Pattern SEPARATOR = Pattern.compile(";| // ");
  private class MyAddressField extends Field {
    
    @Override
    public void parse(String fld, Data data) {
      
      // Rules are completely different for mutual aid calls
      // If it was, there may be a box code, 
      // there is some addition call description stuff following the address
      // And the last token is a radio code
      if (data.strCall.startsWith("MUTUAL AID")) {
        Parser p = new Parser(fld);
        String tmp = p.get(' ');
        if (tmp.equals("BOX") || tmp.equals("BC")) {
          data.strBox = p.get(' ');
          fld = p.get();
        } else if (ADDR_BOX_PTN.matcher(tmp).matches()) {
          data.strBox = tmp;
          fld = p.get();
        }
        Matcher match = CHANNEL_PTN.matcher(fld);
        if (match.find()) {
          data.strChannel = match.group(1).trim();
          fld = fld.substring(0,match.start()).trim();
        }
        
        String call;
        match = SEPARATOR.matcher(fld);
        if (match.find()) {
          parseAddress(fld.substring(0,match.start()).trim(), data);
          int pt = match.end();
          if (data.strChannel.length() == 0 && match.find()) {
            call = fld.substring(pt, match.start()).trim();
            data.strChannel = fld.substring(match.end()).trim();
          } else {
            call = fld.substring(pt).trim();
          }
        } else {
          parseAddress(StartType.START_ADDR, fld, data);
          call = getLeft();
        }
        data.strCall = append(data.strCall, " - ", call);
      }
      
      // resume normal address parsing
      else {
        // Strip off state and city
        Parser p = new Parser(fld);
        String city = p.getLastOptional(',');
        if (city.length() == 2) {
          if (!city.equals(data.defState)) data.strState = city;
          city = p.getLastOptional(',');
        }
        data.strCity = city;
        
        // See if we can find an apt field
        fld = p .get();
        Matcher match = APT_PTN.matcher(fld);
        if (match.find()) {
          data.strApt = match.group(1);
          fld = fld.substring(0,match.start()).trim();
        }
        
        
        // Rest of address could include a place name separated by a ; or @
        // Unfortunately, the two fields might be in either order :(
        if (fld.startsWith("@")) fld = fld.substring(1).trim();
        int pt = fld.indexOf('@');
        if (pt < 0) pt = fld.indexOf(';');
        if (pt < 0) {
          match = APT_PTN2.matcher(fld);
          if (match.find()) {
            data.strApt = match.group(1);
            data.strPlace = fld.substring(0,match.start()).trim();
            fld = fld.substring(match.end()).trim();
          }
          if (data.strPlace.length() > 0) {
            parseAddress(fld, data);
          } else {
            parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, fld, data);
            if (data.strAddress.length() == 0) {
              parseAddress(data.strPlace, data);
              data.strPlace = "";
            }
            else if (data.strPlace.length() > 0) {
              if (data.strApt.length() > 0) {
                data.strApt = data.strApt + ' ' + data.strPlace;
                data.strPlace = "";
              }
            }
          }
        }
        else {
          String fld1 = fld.substring(0,pt).trim();
          String fld2 = fld.substring(pt+1).trim();
          Result res1 = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, fld1);
          Result res2 = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, fld2);
          if (res2.getStatus() > res1.getStatus()) {
            res1 = res2;
            fld2 = fld1;
          }
          res1.getData(data);
          data.strPlace = fld2;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "BOX PLACE ADDR APT CITY ST CH";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("BOX")) return new MyBoxField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  // Mutual aid count abbreviations
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "YC", "YORK COUNTY,PA",
      "BC", "BALTIMORE COUNTY",
      "HC", "HOWARD COUNTY",
      "FC", "FREDERICK COUNTY",
      "AC", "ADAMS COUNTY,PA",
      "MC", "MONTGOMERY COUNTY"
  });
}
