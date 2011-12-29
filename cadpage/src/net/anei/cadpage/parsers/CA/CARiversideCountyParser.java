package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Riverside County, CA
Contact: JackPeckham <jackpeckham@idyllwildfire.com>
Sender: messaging@iamresponding.com

"IDYL" is Idyllwild, ca 92549 for mapping and "PINC" is Pine Cove but shows
up as Idyllwild, CA 92549 in Google maps

You will see one Dec. 22, 17:42 "IAF-LOWER WAYNE" this is a ringing alarm at
a school, Idyllwild Arts Foundation (IAF) & "Lower Wayne" is the building
name

MED, TRAFFIC COLLISION; 24630 UPPER RIM ROCK RD ,IDYL ; IFO ADDY SOLO VEH ROLLOVER; 24899 BLK AZALEA RD; 814_F_4/155__98; Inc# 118228; Cmd: RRU SUP 8; Tac: RVC TAC 0; M626; icy roads access from lower way
MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; ; 25778 BLK JOHNSON RD; 814_C_6/154__131; Inc# 119114; Cmd: RRU SUP 11; Tac: RVC TAC 0; M625; NO TEXT
MED, PERSON DOWN; 25280 NORWOOD DR ,PINC ; RX TO PRES MEDS; 52100 BLK ACORN LN; 813_H_5/154__116; Inc# 118213; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; NO TEXT
MED, FALL; TAHQUITZ CONFERENCE ASSOC @ 55251 S CIRCLE DR ,IDYL ; PT IN PLOT; 25000 BLK JOHN MUIR RD; 814_E_5/155__121; Inc# 118088; Cmd: RRU SUP 11; Tac: RVC TAC 0; STN621A ME621 M624; 659-2934
FMS, ELECTRICAL; 54912 WILDWOOD DR / 54860 S CIRCLE DR ,IDYL ; TREE FALLEN INTO SMALLER TREE; ; 814_E_6/155__133; Inc# 117897; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; hanging over power lines, not actually touching power lines-
FIRE, COMMERCIAL ALARM; 52500 TEMECULA DR ,IDYL ; IAF-LOWER WAYNE; 52200 BLK CAHUILLA DR; 843_J_1/154__164; Inc# 117832; Cmd: RRU SUP 11; Tac: RVC TAC 5; STN621A ME621 E23; fire alarm , rm #118 premise 951-659-2171
MED, FALL; 54915 S CIRCLE DR ,IDYL ; ILL, HEAD INJ; 54099 BLK MONTGOMERY ST; 814_E_6/155__133; Inc# 117490; Cmd: RRU SUP 11; Tac: RVC TAC 0; SQ621; 951-468-4043
MED, CHILD BIRTH; 52830 PINE COVE RD ,PINC ; ; 25056 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117230; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; e23 e/r, req amr
MED, FALL; 52735 OAK KNOLL RD ,PINC ; HEAD INJ; 25322 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117011; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; NO TEXT
MED, DIFFICULTY BREATHING; 54310 VALLEY VIEW DR ,IDYL ; ; 26500 BLK PINE AV; 814_D_7/154__156; Inc# 116620; Cmd: RRU SUP 8; Tac: RVC TAC 0; M625; White Jeep in driveway

 */

public class CARiversideCountyParser extends FieldProgramParser {
  
  public CARiversideCountyParser() {
    super("RIVERSIDE COUNTY", "CA",
           "CALL ADDR INFO? X MAP Inc:ID! Cmd:SRC! Tac:CH! UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace(" Inc# ", " Inc: ");
    return parseFields(body.split(";"), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = convertCodes(p.getLastOptional(','), CITY_CODES);
      data.strPlace =p.getOptional('@');
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains(" BLK ")) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "IDYL", "IDYLLWILD",
      "PINC", "PINE COVE"
  });
}
