package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Carroll County, MD
 */
public class MDCarrollCountyAParser extends FieldProgramParser {
  
  // List of call descriptions consisting for multiple words
  private static final String[] TWO_WORD_CALLS = new String[] {
    "BF RESC", "TRAIN AC", "TRAIN FI", "GAS LINE", "AMB TRANS", "ALARM 2"
  };
  
  private static final Pattern TRAIL_SEQ = Pattern.compile(" \\[\\d+\\]$");
  private static final Pattern BOX_PTN = Pattern.compile("\\d{2}-\\d{1,2}");
  private static final Pattern APT_PTN = Pattern.compile("(?:\\bAPT\\b|#) *([^ ]+)$");
  private static final Pattern CHANNEL_PTN = Pattern.compile(" TG *\\d{1,2}$");
  
  public MDCarrollCountyAParser() {
    super("CARROLL COUNTY", "MD",
           "CT:ADDR! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    do {
      if (subject.equals("!")) break;
      
      if (subject.endsWith("|!")) {
        data.strSource = subject.substring(0,subject.length()-2);
        break;
      }
      
      int pt = body.indexOf(" / [!] ");
      if (pt >= 0) {
        data.strSource = body.substring(0,pt).trim();
        body = body.substring(pt+7).trim();
        break;
      }

      // Message signatures are now optional.  If we don't find one, keep on procesing
    } while (false);
    
    Matcher match = TRAIL_SEQ.matcher(body);
    if (!match.find()) return false;
    body = body.substring(0,match.start()).trim();
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyAddressField extends Field {
    
    @Override
    public void parse(String fld, Data data) {
      
      fld = fld.replaceAll("/+ */+", "/");
      
      // See if field starts with one of the multiple word call descriptions
      data.strCall = "";
      for (String c : TWO_WORD_CALLS) {
        if (fld.startsWith(c)) {
          data.strCall = c;
          fld = fld.substring(c.length()).trim();
          break;
        }
      }
      
      // If not, first token is the call description
      if (data.strCall.length() == 0) {
        Parser p = new Parser(fld);
        data.strCall = p.get(' ');
        fld = p.get();
      }
      
      // Now, see if this was a mutual aid call
      // If it was, there may be a box code, 
      // there is some addition call description stuff following the address
      // And the last token is a radio code
      if (data.strCall.equals("MA")) {
        Parser p = new Parser(fld);
        String tmp = p.get(' ');
        if (tmp.equals("BOX") || tmp.equals("BC")) {
          data.strBox = p.get(' ');
          fld = p.get();
        } else if (BOX_PTN.matcher(tmp).matches()) {
          data.strBox = tmp;
          fld = p.get();
        }
        Matcher match = CHANNEL_PTN.matcher(fld);
        if (match.find()) {
          data.strSupp = match.group().replace(" ", "");
          fld = fld.substring(0,match.start()).trim();
        }
        parseAddress(StartType.START_PLACE, fld, data);
        data.strCall = "MA - " + getLeft();
      }
      
      // If normal (not mutual aid) call
      else {
        
        // First we have to see if the last token is a recognized city and
        // strip it off if it is, otherwise it messes up the following logic
        Parser p = new Parser(fld);
        String city = CITY_CODES.getProperty(p.getLast(' '));
        if (city != null) {
          data.strCity = city;
          fld = p.get();
        }
        
        // Rest of address could include a place name separated by a ; or @
        // Unfortunately, the two fields might be in either order :(
        // And the place name might contain an apartment
        int pt = fld.indexOf('@');
        if (pt < 0) pt = fld.indexOf(';');
        if (pt < 0) {
          parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, fld, data);
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
          Matcher match = APT_PTN.matcher(fld2);
          if (match.find()) {
            data.strApt = match.group(1);
            fld2 = fld2.substring(0,match.start()).trim();
          }
          data.strPlace = fld2;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL BOX PLACE ADDR X APT CITY INFO";
    }
  }
  
  // Box field behaves normally unless this is a mutual aid call
  // in which case it becomes a county code
  private class MyBoxField extends BoxField {
    
    @Override
    public void parse(String fld, Data data) {
      if (data.strCall.startsWith("MA ")) {
        String[] tmp = convertCodes(fld, COUNTY_CODES).split(",");
        data.strCity = tmp[0];
        if (tmp.length > 1) data.strState = tmp[1];
      }
      else {
        super.parse(fld, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "BOX CITY ST";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("BOX")) return new MyBoxField();
    return super.getField(name);
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AIRY", "MT AIRY",
      "FINK", "FINKSBURG",
      "HAMP", "HAMPSTEAD",
      "KEYM", "KEYMAR",
      "LINE", "LINEBORO",
      "LINW", "LINWOOD",
      "MANC", "MANCHESTER",
      "MARR", "MARRIOTSVILLE",
      "MILL", "MILLERS",
      "NWIN", "NEW WINDSOR",
      "REIS", "REISTERSTOWN",
      "SYKE", "SYKESVILLE",
      "TANE", "TANEYTOWN",
      "UNBR", "UNION BRIDGE",
      "UPCO", "UPPERCO",
      "WEST", "WESTMINSTER",
      "WOOD", "WOODBINE",
  });
  
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
