package net.anei.cadpage.parsers.DE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
New Castle County, DE
Contact: Jeff Hill <jeff.hill25@gmail.com>
Sender: rc.322@c-msg.net

(25CAD) [FB] F00 19:58 1 - T:69D5 (L3*MULTI-RESIDENTIAL FIRE) L:755 MONTCLAIR DR #2 ,PF *NAAMANS APTS - X:btwn NAAMANS RD ~ SOCIETY DR DESC: smoke fromneighbors
(25CAD) [FB] F00 12:11 1 - T:69D7 (L3*CHIMNEY FIRE) L:2007 FERNDALE DR ,X1 *WESTWOOD MANOR - X:btwn FORREST RD ~ VEALE RD DESC: chimney.?!?!
 [FB] F00 03:14 1 - T:69D6 (L3*RESIDENTIAL FIRE) L:108 CARLIE RD ,NT *LYNNFIELD - X:btwn HOMEWOOD RD ~ RIDGELAND RD
 [FB] F00 08:06 1 - T:55B2 (L1*ELECTRICAL HAZARD-WIRES DWN) L:ELGIN LA~SHIPLEY RD ,QB *OAK LANE MANOR - X: DESC: WIRES DOWN.?!?!
(25CAD) [FB] F00 01:38 1 - T:52C3S (L1*COMMERCIAL FIRE ALARM) L:4130 CONCORD PK ,HU06 -- 6TH AVE ELECTRONIC - X:btwn SILVERSIDE RD ~ PASSMORE RD DESC: fire alar
(25CAD) [FB] F00 08:35 1 - T:69D4O (L3*COMMERCIAL STRUC FIRE W~HZ) L:4238 PHILADELPHIA PK ,HU06 -- CLAYMONT STEEL PLA - LI:PLATE MILL - X:btwn ALCOTT AV ~ NAAMANS RD
(25CAD) [FB] F00 11:48 1 - T:52C3G (L1*COMMERCIAL FIRE ALARM) L:1801 AUGUSTINE CUT OFF ,HU06 -- ACCENTURE CONSULTI - X:btwn W EIGHTEENTH ST ~ STONE HILL RD DESC
(25CAD) [FB] F00 22:27 1 - T:52C1G (L1*FIRE ALARM~GENERAL) L:4641 WELDIN RD ,XF -- MARY CAMPBELL CNTR *WELDIN WOODS - X:btwn JACOB WELDIN PL ~ WELDIN CI DESC: F

15:50T:52B1G (L1*RES FIRE ALARM~GENERAL ALAR) L:401 CAMPBELL RD ,KC GREENVILLE - X:KENNETT PK ~ MINKER CT : afa.?!?!

 */


public class DENewCastleCountyParser extends FieldProgramParser {
  
  private static final Pattern[] MARKERS = new Pattern[]{
    Pattern.compile("^F00 \\d\\d:\\d\\d 1 - (?=T:\\d\\d)"),
    Pattern.compile("^\\d\\d:\\d\\d(?=T:\\d\\d)")
  };
  
  public DENewCastleCountyParser() {
    super("NEW CASTLE COUNTY", "DE",
           "T:CALL! L:ADDR! X:X DESC:INFO");
  }
  
  @Override
  public String getFilter() {
    return "rc.322@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    boolean found = false;
    for (Pattern ptn : MARKERS) {
      Matcher match = ptn.matcher(body);
      if (match.find()) {
        found = true;
        body = body.substring(match.end());
        break;
      }
    }
    if (!found) return false;
    
    if (subject.length() > 0) {
      String[] subjects = subject.split("\\|");
      if (! subjects[subjects.length-1].equals("FB")) return false;
      if (subjects.length == 2) data.strSource = subjects[0];
    }
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String fld, Data data) {
      Parser p = new Parser(fld);
      parseAddress(p.get(',').replaceAll("~","&"), data);
      p.get(' ');
      fld = p.get();
      if (fld.startsWith("*")) {
        fld = fld.substring(1).trim();
      } else if (fld.startsWith("--")) {
        fld = fld.substring(2).trim();
      }
      if (fld.endsWith("-")) {
        fld = fld.substring(0,fld.length()-1).trim();
      }
      data.strPlace = fld;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}


