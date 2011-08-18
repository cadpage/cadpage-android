package net.anei.cadpage.parsers.GA;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Henry County, GA
Contact: Stan Jones <sjones@co.henry.ga.us>
Contact: Stan Jones <hcboc045@gmail.com>
Contact: 6783003350@messaging.sprintpcs.com
Sender: 93001nnn

VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/./113F/04:29:42/ 
VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/E2/04:29:42/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/./R1/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/2129/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/
AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./E2/15:38:30/
AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./R2/15:38:30/
AUTO ACCIDENT WITH INJURIES/216 N I75/EXIT 69/WHI CHEVY TRUCK/TOYT/E2/13:14:05/
AUTO ACCIDENT WITH INJURIES/221 N I75/EXIT 71/JUST BEFORE EXIT 221/E1/16:28:24
HOUSE FIRE/8506 ABINGTON DR/THE ARBORS AT EAGLES BROOKE/FROM I75, SOUTH ON 155.LEFT TO GREENWOOD INDUSTRIAL PKW. RIGHT TO/
VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/E2/04:29:42/
33 HOUSE FIRE/724 PATRIOTS POINT ST/dryer is on fire..whole house is smoked up/R2/04:53:22/
HOUSE FIRE/140 DAILEY MILL RD/in b/t 140 and 150 dailey mill rd/L1 S1 E8 E3/18:59:45/
AUTO ACCIDENT WITH INJURIES/221 S I75/EXIT 71/female hit her head on side window and neck is tight/R9/15:25:28/
HOUSE FIRE/5164 HERON BAY BLV/E2 Q52 B1 L1 S1/10:57:25/

*/
public class GAHenryCountyParser extends FieldProgramParser {
  
  public GAHenryCountyParser() {
    super("HENRY COUNTY", "GA",
           "CALL! ADDR! INFO+? UNIT TIME");
  }
  
  @Override
  public String getFilter() {
    return "93001";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("/"), data);
  }
  
  private class MyAddressField extends AddressField{
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" INTERSECTN")) field = field.substring(0, field.length()-11).trim();
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "/", field);
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d:\\d\\d"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TIME")) return new TimeField();
    return super.getField(name);
  }
}
