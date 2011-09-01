package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Erie County, PA (Variant B)
Contact: Doug Johnson <dougjohnson6@gmail.com>
Sender: wececc@verizon.net

Ill Patient - 32 W PEARL STREET - Barnett Building  (PRE-PLAN) - APT 210 - Juliet Street & Academy Street
Anaphylaxis - 9004 ROUTE 215 -  - HANSON RESIDENCE - CONNEAUT TWP LINE & WOOD ROAD
Cardiac - 155 E STATE STREET - Albion Family Practice  (PRE-PLAN) - Wells Avenue & Elk Street
MVA - 126 E STATE STREET -  - Water Street & Wells Avenue
Chest Pain - E STATE STREET & First Avenue -  - MEET PD -
Ill Patient - 10745 ROUTE 18 - SCI-Albion  (PRE-PLAN) - USE FRONT ENTRANCE - Boro / Township Line & Carter Road
Fire Alarm -- Business - 32 W PEARL STREET - Barnett Building  (PRE-PLAN) - Juliet Street & Academy Street
Ill Patient - 10745 ROUTE 18 - SCI-Albion  (PRE-PLAN) - Boro / Township Line & Carter Road
Fracture - 2 W STATE STREET - Country Fair - MEET PD - Main Street & Academy Street
Cardiac - 210 E STATE STREET - Northwest Area Health Center  (PRE-PLAN) - Orchard Street & Third Avenue
Unresponsive Patient - 44 WALNUT STREET - SHERMAN RESIDENCE - Thornton Avenue & Euclid Street

General alerts!
2ND TAP MEDICAL ALARM  32 WEST PEARL STREET.  DRIVER NEEDED
2ND TAP EMS SCI ALBION FRONT ENTRANCE CHEST PAIN.  DC/WCE.
2ND TAP SCI ALBION ABDOMINAL PAIN SS/WCE

 */


public class PAErieCountyBParser extends FieldProgramParser {
  
  public PAErieCountyBParser() {
    super("ERIE COUNTY", "PA",
           "CALL ADDR PLACE+? X");
  }
  
  @Override
  public String getFilter() {
    return "wececc@verizon.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.endsWith(" -")) body = body.substring(0,body.length()-2).trim();
    String[] flds = body.split(" - ");
    if (flds.length < 4) return false;
    return parseFields(flds, data);
  }
  
  
  private class MyPlaceField extends AptField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("APT ")) {
        data.strApt = append(data.strApt, " - ", field.substring(4).trim());
      } else {
        data.strPlace = append(data.strPlace, " - ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE APT";
    }
  }
  
  // Cross field only valid if it contains an &
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains("&")) return false;
      data.strCross = field;
      return true;
    }
    
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
