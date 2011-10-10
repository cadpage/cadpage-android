package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Wadsworth, OH (in Medina County)
Contact: Ralph Copley <rcopley@wadsworthcity.org>
Sender: info@sundance-sys.com
(From: WadsTextSender) 0,,COLLEGE/MAIN,WADSWORTHMVA,MVA (EMS) (INJURY)MVA...NECK PAIN
(From: WadsTextSender) 194,BALDWIN ST,,WADSWORTH  HART,HEART67 YOF CHEST PAINS
(From: WadsTextSender) 250,SMOKERISE DR,LIBERTY RESIDENCE,WADSWORTHPAIN,PAINRM 124   STOMACH PAIN   LIBERTY ONE
(From: WadsTextSender) 230,GREAT OAKS TR,101WHITE OAK VILLAGE,WADSWORTHASST,INV. ASSIST80 YOF GENERAL PAIN / NOT FEELING WELL / PMHX CVA - MEDICAL ALARM
(From: WadsTextSender) 295,WALL RD,,WADSWORTH  GRAS,GRASS/TREE/BRUSH FIRESGRASS FIRE
(From: WadsTextSender) 269,E WALNUT ,,WADSWORTH WEAK,WEAKNESSFEMALE WEAK / HISTORY OF STROKES

Contact: Dave Cleckner <dcleckner@gmail.com>
(From: WadsTextSender) 100,HIGH ST,,WADSWORTH\2sPAIN,PAINFEMALE CHEST PAIN 66 YOF

**NOT IMPLEMENTED **
(From: WadsTextSender) * FireMVA,MVA (EMS) (INJURY) * 0,STATE ROUTE 57/GREENWICH RD, * STATE ROUTE 57/GREENWICH RD,WADSWORTH * MVA W/ INJURIES 3 CARS
(From: WadsTextSender) * EMSWEAK,WEAKNESS * 147,GARFIELD AV, * ALTERCARE,WADSWORTH * PATIENT CODING ON FLOOR IN 400 HALL

 */


public class OHWadsworthParser extends FieldProgramParser {
  
  private static final String[] CITY_LIST = new String[]{
    "WADSWORTH"
  };
  
  public OHWadsworthParser() {
    super("WADSWORTH", "OH",
           "HNUM ADDR PLACE? CITY! INFO");
  }
  
  @Override
  public String getFilter() {
    return "info@sundance-sys.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.contains("WadsTextSender")) return false;
    return parseFields(body.split(",+"), data);
  }
  
  private class HouseNumberField extends Field {
    @Override
    public void parse(String field, Data data) {
      if (!field.equals("0")) data.strAddress = field;
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = append(data.strAddress, " ", field);
      data.strAddress = "";
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      for (String city : CITY_LIST) {
        if (field.startsWith(city)) {
          data.strCity = city;
          data.strCall = field.substring(city.length()).trim();
          return true;
        }
      }
      return false;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "CITY CALL";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("HNUM")) return new HouseNumberField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
}
