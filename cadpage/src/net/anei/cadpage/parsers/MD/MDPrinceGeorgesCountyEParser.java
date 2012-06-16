package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Prince Georges County, MD (Replacement for C)
Contact: Christopher Olson <lilsmokeeater5@yahoo.com>
COtnact: Tommy Scaggs <rtscaggs@gmail.com>
Sender: @alert.co.pg.md.us

(CAD Feed) ALS1, Medic Local, 8500 MAGNOLIA DR, PP, btwn WOOD THRUSH DR and BLUE BIRD CT, TGA2, 4820, 5411 C 4, Medical ProQA recommends dispatch at this time, Units:A848, MD818 - From FED01 06/14/2012 19:47:08\n\n
PIAT, PIA w/Entrapment, NB CAP BELT OL A HWY AT NB INDIAN HEAD HWY, PP, at NB CAP BELT OL A HWY AT NB INDIAN HEAD HWY, PP <6298/0>, TGB3, 4219, 5765 A 2, 3 VEHICLE ACC, AT LEAST ONE BLU VEH INTO THE JERSEY WALL,..POSS ENTRAPPED... UNK INJ, Units:A847, BO885, E821B, MD847, PE842, SQ847 - From FED03 06/14/2012 19:31:19
(CAD Feed) ALS1, Medic Local, 7737 RIVERDALE RD #204, PP, btwn MAHONEY DR and ANNAPOLIS RD, NEW CARROLLTON, TGA2, 2831, 5410 K 7, Medical ProQA recommends dispatch at this time, Units:A830, E828, PE830 - From FED01 06/14/2012 19:11:54
STREET, Street Alarm, 3745 WILKINSON DR, PP, btwn CHERRY DR and PARK BLVD, SUITLAND, TC11, 2906, 5649 J 7, Fire ProQA recommends dispatch at this time, Units:BO883, E826B, E829B, QT838, TK832 - From FES01 06/14/2012 20:51:25
(CAD Feed) PIAT, PIA w/Entrapment, POWDER MILL RD/LAUREL BOWIE RD, PP,  <9999/ 11400>, LAUREL, TGB3, 1902, 5289 K 3, Police ProQA recommends dispatch at this time, Units:BO882, MD818 - From FED03 06/14/2012 22:19:35
(CAD Feed) HOUSEF, House Fire, 9300 ALLENTOWN RD, PP, btwn PINEHURST DR and CONSTANTINE DR, FORT WASHINGTON, TGC3, 3206, 5765 G 9, Fire ProQA recommends dispatch at this time, Units:BO885, E821B, E823B, E832B, PE842, SQ847, TK825, TK829 - From FED10 06/14/2012 22:25:10
(CAD Feed) PIAH, PIA Limited Access, SB CAP BELT IL A HWY/SB BALTIMORE WASHINGTON PKY SB, PP, at SB CAP BELT IL A HWY/SB BALTIMORE WASHINGTON PKY SB, PP, TGB3, 3516, 5410 J 2, COMPL ADV 2 CAR ACC BROWN MITSUBISHI VS GIANT FOOD TRACTOR TRAILER, UNK INJ, FEM MAY NEED AMBO. WILL NOTF MSP, Units:A830, E828 - From FED03 06/15/2012 00:59:09
ALS1, Medic Local, 7321 SPLIT RAIL LN, LP, btwn MILL CREEK CT and DORSET RD, LAUREL,MD, TGA2, 1013, 5168 K 3, Medical ProQA recommends dispatch at this time, Units:A724, E810C, HMD06 - From FED01 06/15/2012 13:11:28

*/

public class MDPrinceGeorgesCountyEParser extends FieldProgramParser {
  
  private static final Pattern TRAILER = Pattern.compile(" - From [A-Z0-9]+ (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)$");
  private static final Pattern AT_PTN = Pattern.compile("\\bAT\\b", Pattern.CASE_INSENSITIVE);
  
  public MDPrinceGeorgesCountyEParser() {
    super("PRINCE GEORGES COUNTY", "MD",
           "CODE CALL ADDR PP AT? X? PP2? ( CITY ST CH | CITY CH | CH! ) BOX MAP INFO+ Units:UNIT% UNIT+");
  }
  
  @Override
  public String getFilter() {
    return "@alert.co.pg.md.us,rc.505@c-msg.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = TRAILER.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      body = body.substring(0,match.start()).trim();
    }
    
    body = body.replace(" Unit:", " Units:");
    if (!parseFields(body.split(","), data)) return false;
    if (data.strUnit.length() == 0) data.strUnit = data.strSource;
    data.strAddress = AT_PTN.matcher(data.strAddress).replaceAll("&");
    
    // Truncated messages may confuse PP field for address
    if (data.strAddress.length() < 5 || data.strAddress.contains("<")) return false;
    
    if (data.strState.equals("MD")) data.strState = "";
    
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " DATE TIME";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames();
    }
  }
  
  // The AT field starts with an at keyword
  // It indicates that this is the real address, and what we originally
  // parsed as an address is a place name
  private class AtField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("at ")) return false;
      data.strPlace = data.strAddress;
      data.strAddress = "";
      parse(field.substring(3).trim(), data);
      if (data.strAddress.equals(data.strPlace)) data.strPlace = "";
      return true;
    }
  }
  
  // Cross field only exist if it has the correct keyword
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("btwn ")) return false;
      field = field.substring(5).trim();
      super.parse(field, data);
      return true;
    }
  }
  
  // Info field drops ProQA comments
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.contains("ProQA recommends dispatch")) return;
      super.parse(field, data);
    }
  }
  
  // Unit fields join together with comma separators
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, ",", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PP")) return new SkipField("[A-Z]{1,2}|", true);
    if (name.equals("AT")) return new AtField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PP2")) return new SkipField("[A-Z]{1,2} *(?:<\\d.*)?|<\\d.*|", true);
    if (name.equals("CH")) return new ChannelField("T?G?[A-F]\\d{1,2}", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }

  
  @Override
  public String adjustMapAddress(String sAddress) {
    // Undo various abbreviations of CAPITAL BELTWAY
    return CAP_BELT_PTN.matcher(sAddress).replaceAll("CAPITAL BELTWAY");
  }
  private static final Pattern CAP_BELT_PTN = 
      Pattern.compile("\\bCAP BELT(?:WAY)?(?: OL [A-Z]{1,2})(?: HWY)?\\b", Pattern.CASE_INSENSITIVE);
}
