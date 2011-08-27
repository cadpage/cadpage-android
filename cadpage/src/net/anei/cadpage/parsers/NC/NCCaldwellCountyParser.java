package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/* 
Caldwell County, NC
Contact: "justinwinebarger" <justinwinebarger@bellsouth.net>,8283127647@vtext.com
Contact: Mark Stallings <stalprint@gmail.com>
Contact: 8288509369@sms.alltelwireless.com
Sender: CAD@caldwellcountync.org
System: Sunguard OSSI

BREATHING PROBLEMS CHARLIE;25 WATER ST;GF;APT 12;CIRCLE ST;NORTH SUMMIT AV
CARDIAC RESP ARREST DEATH ECHO;5105 WENDOVER LN;GF;GUNPOWDER RD
FALL WITH PERSONAL INJURY;2998 CAMPGROUND RD;GF;SHELTON HOLLAR PL;C BELL MCRARY PL;1107150247
FALL WITH PERSONAL INJURY;WALMART GRANITE FALLS;4780 HICKORY BLVD;GF;GLEN RIDGE DR;RIVERBEND DR;1107160106
CARBON MONOXIDE DETECTOR ALARM;398 THOMPSON DR;HUD;SHADY OAK TER;HICKORY BLVD;1107200204
UNKNOWN MEDICAL CODE;1450 SHAIRE CENTER DR;LEN;APT 1;ANDREWS CIR;LOVEJOY ST;1108080045
UNCONSC FAINT NEAR DELTA;9 LIBERTY ST;GF;FALLS AV;1108100046

*/

public class NCCaldwellCountyParser extends FieldProgramParser {
  
  public NCCaldwellCountyParser() {
    super(CITY_CODES, "CALDWELL COUNTY", "NC",
           "CALL PLACE? ADDR/Z CITY APT? X/Z+? ID");
  }
  
  @Override
  public String getFilter() {
    return "CAD@caldwellcountync.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split(";"), data);
  }
  
  private class MyAptField extends AptField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("APT ")) return false;
      super.parse(field.substring(4).trim(), data);
      return true;
    }
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{10}"));
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }
  
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GF",   "GRANITE FALLS",
      "GMW",  "GAMEWELL",
      "GC",   "GRACE CHAPEL",
      "HUD",  "HUDSON",
      "KC",   "KINGS CREEK",
      "LEN",  "LENOIR",
      "LR",   "LITTLE RIVER",
      "NC",   "NORTH CATAWBA",
      "PATT", "PATTERSON",
      "RHOD", "RHODHISS",
      "SAW",  "SAWMILLS",
      "VAL",  "VALMEAD",
      "YAD",  "YADKIN VALLEY",
      "BETH", "BETHLEHEM"
  });
  
}
