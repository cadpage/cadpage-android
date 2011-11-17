package net.anei.cadpage.parsers.VA;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*Prince William County, VA (class I)
Contact: Rodney Fielding <rfielding@d-trs.com>
Sender: cc_message_notification@usamobility.net

29-Oct-2010/11:07:25/OUTF/15742 DUMFRIES RD / 15726 CARRS BROOKE WY ,PWC /17/E517 STA17 /ON NB  DUMFRIES RD  / BTW CARRS BROOK AND TODDBURY
29-Oct-2010/10:38:09/FALARM/15750 NORRIS POINT WY ,PWC /23/E510B STA23 TW512 /LANDING AT MARKHAM  /// 703-580-8121 /  GENERAL ALARM [72]
29-Oct-2010/09:41:32/INVEST/18911 FULLER HEIGHTS RD ,PWC /03F/E503B STA03F /CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO
29-Oct-2010/02:17:37/SICA/17428 KAGERA DR ,PWC /03R/E503B M503 STA03R /DAD HAVING POSS HEART ATTACK/ [60]
29-Oct-2010/09:21:10/UNC/18303 OLD TRIANGLE RD ,PWC /03R/E503B E523 M503 STA03R female screaming something is wrong w male in t he house .
28-Oct-2010/18:35:32/OUTF/CARBOROUGH ST / 19140 WINDSOR RD ,PWC /03R/E503B STA03R /BRUSH ON FIRE BESIDES THE HIGHWAY [53]
05-Nov-2010/10:08:33/FALARM/19043 FULLER HEIGHTS RD ,PWC (INSPIRATION > HOUSE DAY CARE)/03F/E503B STA03F TW512 /busn / 703 441 0997 / aud / ge

*/


public class VAPrinceWilliamCountyParser extends FieldProgramParser {
  
  public VAPrinceWilliamCountyParser() {
    super(CITY_CODES, "PRINCE WILLIAM COUNTY", "VA",
           "DATE TIME CODE ADDR X/Z+? BOX UNIT INFO+");
  }


  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("/"), data);
  }
  
  private class MyDateField extends DateField {
    public MyDateField() {
      setPattern("\\d\\d-[A-z][a-z]{2}-\\d{4}", true);
    }
  }
  
  private class MyTimeField extends TimeField {
    public MyTimeField() {
      setPattern("\\d\\d:\\d\\d:\\d\\d", true);
    }
  }
  
  private class MyCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      data.strCode = field;
      data.strCall = convertCodes(field, CALL_CODES);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String sPlace = p.getLastOptional('(');
      if (sPlace.endsWith(")")) sPlace = sPlace.substring(0, sPlace.length()-1).trim();
      data.strPlace = sPlace;
      data.strCity = convertCodes(p.getLastOptional(','), CITY_CODES);
      parseAddress(p.get(), data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) field = field.substring(0,pt).trim();
      
      // very occasionally, the address will be a cross street and the
      // cross street will be an address
      if (data.strCross.length() == 0 && field.length() > 0 && Character.isDigit(field.charAt(0)) &&
          (data.strAddress.length() == 0 || !Character.isDigit(data.strAddress.charAt(0)))) {
        data.strCross = data.strAddress;
        data.strAddress = "";
        parseAddress(field, data);
      } else {
        super.parse(field, data);
      }
    }
  }
  
  private class MyBoxField extends BoxField {
    public MyBoxField() {
      setPattern("\\d\\d[A-Z]?", true);
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("\\[(\\d+)]?$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_PTN.matcher(field);
      if (match.find()) {
        data.strCallId = match.group(1);
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO ID";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("BOX")) return new MyBoxField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "PWC", ""
  });
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
    "ASSA",   "Assault - ALS",
    "ASSB",   "Assault - BLS",
    "FALARM", "Fire Alarm",
    "INJB",   "Injury - BLS",
    "INJA",   "Injury - ALS",
    "INVEST", "Investigation",
    "SICA",   "Sickness - ALS",
    "SICB",   "Sickness - BLS",
    "UNC",    "Unconscious",
    
    "APT",    "Apartment Fire",
    "COMM",   "Commercial Fire",
    "HOUSE",  "House Fire",
    "OUTF",   "Outside Fire",
    "TH",     "Townhouse Fire",
  });
}