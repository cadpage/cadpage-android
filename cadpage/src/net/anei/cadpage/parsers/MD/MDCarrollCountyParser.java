package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Carroll County, MD
Contact: Shawn <countryfireman@gmail.com>
Contact: Brett Pearce <brett.a.pearce@gmail.com>
Sender: @c-msg.net

(Co12) [!] CT:UC 6513 CARROLL HIGHLANDS RD SYKE BOX:1211 DUE:X127 E123 [66]
(Co12) [!] CT:BLS SHOPPERS FOOD WHSE @6300 GEORGETOWN BLVD SYKE BOX:1224 DUE:X128 [69]
(Co12) [!] CT:BLS 5584 COMPTON LA SYKE BOX:1214 DUE:X129 [70]
[Co12] [!] CT:INVEST KABIK CT / RAILROAD DR E WOOD BOX:1204 DUE:B125 [68]
(Co12) [!] CT:ALS 1820 VINCENZA DR @MARVIN GARDENS APT C SYKE BOX:1232 DUE:X128 [71]
[Co14] [!] CT:SERVICE 3215 HOOPERS DELIGHT RD NWIN BOX:1411 DUE:U14 [18]
[Co14] [!] CT:BLS 5401 ENTERPRISE ST ; ALLEGRA PRINT SYKE BOX:1416 DUE:X149 [33]
(Co12) [!] CT:CHIM 811 DAVID AV WEST BOX:0316 DUE:TO12 [13]
(Co12) [!] CT:LOCAL HENRYTON RD / MARRIOTTSVILLE RD ONE MARR BOX:1208 DUE:E123 [12]

Contact: Troy Hipsley <troy.hipsley@gmail.com>
(Co2) [!] CT:MA BOX 60-18 19907 YORK RD VCR TG44 BOX:BC DUE:T2 [41]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:ET24 BE432 E23 BE422 E91 TO3 BET431 ET44 BTS434 X29 CS4 [15]
[Co 2] [!] CT:MA 42-2 RT 30/EMORY RD RESCUE TG 46 BOX:BC DUE:E23 [39]
[Co 2] [!] CT:ALS 3900 SHILOH AV HAMP BOX:0218 DUE:BM435 FR2 [44]
[Co 2] [!] CT:ALS 1211 N MAIN ST @RESIDENCE@HAMP SCHOL APT 212 HAMP BOX:0220 DUE:X29 FR2 [43]
[Co 2] [!] CT:ALS 3993 BRIDGE FIELD DR HAMP BOX:0208 DUE:X49 FR2 [32]
[Co 2] [!] CT:ALS 1835 GABLEHAMMER RD WEST BOX:0212 DUE:E43 [29]
[Co 2] [!] CT:UC 4800 MILLERS STATION RD HAMP BOX:0214 DUE:X29 E23 [91]
[Co 2] [!] CT:BLS 5012 MILLERS STATION RD HAMP BOX:0214 DUE:X49 FR2 [89]
[Co 2] [!] CT:BLS 3825 SHILOH AV @HIGHFIELD APTS APT 2 HAMP BOX:0218 DUE:BM435 FR2 [88]
[Co 2] [!] CT:VC HAMPSTEAD PD @1112 S MAIN ST HAMP BOX:0218 DUE:X29 E23 [42]
[Co 2] [!] CT:VC 716 HOUCKSVILLE RD HAMP BOX:0203 DUE:X29 E23 [35]
[Co 2] [!] CT:VC 4652 MARKSMAN CT HAMP BOX:0217 DUE:X49 [34]
[Co 2] [!] CT:VC 4652 MARKSMAN CT HAMP BOX:0217 DUE:X29 E23 [33]
[Co 2] [!] CT:VC HAMPSTEAD BYP / RT 482 HAMP BOX:0260 DUE:E43 [01]
[Co 2] [!] CT:VC PANTHER DR / RT 482 HAMP BOX:0208 DUE:X29 [99]
[Co 2] [!] CT:VC RT 30 BYP / HANOVER PKE / SOU HAMP BOX:0261 DUE:X29 BM435 E23 BE432 [94]
[Co 2] [!] CT:VC RT 30 / / WOLF HILL DR HAMP BOX:0211 DUE:BM435 FR2 E23 BE432 [86]
[Co 2] [!] CT:VC MAPLE GROVE RD / RT 30 MANC BOX:0411 DUE:E23 [80]
[Co 2] [!] CT:ATR 2360 CONVEY DR MANC BOX:0416 DUE:T2 [14]
[Co 2] [!] CT:BF 1231 TECH CT WEST BOX:0307 DUE:E33 E61 E91 E101 RS6 TO3 T2 X37 CS9 [31]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:BTT446 TT6 [21]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:X99 [20]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:ET73 [19]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:BE493 E43 RS9 BM435 AU7 BS414 [18]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:E92 BT404 YT49 BR95 [17]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:CS9 [16]
[Co 2] [!] CT:HF 1216 WOODLAND CT HAMP BOX:0216 DUE:ET24 BE432 E23 BE422 E91 TO3 BET431 ET44 BTS434 X29 CS4 [15]
[Co 2] [!] CT:CHIM 4224 UPPER BECKLEYSVILLE RD HAMP BOX:0207 DUE:E23 E43 T2 X29 [97]
[Co 2] [!] CT:BRUSH 100 LEES MILL RD HAMP BOX:0213 DUE:BE422 BR95 [26]
[Co 2] [!] CT:BRUSH 100 LEES MILL RD HAMP BOX:0213 DUE:E23 BE432 B25 BB436 [25]
[Co 2] [!] CT:LOCAL 1311 BRILHART DR HAMP BOX:0221 DUE:E23 [56]
[Co 2] [!] CT:ALARM 1 4160 GIMLET DR HAMP BOX:0206 DUE:E23 [10]
[Co 2] [!] CT:TRANS CO 2 @1341 N MAIN ST HAMP BOX:0208 DUE:X99 [23]
[Co 2] [!] CT:TRANS CO 4 @3209 MAIN ST MANC BOX:0404 DUE:TR1 E23 [13]
[Co 2] [!] CT:SERVICE DAVE RILL RD / NORTHSIDE ST HAMP BOX:0215 DUE:B25 [05]
[Co 2] [!] CT:SERVICE PANTHER DR / RT 482 HAMP BOX:0208 DUE:B25 [98]
[Co 2] [!] CT:PA 4862 UPPER BECKLEYSVILLE RD HAMP BOX:0207 DUE:ET24 [46]
[Co 2] [!] CT:MA BOX 60-18 19907 YORK RD VCR TG44 BOX:BC DUE:T2 [41]
[Co 2] [!] CT:MA 42-2 RT 30/ EMORY RD RESCUE TG 46 BOX:BC DUE:E23 [39]
[Co 2] [!] CT:MA 42-2 RT 30/ EMORY RD RESCUE TG 46 BOX:BC DUE:T2 [38]
[Co 2] [!] CT:MA 43-8 4607 MT CARMEL RD CARDIAC ARREST BOX:BC DUE:E23 [36]
[Co 2] [!] CT:MA BOX 43-15 4313 CHURCH RD UNCONSCIOUS PERSON BOX:BC DUE:X29 E23 [30]
[Co 2] [!] CT:MA 43-6 3948 MT ZION RD / DOVER RD TREE ON FIRE TG 43 BOX:BC DUE:E23 [84]
[Co 2] [!] CT:MA 44-35 3323 MT CARMEL RD C/S HUNTERGREEN RD SMOKE ALARM TG 41 BOX:BC DUE:E23 [81]
[Co 2] [!] CT:MA 45-20 3 TIMBER SHED CT / SLAB BRIDGE HOUSE FIRE BOX:BC DUE:T2 [78]
[Co 2] [!] CT:MA 43-1 18110 FALLS RD VCR BOX:BC DUE:T2 E23 X28 [76]
[Co 2] [!] CT:MA BC 43-15 20015 GRAVE RUN RD / HOFFMANVILLE RD TRAILER BOX:BC DUE:E23 RE72 T2 [72]
[Co 2] [!] CT:MA 43-15 19931 GRAVE RUN RD INJ AFTER FALL TG 43 BOX:BC DUE:E23 [57]
[Co 2] [!] CT:MA 60-12 18946 MIDDLETOWN RD / FOX CHASE CT SHED TG 44 BOX:BC DUE:T2 [54]
[Co 2] [!] CT:MA BOWIE STATION 14901 HEALTH CTR DR BOX:MC DUE:E23 [45]
[Co 2]  [!] CT:MA 43-2 16106 DARK HOLLOW RD / TRENTON RD HELO L/Z BOX:BC DUE:E23 [36]
[Co 2] [!] CT:MA 43-13 3907 BECKELYSVILLE RD / ABRAMS CT FIRE ALARM BOX:BC DUE:E23 [35]

Contact: james zuna <mtpockets316@yahoo.com>
Co14 / [!] CT:VC KLEE MILL RD S / LIBERTY RD W SYKE BOX:1416 DUE:X149 E141 [08]\n\n

*/

public class MDCarrollCountyParser extends FieldProgramParser {
  
  // List of call descriptions consisting for multiple words
  private static final String[] TWO_WORD_CALLS = new String[] {
    "BF RESC", "TRAIN AC", "TRAIN FI", "GAS LINE", "AMB TRANS"
  };
  
  private static final Pattern TRAIL_SEQ = Pattern.compile(" \\[\\d+\\]$");
  private static final Pattern BOX_PTN = Pattern.compile("\\d{2}-\\d{1,2}");
  private static final Pattern APT_PTN = Pattern.compile("(?:\\bAPT\\b|#) *([^ ]+)$");
  private static final Pattern CHANNEL_PTN = Pattern.compile(" TG *\\d{1,2}$");
  
  public MDCarrollCountyParser() {
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
      
      return false;
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
      "FINK", "FINKSBURG",
      "HAMP", "HAMPSTEAD",
      "MARR", "MARRIOTSVILLE",
      "LINE", "LINEBORO",
      "MANC", "MANCHESTER",
      "REIS", "REISTERSTOWN",
      "UPCO", "UPPERCO",
      "WEST", "WESTMINISTER",
      "KEYM", "KEYMAR",
      "UNBR", "UNION BRIDGE",
      "AIRY", "MT AIRY",
      "NWIN", "NEW WINDSOR",
      "SYKE", "SYKESVILLE",
      "TANE", "TANEYTOWN",
      "WOOD", "WOODBINE"
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
