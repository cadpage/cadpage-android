package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Carroll County, MD
 */
public class MDCarrollCountyAParser extends FieldProgramParser {
  
  private static final Pattern TRAIL_SEQ = Pattern.compile(" \\[\\d+\\]$");
  
  public MDCarrollCountyAParser() {
    super("CARROLL COUNTY", "MD",
           "TIME CT:ADDR! BOX:BOX! DUE:UNIT!");
    setupMultiWordStreets(
        "BEAR BRANCH",
        "DAVE RILL", 
        "EAST CHERRY HILL",
        "GRAVE RUN",
        "LE MANS",
        "SCOTCH HEATHER",
        "TIMBER BRANCH",
        "WAKEFIELD VALLEY");
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
    if (match.find()) body = body.substring(0,match.start()).trim();
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }

  private static final Pattern MA_PTN = Pattern.compile("^(?:MA|MUTUAL AID ALARM) (?:BOX |[A-Z]{2} )?(?:(\\d{1,2}-\\d{1,2}(?:-\\d{1,2})?) )?|^([A-Z]+) +(\\d+-\\d+) +");
  private static final Pattern MA_SEPARATOR_PTN = Pattern.compile(" +- +| */ *| *; *");
  private static final Pattern APT_PTN = Pattern.compile("(?:\\bAPT\\b|#) *([^ ]+)$");
  private static final Pattern CHANNEL_PTN = Pattern.compile("(?:[ \\.]+(CP|TB|TG|FC) *| +)(\\d{1,2}(?:-?[A-Z])?|WEST)$");
  private static final Pattern BOX_PTN = Pattern.compile("\\d{1,2}-\\d{1,2}(?:-\\d{1,2})?");
  private static final Pattern BOX_PTN2 = Pattern.compile("(?: +BOX)? +(\\d{1,2}-\\d{1,2}(?:-\\d{1,2})?)$");
  private class MyAddressField extends Field {
    
    @Override
    public void parse(String fld, Data data) {
      
      fld = fld.replaceAll("/+ */+", "/");
      if (fld.endsWith("/")) fld = fld.substring(0,fld.length()-1).trim();

      // The rules all change for mutual aid calls
      Matcher match = MA_PTN.matcher(fld);
      if (match.find()) {
        String maCall = match.group(2);
        if (maCall != null) {
          data.strBox = match.group(3);
        } else {
          maCall = "MA";
          data.strBox = getOptGroup(match.group(1));
        }
        fld = fld.substring(match.end()).trim();
        
        // Sometimes, the address line is nicely split out with slashes, dashes, or semicolons
        // But first protectect L/Z short for Landing Zone
        // Also CP/TB whatever that may be
        String[] flds = MA_SEPARATOR_PTN.split(fld.replace(" L/Z", " L%Z").replace(" CP/TB", " CP%TB"));
        if (flds.length > 2) {
          parseAddress(flds[0], data);
          int sNdx = 1;
          if (checkAddress(flds[1]) > 0) {
            if (data.strAddress.length() == 0 || !Character.isDigit(data.strAddress.charAt(0))) {
              data.strAddress = append(data.strAddress, " & ", flds[1]);
            } else {
              data.strCross = flds[1];
            }
            sNdx++;
          }
          
          int eNdx = flds.length-1;
          if (eNdx-sNdx > 0 && data.strChannel.length() == 0) {
            data.strChannel = flds[eNdx--];
          }
          if (data.strBox.length() == 0 && eNdx-sNdx > 0) {
            String box = flds[eNdx].trim();
            if (BOX_PTN.matcher(box).matches()) {
              data.strBox = box;
              eNdx--;
            }
          }
          data.strCall = append(maCall, " - ", flds[sNdx].replace("L%Z", "L/Z").replace("CP%TB", "CP/TB"));
          for (int j = sNdx+1; j <= eNdx; j++) {
            data.strCall = append(data.strCall, " / ", flds[j].replace("L%Z", "L/Z").replace("CP%TB", "CP/TB"));
          }
        }
        
        // and sometimes they do not :(
        else {
          
          // Check for trailing channel
          match = CHANNEL_PTN.matcher(fld);
          if (match.find()) {
            data.strChannel = append(getOptGroup(match.group(1)), " ", match.group(2));
            fld = fld.substring(0,match.start()).trim();
          }
          
          // And a trailing box number
          match = BOX_PTN2.matcher(fld);
          if (match.find()) {
            data.strBox = match.group(1);
            fld = fld.substring(0,match.start());
            
            // and an occasional trailing channel in front of the box number :(
            if (data.strChannel.length() == 0) {
              match = CHANNEL_PTN.matcher(fld);
              if (match.find()) {
                data.strChannel = append(getOptGroup(match.group(1)), " ", match.group(2));
                fld = fld.substring(0,match.start()).trim();
              }
            }
          }
          
          // Parse place and address, anything following is the rest of the call
          parseAddress(StartType.START_PLACE, fld, data);
          String call = getLeft();
          if (call.startsWith("/")) call = call.substring(1).trim();
          
          if (data.strPlace.endsWith("/")) {
            data.strAddress = append(data.strPlace.substring(0,data.strPlace.length()-1).trim(), " & ", data.strAddress);
            data.strPlace = "";
          }
          
          // Otherwise, just take the leftover stuff as the call description
          // If there isn't anything left over, grab the leading place field instead
          if (call.startsWith(";")) call = call.substring(1).trim();
          if (call.length() == 0) {
            call = data.strPlace;
            data.strPlace = "";
          }
          data.strCall = append("MA", " - ", call);
        }
      }
      
      // If normal (not mutual aid) call
      else {
        
        // First see if we recognize the call description
        StartType st = StartType.START_CALL;
        int flags = FLAG_START_FLD_REQ | FLAG_ANCHOR_END;
        String call = CALL_SET.getCode(fld, true);
        if (call != null) {
          st = StartType.START_PLACE;
          flags = FLAG_ANCHOR_END;
          data.strCall = call;
          fld = fld.substring(call.length()).trim();
        }
        
        // Next check if the last token is a recognized city and
        // strip it off if it is, otherwise it messes up the following logic
        Parser p = new Parser(fld);
        String city = CITY_CODES.getProperty(p.getLast(' '));
        if (city != null) {
          data.strCity = city;
          fld = p.get();
        }
        
        // Rest of address could include a place name separated by a ; or @
        // Unfortunately, the two fields might be in either order :(
        // Worse, there could be 3 or  more :(  In which case we only
        // check the first two and force the last one into a place field
        // And the place name might contain an apartment
        String[] flds = fld.split(" *[;@] *", 3);
        if (flds.length == 1) {
          parseAddress(st, flags, fld, data);
          if (data.strPlace.endsWith("/")) {
            data.strAddress =  append(data.strPlace.substring(0,data.strPlace.length()-1).trim(), " & ", data.strAddress);
            data.strPlace = "";
          }
        }
        else {
          String fld1 = flds[0];
          String fld2 = flds[1];
          String savePlace = flds.length > 2 ? flds[2] : "";
          Result res1 = parseAddress(st, flags | FLAG_CHECK_STATUS, fld1);
          Result res2 = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, fld2);
          if (res2.getStatus() > res1.getStatus()) {
            res1 = res2;
            fld2 = fld1;
          }
          res1.getData(data);
          if (data.strPlace.endsWith("/")) {
            data.strAddress =  append(data.strPlace.substring(0,data.strPlace.length()-1).trim(), " & ", data.strAddress);
            data.strPlace = "";
          }
          match = APT_PTN.matcher(fld2);
          if (match.find()) {
            data.strApt = match.group(1);
            fld2 = fld2.substring(0,match.start()).trim();
          }
          if (data.strCall.length() == 0) {
            data.strCall = fld;
          } else {
            data.strPlace = append(data.strPlace, " - ", fld2);
          }
          if (savePlace.length() > 0) {
            match = APT_PTN.matcher(savePlace);
            if (match.find()) {
              data.strApt = append(data.strApt, "-", match.group(1));
              savePlace =  savePlace.substring(0,match.start()).trim();
            }
            data.strPlace = append(data.strPlace, " - ", savePlace);
          }
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL BOX PLACE ADDR X APT CITY CH";
    }
  }
  
  // Box field behaves normally unless this is a mutual aid call
  // in which case it becomes a county code
  private class MyBoxField extends BoxField {
    
    @Override
    public void parse(String fld, Data data) {
      if (data.strCall.startsWith("MA ") || data.strCall.equals("MA")) {
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
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("BOX")) return new MyBoxField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    // Other location seem OK with decimal street addresses, but not here
    return DECIMAL_PTN.matcher(address).replaceFirst("$1");
  }
  private static final Pattern DECIMAL_PTN = Pattern.compile("^(\\d+)\\.\\d+");

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

  private static final CodeSet CALL_SET = new CodeSet(
      "ALARM",
      "ALARM 1",
      "ALARM 2",
      "ALS",
      "ALS+",
      "ALS MEDICAL CALL",
      "AMB TRANS", 
      "ATR",
      "BF",
      "BF RESC",
      "BLS",
      "BLS MEDICAL CALL",
      "BOX",
      "BRUSH",
      "CA",
      "CARDIAC",
      "CARDIAC ARREST",
      "CHIM",
      "CO 1",
      "CO 2",
      "CO 3",
      "CO 4",
      "COS",
      "GAS LINE", 
      "HF",
      "HOUSE FIRE",
      "INVEST",
      "IVT",
      "LARGE TRUCK FIRE",
      "LO/E",
      "LOCAL",
      "PA",
      "PATIENT ASSIST",
      "PROQA DEFAULT",
      "RES FIRE ALARM",
      "SERVICE",
      "STRUC",
      "STRUCTURE ALARM",
      "TRAIN AC", 
      "TRAIN FI",
      "TRANS",
      "UC",
      "UNCONSCIOUS SUBJECT",
      "VC",
      "VC BUS",
      "VC SERIOUS",
      "VCR",
      "VCS",
      "VEHICLE",
      "VEHICLE COLLISION"
      
  );
}
