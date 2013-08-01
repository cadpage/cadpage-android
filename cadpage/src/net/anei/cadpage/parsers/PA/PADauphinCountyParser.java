package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Dauphin County, PA
 */
public class PADauphinCountyParser extends FieldProgramParser {
  
  public PADauphinCountyParser() {
    super(CITY_CODES, "DAUPHIN COUNTY", "PA",
           "Box:BOX! Loc:ADDR/S XSts:X Event_Type:CALL! Class:PRI! Disp:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] flds = subject.split("\\|");
    if (flds[flds.length-1].equals("!")) {
      if (flds.length > 1) data.strSource = flds[0];
    }

    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0) {
      data.strAddress = data.strCross.replace('/', '&');
      data.strCross = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram().replace(" X ", " ADDR X ");
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(": @");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" ,", " / ");
      super.parse(field, data);
    }
  }
  
  // Sometimes there is some funy stuff at the end of the message that needs to be eliminated
  private static final Pattern UNIT_PTN = Pattern.compile("^([-/A-Z0-9, ]*)");
  private class MyUnitField extends UnitField {
    @Override 
    public void parse(String field, Data data) {
      Matcher match = UNIT_PTN.matcher(field);
      if (match.find()) field = match.group(1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
                   
      "BEB DAUP",  "BERRYSBURG",
      "CWT DAUP",  "CONEWAGO TWP",
      "DAB DAUP",  "DAUPHIN",
      "DRY DAUP",  "DERRY TWP",
      "EHT DAUP",  "EAST HANOVER TWP",
      "ELZ DAUP",  "ELIZABETHVILLE",
      "GRB DAUP",  "GRATZ",
      "HBG DAUP",  "HARRISBURG",
      "HFT DAUP",  "HALIFAX TWP",
      "HFX DAUP",  "HALIFAX",
      "HSP DAUP",  "HIGHSPIRE",
      "HUM DAUP",  "HUMMELSTOWN",
      "JFT DAUP",  "JEFFERSON TWP",
      "JKT DAUP",  "JACKSON TWP",
      "LDT DAUP",  "LONDONDERRY TWP",
      "LPT DAUP",  "LOWER PAXTON TWP",
      "LST DAUP",  "LOWER SWATARA TWP",
      "LYK DAUP",  "LYKENS",
      "LYT DAUP",  "LYKENS TWP",
      "MDT DAUP",  "MIDDLETOWN",
      "MFT DAUP",  "MIFFLIN TWP",
      "MPT DAUP",  "MIDDLE PAXTON TWP",
      "MSB DAUP",  "MILLERSBURG",
      "PAX DAUP",  "PAXTANG",
      "PEN DAUP",  "PENBROOK",
      "PLB DAUP",  "PILLOW",
      "RDT DAUP",  "REED TWP",
      "ROY DAUP",  "ROYALTON",
      "RUS DAUP",  "RUSH TWP",
      "SHT DAUP",  "SOUTH HANOVER TWP",
      "STL DAUP",  "STEELTON",
      "SUS DAUP",  "SUSQUEHANNA TWP",
      "SWT DAUP",  "SWATARA TWP",
      "UPT DAUP",  "UPPER PAXTON TWP",
      "WHT DAUP",  "WEST HANOVER TWP",
      "WIC DAUP",  "WICONISCO",
      "WIL DAUP",  "WILLIAMSTOWN",
      "WLT DAUP",  "WILLIAMS TWP",
      "WST DAUP",  "WASHINTON TWP",
      "WYT DAUP",  "WAYNE TWP",

      // Cumberland County
      "EPEN CUMB", "EAST PENNSBORO TWP",
      "SVSP CUMB", "SILVER SPRING TWP", 
      
      // Lancaster County
      "EZAB LANC", "ELIZABETHTOWN",
      "MTJT LANC", "MT JOY TWP",
      
      // Lebanon County
      "SLON LEBA", "SOUTH LONDONDERRY TWP",
      
      // Northumberland County
      "JKST NORT", "JACKSON TWP",
      "JORD NORT", "JORDAN TWP",
      "HNDB NORT", "HERNDON",
      
      // Perry County
      "RYET PERR", "RYE TWP",
      "WTFD PERR", "WHEATFIELD TWP"

  });
}
